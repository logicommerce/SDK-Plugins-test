package com.logicommerce.sdktest.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;
import com.logicommerce.sdk.resources.PluginResourceException;

class AtomicSharedStorageFakeTest {

	private static final String KEY = "lock";
	private static final Duration TTL = Duration.ofMinutes(5);
	private static final Duration TOO_LONG_TTL = Duration.ofMillis(Long.MAX_VALUE).plusMillis(1);

	private final MutableClock clock = new MutableClock();
	private final AtomicSharedStorageFake storage = new AtomicSharedStorageFake(clock);

	@Test
	void testPutIfAbsentKeepsTheFirstValue() throws PluginResourceException {
		assertNull(storage.putIfAbsent(KEY, "first", TTL));
		assertEquals("first", storage.putIfAbsent(KEY, "second", TTL));
		assertEquals("first", storage.get(KEY));
	}

	@Test
	void testReplaceAndRemoveCompareTheExpectedValue() throws PluginResourceException {
		storage.put(KEY, "first", TTL);
		assertFalse(storage.replace(KEY, "other", "second", TTL));
		assertTrue(storage.replace(KEY, "first", "second", TTL));
		assertFalse(storage.remove(KEY, "first"));
		assertTrue(storage.remove(KEY, "second"));
		assertNull(storage.get(KEY));
	}

	@Test
	void testEntriesExpire() throws PluginResourceException {
		storage.put(KEY, "value", TTL);
		clock.advance(TTL.minusSeconds(1));
		assertEquals(Duration.ofSeconds(1), storage.getTimeToLive(KEY));
		clock.advance(Duration.ofSeconds(1));
		assertNull(storage.get(KEY));
		assertEquals(0, storage.size());
		assertNull(storage.putIfAbsent(KEY, "again", TTL));
	}

	@Test
	void testConditionalOperationsSeeExpiredEntriesAsAbsent() throws PluginResourceException {
		storage.put(KEY, "value", TTL);
		clock.advance(TTL);
		assertFalse(storage.replace(KEY, "value", "next", TTL));
		assertFalse(storage.remove(KEY, "value"));
		assertFalse(storage.remove(KEY));
		storage.put(KEY, "7", TTL);
		clock.advance(TTL);
		assertEquals(1, storage.increment(KEY, 1, Duration.ofMinutes(1)));
		assertEquals(Duration.ofMinutes(1), storage.getTimeToLive(KEY));
	}

	@Test
	void testIncrementKeepsTheExpirationOfTheFirstCall() throws PluginResourceException {
		assertEquals(2, storage.increment(KEY, 2, TTL));
		clock.advance(Duration.ofMinutes(1));
		assertEquals(5, storage.increment(KEY, 3, TTL));
		assertEquals(TTL.minusMinutes(1), storage.getTimeToLive(KEY));
	}

	@Test
	void testIncrementOfANonIntegerFails() throws PluginResourceException {
		for (String value : new String[] { "value", "05", "+5", " 5", "-0", "1.5", "99999999999999999999" }) {
			storage.put(KEY, value, TTL);
			assertThrows(PluginResourceException.class, () -> storage.increment(KEY, 1, TTL), value);
			assertEquals(value, storage.get(KEY));
		}
	}

	@Test
	void testIncrementOverflowFailsAndKeepsTheCounter() throws PluginResourceException {
		storage.put(KEY, String.valueOf(Long.MAX_VALUE), TTL);
		assertThrows(PluginResourceException.class, () -> storage.increment(KEY, 1, TTL));
		assertEquals(String.valueOf(Long.MAX_VALUE), storage.get(KEY));
		assertEquals(Long.MAX_VALUE - 1, storage.increment(KEY, -1, TTL));
	}

	@Test
	void testTtlMustBePositiveAndNotTooLong() {
		assertThrows(IllegalArgumentException.class, () -> storage.put(KEY, "value", Duration.ZERO));
		assertThrows(IllegalArgumentException.class, () -> storage.put(KEY, "value", Duration.ofSeconds(-1)));
		assertThrows(IllegalArgumentException.class, () -> storage.put(KEY, "value", null));
		assertThrows(IllegalArgumentException.class, () -> storage.put(KEY, "value", TOO_LONG_TTL));
	}

	@Test
	void testSubMillisecondTtlLastsOneMillisecond() throws PluginResourceException {
		storage.put(KEY, "value", Duration.ofNanos(10));
		assertEquals(Duration.ofMillis(1), storage.getTimeToLive(KEY));
	}

	@Test
	void testInvalidArgumentsFailOnTheLosingPathToo() throws PluginResourceException {
		storage.put(KEY, "current", TTL);

		assertThrows(IllegalArgumentException.class, () -> storage.putIfAbsent(KEY, null, TTL));
		assertThrows(IllegalArgumentException.class, () -> storage.putIfAbsent(KEY, "value", Duration.ZERO));
		assertThrows(IllegalArgumentException.class, () -> storage.replace(KEY, "other", "next", Duration.ofSeconds(-1)));
		assertThrows(IllegalArgumentException.class, () -> storage.replace(KEY, "other", null, TTL));
		assertThrows(IllegalArgumentException.class, () -> storage.replace("missing", "other", "next", TOO_LONG_TTL));
		storage.put("counter", "1", TTL);
		assertThrows(IllegalArgumentException.class, () -> storage.increment("counter", 1, null));
		assertEquals("current", storage.get(KEY));
		assertEquals("1", storage.get("counter"));
	}

	@Test
	void testNullExpectedValueIsRejected() throws PluginResourceException {
		assertThrows(IllegalArgumentException.class, () -> storage.replace(KEY, null, "first", TTL));
		assertThrows(IllegalArgumentException.class, () -> storage.remove(KEY, null));
		storage.put(KEY, "first", TTL);
		assertThrows(IllegalArgumentException.class, () -> storage.replace(KEY, null, "second", TTL));
		assertThrows(IllegalArgumentException.class, () -> storage.remove(KEY, null));
		assertEquals("first", storage.get(KEY));
	}

	@Test
	void testNullKeyIsRejectedAndTheEmptyKeyIsValid() throws PluginResourceException {
		assertThrows(IllegalArgumentException.class, () -> storage.get(null));
		assertThrows(IllegalArgumentException.class, () -> storage.put(null, "value", TTL));
		assertThrows(IllegalArgumentException.class, () -> storage.remove(null));
		assertThrows(IllegalArgumentException.class, () -> storage.increment(null, 1, TTL));
		storage.put("", "value", TTL);
		assertEquals("value", storage.get(""));
	}

	@Test
	void testFailuresAfterArgumentValidation() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("down");
		storage.put(KEY, "value", TTL);
		storage.failWith("replace", failure);

		assertSame(failure, assertThrows(PluginResourceException.class, () -> storage.replace(KEY, "value", "next", TTL)));
		assertThrows(IllegalArgumentException.class, () -> storage.replace(KEY, null, "next", TTL));
		assertEquals("value", storage.get(KEY));

		storage.failWith(failure);
		assertSame(failure, assertThrows(PluginResourceException.class, () -> storage.get(KEY)));
		assertSame(failure, assertThrows(PluginResourceException.class, () -> storage.increment(KEY, 1, TTL)));
		storage.clearFailures();
		assertTrue(storage.replace(KEY, "value", "next", TTL));
		assertThrows(IllegalArgumentException.class, () -> storage.failWith("unknown", failure));
	}

	@Test
	void testTtlTheStoreCannotExpireFailsWhenTheEntryIsWritten() throws PluginResourceException {
		Duration forever = Duration.ofMillis(Long.MAX_VALUE);
		Duration longest = Duration.ofMillis(Long.MAX_VALUE - clock.instant().toEpochMilli());
		storage.put(KEY, "value", TTL);

		assertThrows(PluginResourceException.class, () -> storage.put("other", "value", forever));
		assertThrows(PluginResourceException.class, () -> storage.putIfAbsent("other", "value", forever));
		assertThrows(PluginResourceException.class, () -> storage.replace(KEY, "value", "next", forever));
		assertThrows(PluginResourceException.class, () -> storage.increment("counter", 1, forever));
		assertNull(storage.get("other"));
		assertNull(storage.get("counter"));
		assertEquals("value", storage.get(KEY));

		assertEquals("value", storage.putIfAbsent(KEY, "other", forever));
		assertFalse(storage.replace(KEY, "other", "next", forever));
		storage.put("other", "value", longest);
		assertEquals(longest, storage.getTimeToLive("other"));
	}

	@Test
	void testCountedFailuresThenSucceed() throws PluginResourceException {
		PluginResourceException failure = new PluginResourceException("conflict");
		storage.put(KEY, "value", TTL);
		storage.failWith("replace", failure, 1);

		assertSame(failure, assertThrows(PluginResourceException.class, () -> storage.replace(KEY, "value", "next", TTL)));
		assertTrue(storage.replace(KEY, "value", "next", TTL));
		assertEquals("next", storage.get(KEY));
	}

	@Test
	void testCountedFailuresKeepACountInsteadOfOneEntryPerCall() throws PluginResourceException {
		PluginResourceException first = new PluginResourceException("first");
		PluginResourceException second = new PluginResourceException("second");
		storage.put(KEY, "value", TTL);
		storage.failWith("get", first, Integer.MAX_VALUE);
		storage.failWith("replace", first, 2);
		storage.failWith("replace", second, 1);

		for (int i = 0; i < 1000; i++) {
			assertSame(first, assertThrows(PluginResourceException.class, () -> storage.get(KEY)));
		}
		assertSame(first, assertThrows(PluginResourceException.class, () -> storage.replace(KEY, "value", "next", TTL)));
		assertSame(first, assertThrows(PluginResourceException.class, () -> storage.replace(KEY, "value", "next", TTL)));
		assertSame(second, assertThrows(PluginResourceException.class, () -> storage.replace(KEY, "value", "next", TTL)));
		assertTrue(storage.replace(KEY, "value", "next", TTL));
		storage.clearFailures();
		assertEquals("next", storage.get(KEY));
	}

	private static class MutableClock extends Clock {

		private Instant now = Instant.parse("2026-10-19T10:00:00Z");

		void advance(Duration duration) {
			now = now.plus(duration);
		}

		@Override
		public ZoneId getZone() {
			return ZoneOffset.UTC;
		}

		@Override
		public Clock withZone(ZoneId zone) {
			return this;
		}

		@Override
		public Instant instant() {
			return now;
		}
	}
}
