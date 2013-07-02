/* @(#) AdvancedMongoDBDao.java
 * Project:	dao-commons
 * Package: com.rainisic.commons.dao.mongo
 * Author:	rainisic
 * Date:	Jul 2, 2013
 * Copyright © 2010-2013 by Beijing Novel-SuperTV Digital TV Technology Co., Ltd. All rights reserved.
 */
package com.rainisic.commons.dao.mongo;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author rainisic
 *
 */
public class AdvancedMongoDBDao<T> {

	@Resource
	private MongoOperations operations;
	
	/** Class type. */
	private final Class<T> clazz;

	/**
	 * Default constructor.
	 */
	public AdvancedMongoDBDao() {

		// Finalize class type.
		clazz = this.getParameterClass();
	}

	/**
	 * Get current class type.
	 * 
	 * @return Current instance class.
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getParameterClass() {
		return (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void save(T entity) {
		operations.save(entity);
	}
}
