/* @(#) ArticleDao.java
 * Project:	blog
 * Package: com.rainisic.webdev.blog.dao
 * Author:	rainisic
 * Date:	Jul 2, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.blog.dao;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.rainisic.commons.dao.mongo.AdvancedMongoDBDao;
import com.rainisic.webdev.blog.entity.Article;

/**
 * Article DAO class.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class ArticleDao extends AdvancedMongoDBDao<Article> {

	/**
	 * Query article by URI.
	 * 
	 * @param uri
	 *            Article URI.
	 * @return Query result with the given identifier, or null if not found.
	 */
	public Article getByURI(String uri) {

		// Create query.
		Query query = new Query(Criteria.where("uri").is(uri));
		return this.operations.findOne(query, Article.class);
	}

	public void update(Article article) {

		// Query by URI.
		Query query = new Query(Criteria.where("uri").is(article.getUri()));

		// Update title and content.
		Update update = new Update()
			.set("uri", article.getUri())
			.set("title", article.getTitle())
			.set("content", article.getContent());

		// Execute modify.
		this.operations.updateMulti(query, update, Article.class);
	}
}
