package com.webapp.utils;

import org.apache.log4j.Logger;

public class Logging {

	// Initialize Log4j logs

	private static Logger LOGGER_INSTANCE = Logger.getLogger(Logging.class.getName());
	
	//Log to indicate the beginning of a test case
	public static void startTestCase(String TestCaseName) {

		LOGGER_INSTANCE
				.info("****************************************************************************************");

		LOGGER_INSTANCE
				.info("$$$$$$$$$$$$$$$$$$$$$      Starting " + TestCaseName + "      $$$$$$$$$$$$$$$$$$$$$$$$$");

		LOGGER_INSTANCE
				.info("****************************************************************************************");

	}
	
	//Ending of a test case
	public static void endTestCase() {

		LOGGER_INSTANCE.info("XXXXXXXXXXXXXXXXXXXXXXX             "
				+ "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

	}
	
	public static void info(String message) {

		LOGGER_INSTANCE.info(message);

	}

	public static void warn(String message) {

		LOGGER_INSTANCE.warn(message);

	}

	public static void error(String message) {

		LOGGER_INSTANCE.error(message);

	}

	public static void fatal(String message) {

		LOGGER_INSTANCE.fatal(message);

	}

	public static void debug(String message) {

		LOGGER_INSTANCE.debug(message);

	}


}
