package com.logicommerce.sdktest.resources;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerFake implements com.logicommerce.sdk.resources.Logger {
	
	private Logger logger; 

	@Override
	public void info(String... args) {
		log(Level.INFO, args);
	}

	@Override
	public void warning(String... args) {
		log(Level.WARNING, args);
	}

	@Override
	public void severe(String... args) {
		log(Level.SEVERE, args);
	}

	public void log(Level level, String... args) {
		String message = Arrays.toString(args);
		getLogger().log(level, message);
	}

	private Logger getLogger() {
		if (logger == null)
			logger = Logger.getLogger("com.logicommerce.sdktest");
		return logger;		
	}

}
