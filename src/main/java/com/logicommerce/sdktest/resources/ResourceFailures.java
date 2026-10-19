package com.logicommerce.sdktest.resources;

import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import com.logicommerce.sdk.resources.PluginResourceException;

final class ResourceFailures {

	private final Class<?> resource;

	private final Set<String> methodNames;

	private final Map<String, PluginResourceException> methodFailures;

	private final Map<String, Deque<CountedFailure>> countedFailures;

	private PluginResourceException failure;

	ResourceFailures(Class<?> resource) {
		this.resource = resource;
		this.methodNames = Arrays.stream(resource.getMethods()).map(Method::getName).collect(Collectors.toSet());
		this.methodFailures = new HashMap<>();
		this.countedFailures = new HashMap<>();
	}

	synchronized void failWith(PluginResourceException exception) {
		failure = requireException(exception);
	}

	synchronized void failWith(String methodName, PluginResourceException exception) {
		methodFailures.put(requireMethod(methodName), requireException(exception));
	}

	synchronized void failWith(String methodName, PluginResourceException exception, int times) {
		requireMethod(methodName);
		requireException(exception);
		if (times < 1) {
			throw new IllegalArgumentException("times must be at least 1");
		}
		countedFailures.computeIfAbsent(methodName, key -> new ArrayDeque<>()).addLast(new CountedFailure(exception, times));
	}

	synchronized void clear() {
		failure = null;
		methodFailures.clear();
		countedFailures.clear();
	}

	synchronized void check(String methodName) throws PluginResourceException {
		Deque<CountedFailure> queue = countedFailures.get(methodName);
		if (queue != null && !queue.isEmpty()) {
			CountedFailure next = queue.peekFirst();
			next.remaining--;
			if (next.remaining == 0) {
				queue.removeFirst();
			}
			throw next.exception;
		}
		PluginResourceException exception = methodFailures.getOrDefault(methodName, failure);
		if (exception != null) {
			throw exception;
		}
	}

	private String requireMethod(String methodName) {
		if (!methodNames.contains(methodName)) {
			throw new IllegalArgumentException(resource.getSimpleName() + " has no method " + methodName);
		}
		return methodName;
	}

	private static PluginResourceException requireException(PluginResourceException exception) {
		if (exception == null) {
			throw new IllegalArgumentException("The exception must not be null");
		}
		return exception;
	}

	private static final class CountedFailure {

		private final PluginResourceException exception;

		private int remaining;

		private CountedFailure(PluginResourceException exception, int remaining) {
			this.exception = exception;
			this.remaining = remaining;
		}
	}

}
