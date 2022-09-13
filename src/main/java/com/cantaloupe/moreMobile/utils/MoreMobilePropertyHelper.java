package com.cantaloupe.moreMobile.utils;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Reads in from properties file and credentials file based on the environment the test is being run.
 * @author jroe
 *
 */
public class MoreMobilePropertyHelper {

	private static final Logger LOG = Logger.getLogger(String.valueOf(MoreMobilePropertyHelper.class));

	private final String CREDS_FILE = "CTLP_Automation_%s_credentials.properties";
	private static final String FILE_MATCHER = "%s.*\\.properties";

	private Properties props;

	public MoreMobilePropertyHelper() {

		String path = System.getProperty("user.home");
		String environment = System.getProperty("environment");

		if(environment==null || environment.isBlank()) {
			throw new RuntimeException("Environment is not set, unable to read properties file");
		}

		props = new Properties();

		try {

			// read in the creds file in the user home directory (stores username / pw)
			props.load(new FileInputStream(path + "/" +  String.format(CREDS_FILE, environment.toUpperCase())));

			// now read in all other property files
			String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			File[] files = new File(rootPath).listFiles();
			String filePattern = String.format(FILE_MATCHER, environment);
			// read in all test data properties file for the target environment (file must start with env name i.e. "DEV")
			for(int i = 0; i < files.length; i++) {
				if(files[i].getName().matches(filePattern))
				{
					props.load(new FileInputStream(rootPath + "/" + files[i].getName()));
				}
			}

		} catch (Exception e) {
			LOG.error("Error loading properties file: " + e.getMessage(), e);
			fail("Error loading properties file: " + e.getMessage());
		}
	}

	/**
	 * Gets the value of the property from the test data property file
	 * @param propertyName
	 * @return value or null if doesn't exist
	 */
	public String getProperty(String propertyName) {
		// first try to retrieve from creds
		String prop = props.getProperty(propertyName);
		// if not there, try main test data file
		if(prop == null) {
			throw new RuntimeException("Unable to locate property " + propertyName);
//			prop = props.getProperty(propertyName);
		}
		return prop;
	}

	/**
	 * Gets the value of the property from the test data property file
	 * @param propertyName
	 * @param defaultValue
	 * @return value or default value if doesn't exist
	 */
	public String getProperty(String propertyName, String defaultValue) {
		String prop = getProperty(propertyName);
		if(prop == null) {
			LOG.info("Unable to locate property " + propertyName + " returning default value " + defaultValue);
			prop = defaultValue;
		}
		return prop;
	}

}