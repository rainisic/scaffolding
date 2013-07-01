/* @(#) Page.java
 * Project:	web-commons
 * Package: cn.videoworks.webdev.commons.vo
 * Author:	LuoChuan
 * Date:	Jun 17, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.commons.vo;

import static com.rainisic.webdev.commons.props.ApplicationConfiguration.getProperty;
import org.apache.commons.lang3.StringUtils;

/**
 * Paging value object.<br>
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class Page {

	/** Default page size. */
	public static final int DEFAULT_SIZE = StringUtils
			.isBlank(getProperty("page.default_size")) ? Integer
			.parseInt(getProperty("page.default_size")) : 20;

	/** Current page index(Start from 0). */
	private int index;

	/** Total page count. */
	private int count;

	/** Page size. */
	private int size;

	/** Total record count. */
	private int recordCount;

	/**
	 * Create default page object.
	 */
	public Page() {
		this.index = 0;
		this.size = DEFAULT_SIZE;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index > 0 ? index - 1 : 0;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount
	 *            the recordCount to set
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		this.count = recordCount == 0 ? 1 : (recordCount + (size - 1)) / size;
	}
}
