/* @(#) AdvancedMongoDBDao.java
 * Project:	dao-commons
 * Package: com.rainisic.commons.dao.mongo
 * Author:	rainisic
 * Date:	Jul 2, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.commons.dao.mongo;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author rainisic
 * 
 */
public class AdvancedMongoDBDao<T> {

	/** Inject MongoDB Operations. */
	@Resource
	protected MongoOperations operations;

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

	/**
	 * Persist the given transient instance.
	 * 
	 * @param entity
	 *            The transient instance to persist.
	 */
	public void save(T entity) {
		operations.save(entity);
	}

	/**
	 * Persist all transient instances in the given collection.
	 * 
	 * @param entities
	 *            The transient instance collection to persist.
	 */
	public void save(Collection<T> entities) {
		for (T entity : entities) {
			save(entity);
		}
	}

	/**
	 * Persist all given transient instances.
	 * 
	 * @param entities
	 *            The transient instance array to persist.
	 */
	public void save(@SuppressWarnings("unchecked") T... entities) {
		for (T entity : entities) {
			save(entity);
		}
	}

	/**
	 * Returns a document with the given id mapped onto the given class.
	 * 
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance, or null if not found
	 */
	public T get(Serializable id) {
		return operations.findById(id, clazz);
	}
	
	public List<T> list() {
		return operations.findAll(clazz);
	}
}
