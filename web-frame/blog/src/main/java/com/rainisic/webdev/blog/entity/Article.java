/* @(#) Article.java
 * Project:	blog
 * Package: com.rainisic.webdev.blog.entity
 * Author:	rainisic
 * Date:	Jul 2, 2013
 * Copyright © 2010-2013 by Beijing Novel-SuperTV Digital TV Technology Co., Ltd. All rights reserved.
 */
package com.rainisic.webdev.blog.entity;

import java.sql.Date;

/**
 * Article entity class.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class Article {

	/** Article identifier. */
	private String id;

	/** Article title. */
	private String title;

	/** Article content. */
	private String content;

	/** Article publish time. */
	private Date publishTime;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the publishTime
	 */
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishTime
	 *            the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
}
