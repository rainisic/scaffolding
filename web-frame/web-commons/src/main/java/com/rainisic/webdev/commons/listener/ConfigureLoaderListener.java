/* @(#) ConfigureLoaderListener.java
 * Project:	web-commons
 * Package: cn.videoworks.webdev.commons.listener
 * Author:	rainisic
 * Date:	Jun 17, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.commons.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.rainisic.webdev.commons.props.ApplicationConfiguration;

/**
 * Load properties from '.properties' file when web container starting.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class ConfigureLoaderListener implements ServletContextListener {

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {

		// Get application configuration location.
		String appConfigLocation = event.getServletContext().getInitParameter(
				"appConfigLocation");

		// Check application configuration file.
		if (appConfigLocation == null) {
			appConfigLocation = "classpath:config.properties";
		}

		// Load configuration file.
		if (appConfigLocation.startsWith("classpath:")) {

			// Load from classpath.
			ApplicationConfiguration.load(this.getClass().getResourceAsStream(
					"/" + appConfigLocation.substring(10).trim()));
		} else {

			// Load from Web root.
			ApplicationConfiguration.load(event.getServletContext()
					.getResourceAsStream(appConfigLocation.trim()));
		}
	}

}