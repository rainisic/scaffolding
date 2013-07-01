/* @(#) Project.java
 * Project:	web-commons
 * Package: cn.videoworks.webdev.commons.vo
 * Author:	rainisic
 * Date:	Jun 17, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.commons.vo;

/**
 * Contains the project parameters.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class Project {

	/** Identifier of the project. */
	private String name;

	/** The project title. Will be displayed in the website title. */
	private String title;

	/** Base path for include static resources(JS, CSS, Images, etc.). */
	private String staticDomain;

	/**
	 * Default constructor.
	 */
	public Project() {
	}

	/**
	 * Create an instance with project name, title and static domain.
	 * 
	 * @param name
	 *            the project name to set.
	 * @param title
	 *            the project title to set.
	 * @param staticDomain
	 *            the static resources domain.
	 */
	public Project(String name, String title, String staticDomain) {
		this.name = name;
		this.title = title;
		this.staticDomain = staticDomain;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the staticDomain
	 */
	public String getStaticDomain() {
		return staticDomain;
	}

	/**
	 * @param staticDomain
	 *            the staticDomain to set
	 */
	public void setStaticDomain(String staticDomain) {
		this.staticDomain = staticDomain;
	}
}