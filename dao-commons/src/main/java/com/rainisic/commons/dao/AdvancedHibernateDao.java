/* @(#) AdvancedHibernateDao.java
 * Project:	dao-commons
 * Package: com.rainisic.commons.dao
 * Author:	rainisic
 * Date:	Jul 1, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.commons.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Provide advanced hibernate access functions.<br>
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class AdvancedHibernateDao<T> {

	/** Inject hibernate template. */
	@Resource
	protected HibernateTemplate hibernateTemplate;

	/** Class type. */
	private final Class<T> clazz;

	/**
	 * Default constructor.
	 */
	public AdvancedHibernateDao() {

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
		hibernateTemplate.save(entity);
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
	 * Update the given persistent instance.
	 * 
	 * @param entity
	 *            The persistent instance to update
	 */
	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	/**
	 * Update all persistent instances in the given collection.
	 * 
	 * @param entities
	 *            the persistent instance collection to update
	 */
	public void update(Collection<T> entities) {
		for (T entity : entities) {
			update(entity);
		}
	}

	/**
	 * Update all given persistent instances.
	 * 
	 * @param entities
	 *            the persistent instance array to update
	 */
	public void update(@SuppressWarnings("unchecked") T... entities) {
		for (T entity : entities) {
			update(entity);
		}
	}

	/**
	 * Save or update the given persistent instance, according to its id
	 * (matching the configured "unsaved-value"?).
	 * 
	 * @param entity
	 *            the persistent instance to save or update.
	 */
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	/**
	 * Save or update all persistent instances in the given collection,
	 * according to its id (matching the configured "unsaved-value"?).
	 * 
	 * @param entities
	 *            the persistent instance collection to save or update.
	 */
	public void saveOrUpdate(Collection<T> entities) {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

	/**
	 * Save or update all given persistent instances, according to its id
	 * (matching the configured "unsaved-value"?).
	 * 
	 * @param entities
	 *            the persistent instance collection to save or update.
	 */
	public void saveOrUpdate(@SuppressWarnings("unchecked") T... entities) {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

	/**
	 * Delete the given persistent instance.
	 * 
	 * @param entity
	 *            the persistent instance to delete
	 */
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	/**
	 * Delete all persistent instances in the given collection.
	 * 
	 * @param entities
	 *            the persistent instance collection to delete.
	 */
	public void delete(Collection<T> entities) {
		for (T entity : entities) {
			delete(entity);
		}
	}

	/**
	 * Delete all given persistent instances.
	 * 
	 * @param entities
	 *            the persistent instance array to delete.
	 */
	public void delete(@SuppressWarnings("unchecked") T... entities) {
		for (T entity : entities) {
			delete(entity);
		}
	}

	/**
	 * Delete persistent instance by the given identifier.
	 * 
	 * @param id
	 *            The identifier.
	 */
	public void delete(Serializable id) {
		delete(get(id));
	}

	/**
	 * Delete all persistent instances by the given identifiers.
	 * 
	 * @param ids
	 *            The identifier array.
	 */
	public void delete(Serializable... ids) {
		for (Serializable id : ids) {
			delete(id);
		}
	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if not found.
	 * 
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance, or null if not found
	 */
	public T get(Serializable id) {
		return hibernateTemplate.get(clazz, id);
	}

	/**
	 * Return all persistent instance.
	 * 
	 * @return containing 0 or more persistent instances
	 */
	@SuppressWarnings("unchecked")
	public List<T> list() {
		return hibernateTemplate.findByCriteria(DetachedCriteria
				.forClass(clazz));
	}

	/**
	 * Return all persistent instance. Limit by parameters.
	 * 
	 * @param firstResult
	 *            the index of the first result object to be retrieved (numbered
	 *            from 0)
	 * @param maxResults
	 *            the maximum number of result objects to retrieve (or <=0 for
	 *            no limit)
	 * @return containing 0 or more persistent instances
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(int firstResult, int maxResults) {
		return hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(clazz), firstResult, maxResults);
	}

	/**
	 * Get the total row count.
	 * 
	 * @return total row count.
	 */
	public int count() {
		return ((Long) hibernateTemplate
				.findByCriteria(
						DetachedCriteria.forClass(clazz).setProjection(
								Projections.rowCount())).iterator().next())
				.intValue();
	}
}
