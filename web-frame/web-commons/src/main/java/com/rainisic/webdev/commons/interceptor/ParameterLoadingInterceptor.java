/* @(#) ParameterLoadingInterceptor.java
 * Project:	web-commons
 * Package: com.rainisic.webdev.commons.interceptor
 * Author:	rainisic
 * Date:	Jul 1, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.commons.interceptor;

import static com.rainisic.webdev.commons.props.ApplicationConfiguration.getProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rainisic.webdev.commons.vo.Project;
import com.rainisic.webdev.commons.vo.SEO;

/**
 * Load parameters to current request.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class ParameterLoadingInterceptor extends HandlerInterceptorAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// Set project name and project title.
		request.setAttribute("project", new Project(
				getProperty("project.name"), getProperty("project.title"),
				getProperty("project.static_domain")));

		// Set SEO parameters.
		request.setAttribute("seo", new SEO(getProperty("seo.keywords"),
				getProperty("seo.description")));

		return true;
	}
}
