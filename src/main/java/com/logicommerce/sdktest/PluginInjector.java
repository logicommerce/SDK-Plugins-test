package com.logicommerce.sdktest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import com.logicommerce.sdk.Aggregate;
import com.logicommerce.sdk.Initiator;
import com.logicommerce.sdk.Resource;
import com.logicommerce.utilities.Injector;

public class PluginInjector extends Injector {

	@Override
	protected boolean isInjectable(Field field) {
		return field.isAnnotationPresent(Resource.class) || field.isAnnotationPresent(Aggregate.class);
	}

	@Override
	protected boolean hasPostConstruct(Method method) {
		return method.isAnnotationPresent(Initiator.class);
	}

	@Override
	protected boolean isRequestScope(Class<?> clazz) {
		return false;
	}

}
