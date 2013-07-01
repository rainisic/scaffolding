/* @(#) ApplicationConfiguration.java
 * Project:	web-commons
 * Package: cn.videoworks.webdev.commons.props
 * Author:	LuoChuan
 * Date:	Jun 17, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.commons.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Store the application configurations.<br>
 * Application configurations loading by
 * {@link com.rainisic.webdev.listener.ConfigureLoaderListener}.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class ApplicationConfiguration {

	/** Properties. */
	private static Properties properties = new Properties();

	/**
	 * Load application configuration.
	 * 
	 * @param stream
	 */
	public static void load(InputStream inStream) {

		try {
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get property value by given key.
	 * 
	 * @param key
	 *            property key.
	 * @return property value.
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * Get all properties.
	 * 
	 * @return all properties.
	 */
	public static Properties getProperties() {
		return properties;
	}
}