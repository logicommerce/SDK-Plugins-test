package com.logicommerce.sdktest.resources;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import com.logicommerce.sdk.resources.AtomicSharedStorage;
import com.logicommerce.sdk.resources.PluginResourceException;

/**
 * <p>In-memory {@link AtomicSharedStorage} for plugin tests. Every operation is synchronized, so the conditional
 * operations are atomic as in production, and every entry expires on its own after its time to live, measured on the
 * {@link Clock} given to the constructor (use a controllable clock to test expiration).</p>
 *
 * <p>Arguments are validated as production does, before the store is read and whatever the outcome: a null key,
 * value or expected value, and a null, zero, negative or longer than {@code Long.MAX_VALUE} milliseconds time to live,
 * throw an {@link IllegalArgumentException}. The empty key is valid. As in production, a time to live is truncated to
 * whole milliseconds and lasts at least one. {@link #increment(String, long, Duration) increment} throws a
 * {@link PluginResourceException} when the key holds a value that is not an integer (in the strict format the store
 * uses: no sign but {@code -}, no leading zeros, no blanks) or when the result overflows a {@code long}.</p>
 *
 * <p>A time to live that passes the argument check can still be one the store cannot honour: production writes an
 * entry with Redis {@code SET ... PX}, and the current time plus the time to live can overflow a {@code long} of
 * milliseconds. The fake follows Redis 7 semantics: Redis 7 refuses the command ("invalid expire time"), which reaches
 * the plugin as a {@link PluginResourceException}. Redis 6.x instead accepts it and silently drops the entry at once
 * (and {@link #increment(String, long, Duration) increment} then recreates the counter without any time to live).
 * The Redis version production runs is not pinned in the repositories, so plugins must avoid such a time to live
 * either way. The fake throws, measured on its clock, whenever an operation would write the entry: always for
 * {@link #put(String, String, Duration) put} and {@link #increment(String, long, Duration) increment}, and for
 * {@link #putIfAbsent(String, String, Duration) putIfAbsent} and {@link #replace(String, String, String, Duration)
 * replace} only when they would store the value. {@code Duration.ofMillis(Long.MAX_VALUE)} is therefore not a usable
 * "forever".</p>
 *
 * <p>{@link #failWith(PluginResourceException)} makes every operation throw the given
 * {@link PluginResourceException}, {@link #failWith(String, PluginResourceException)} every call of one method (a
 * method name covers its overloads), and {@link #failWith(String, PluginResourceException, int)} only the next calls
 * of that method, which then succeed again (to test a compare-and-set retry); counted failures are thrown first, and
 * the same exception instance every time. Failures are thrown after the arguments are validated and change nothing;
 * {@link #clearFailures()} undoes them.</p>
 */
public class AtomicSharedStorageFake implements AtomicSharedStorage {

	private static final Duration MAX_TTL = Duration.ofMillis(Long.MAX_VALUE);

	private static final Pattern INTEGER = Pattern.compile("0|-?[1-9][0-9]*");

	private final Map<String, Entry> data;

	private final Clock clock;

	private final ResourceFailures failures;

	public AtomicSharedStorageFake() {
		this(Clock.systemUTC());
	}

	public AtomicSharedStorageFake(Clock clock) {
		this.data = new HashMap<>();
		this.clock = clock;
		this.failures = new ResourceFailures(AtomicSharedStorage.class);
	}

	@Override
	public synchronized String get(String key) throws PluginResourceException {
		requireKey(key);
		failures.check("get");
		Entry entry = live(key);
		return entry == null ? null : entry.value;
	}

	@Override
	public synchronized void put(String key, String value, Duration ttl) throws PluginResourceException {
		requireValue(value, "value");
		requireTtl(ttl);
		requireKey(key);
		failures.check("put");
		Instant expiresAt = expiresAt(ttl);
		data.put(key, new Entry(value, expiresAt));
	}

	@Override
	public synchronized String putIfAbsent(String key, String value, Duration ttl) throws PluginResourceException {
		requireValue(value, "value");
		requireTtl(ttl);
		requireKey(key);
		failures.check("putIfAbsent");
		Entry entry = live(key);
		if (entry != null) {
			return entry.value;
		}
		Instant expiresAt = expiresAt(ttl);
		data.put(key, new Entry(value, expiresAt));
		return null;
	}

	@Override
	public synchronized boolean replace(String key, String expectedValue, String value, Duration ttl) throws PluginResourceException {
		requireValue(expectedValue, "expectedValue");
		requireValue(value, "value");
		requireTtl(ttl);
		requireKey(key);
		failures.check("replace");
		Entry entry = live(key);
		if (entry == null || !entry.value.equals(expectedValue)) {
			return false;
		}
		Instant expiresAt = expiresAt(ttl);
		data.put(key, new Entry(value, expiresAt));
		return true;
	}

	@Override
	public synchronized boolean remove(String key) throws PluginResourceException {
		requireKey(key);
		failures.check("remove");
		return live(key) != null && data.remove(key) != null;
	}

	@Override
	public synchronized boolean remove(String key, String expectedValue) throws PluginResourceException {
		requireValue(expectedValue, "expectedValue");
		requireKey(key);
		failures.check("remove");
		Entry entry = live(key);
		if (entry == null || !entry.value.equals(expectedValue)) {
			return false;
		}
		data.remove(key);
		return true;
	}

	@Override
	public synchronized long increment(String key, long amount, Duration ttl) throws PluginResourceException {
		requireTtl(ttl);
		requireKey(key);
		failures.check("increment");
		Instant expiresAt = expiresAt(ttl);
		Entry entry = live(key);
		if (entry == null) {
			data.put(key, new Entry(String.valueOf(amount), expiresAt));
			return amount;
		}
		long value;
		try {
			value = Math.addExact(parseCounter(key, entry.value), amount);
		} catch (ArithmeticException e) {
			throw new PluginResourceException("Incrementing " + key + " overflows", e);
		}
		data.put(key, new Entry(String.valueOf(value), entry.expiresAt));
		return value;
	}

	public void failWith(PluginResourceException exception) {
		failures.failWith(exception);
	}

	public void failWith(String methodName, PluginResourceException exception) {
		failures.failWith(methodName, exception);
	}

	public void failWith(String methodName, PluginResourceException exception, int times) {
		failures.failWith(methodName, exception, times);
	}

	public void clearFailures() {
		failures.clear();
	}

	public synchronized Duration getTimeToLive(String key) {
		requireKey(key);
		Entry entry = live(key);
		return entry == null ? null : Duration.between(clock.instant(), entry.expiresAt);
	}

	public synchronized int size() {
		Instant now = clock.instant();
		data.values().removeIf(entry -> !now.isBefore(entry.expiresAt));
		return data.size();
	}

	public synchronized void clear() {
		data.clear();
	}

	private Entry live(String key) {
		Entry entry = data.get(key);
		if (entry != null && !clock.instant().isBefore(entry.expiresAt)) {
			data.remove(key);
			return null;
		}
		return entry;
	}

	private Instant expiresAt(Duration ttl) throws PluginResourceException {
		Instant now = clock.instant();
		long ttlMillis = Math.max(1, ttl.toMillis());
		try {
			if (Math.addExact(now.toEpochMilli(), ttlMillis) > 0) {
				return now.plusMillis(ttlMillis);
			}
		} catch (ArithmeticException e) {
			throw new PluginResourceException("The store refuses the time to live " + ttl + ": invalid expire time", e);
		}
		throw new PluginResourceException("The store refuses the time to live " + ttl + ": invalid expire time");
	}

	private static long parseCounter(String key, String value) throws PluginResourceException {
		try {
			if (INTEGER.matcher(value).matches()) {
				return Long.parseLong(value);
			}
		} catch (NumberFormatException e) {
			throw new PluginResourceException("The value of " + key + " is not an integer or out of range", e);
		}
		throw new PluginResourceException("The value of " + key + " is not an integer or out of range");
	}

	private static void requireValue(String value, String name) {
		if (value == null) {
			throw new IllegalArgumentException(name + " is null");
		}
	}

	private static void requireTtl(Duration ttl) {
		if (ttl == null || ttl.isNegative() || ttl.isZero()) {
			throw new IllegalArgumentException("ttl must be positive");
		}
		if (ttl.compareTo(MAX_TTL) > 0) {
			throw new IllegalArgumentException("ttl is too long");
		}
	}

	private static void requireKey(String key) {
		if (key == null) {
			throw new IllegalArgumentException("key is null");
		}
	}

	private static final class Entry {

		private final String value;

		private final Instant expiresAt;

		private Entry(String value, Instant expiresAt) {
			this.value = value;
			this.expiresAt = expiresAt;
		}
	}

}
