package com.logicommerce.sdktest.resources;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class FakeCopier {

	private static final String FAKES_PACKAGE = "com.logicommerce.sdktest.models";

	private final Map<Object, Object> copies = new IdentityHashMap<>();

	private FakeCopier() {
	}

	static boolean isFake(Object value) {
		return value != null && value.getClass().getPackageName().startsWith(FAKES_PACKAGE) && findConstructor(value.getClass()) != null;
	}

	@SuppressWarnings("unchecked")
	static <T> T copy(T fake) {
		return (T) new FakeCopier().copyValue(fake);
	}

	private Object copyValue(Object value) {
		if (value == null) {
			return null;
		}
		if (copies.containsKey(value)) {
			return copies.get(value);
		}
		if (value instanceof List<?> list) {
			List<Object> copy = new ArrayList<>();
			copies.put(value, copy);
			list.forEach(element -> copy.add(copyValue(element)));
			return copy;
		}
		if (value instanceof Set<?> set) {
			Set<Object> copy = new LinkedHashSet<>();
			copies.put(value, copy);
			set.forEach(element -> copy.add(copyValue(element)));
			return copy;
		}
		if (value instanceof Map<?, ?> map) {
			Map<Object, Object> copy = new LinkedHashMap<>();
			copies.put(value, copy);
			map.forEach((key, element) -> copy.put(key, copyValue(element)));
			return copy;
		}
		return isFake(value) ? copyFake(value) : value;
	}

	private Object copyFake(Object fake) {
		try {
			Object copy = findConstructor(fake.getClass()).newInstance();
			copies.put(fake, copy);
			for (Class<?> type = fake.getClass(); type != null && type != Object.class; type = type.getSuperclass()) {
				copyFields(type, fake, copy);
			}
			return copy;
		} catch (ReflectiveOperationException | RuntimeException e) {
			throw new IllegalStateException("Cannot copy " + fake.getClass().getName(), e);
		}
	}

	private void copyFields(Class<?> type, Object fake, Object copy) throws IllegalAccessException {
		for (Field field : type.getDeclaredFields()) {
			if (Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			field.setAccessible(true);
			field.set(copy, copyValue(field.get(fake)));
		}
	}

	private static Constructor<?> findConstructor(Class<?> type) {
		try {
			Constructor<?> constructor = type.getDeclaredConstructor();
			constructor.setAccessible(true);
			return constructor;
		} catch (NoSuchMethodException e) {
			return null;
		}
	}

}
