package com.logicommerce.sdktest.resources.connection;

public final class ConnectionException extends Exception {

	private static final long serialVersionUID = 1L;

	protected final Class<?> clazz;

	protected final Exception exception;

	public ConnectionException(Class<?> clazz, Exception exception) {
		this.clazz = clazz;
		this.exception = exception;
	}


}
