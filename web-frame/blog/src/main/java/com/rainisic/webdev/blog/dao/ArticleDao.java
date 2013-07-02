/* @(#) ArticleDao.java
 * Project:	blog
 * Package: com.rainisic.webdev.blog.dao
 * Author:	rainisic
 * Date:	Jul 2, 2013
 * Copyright © 2010-2013 by Beijing Novel-SuperTV Digital TV Technology Co., Ltd. All rights reserved.
 */
package com.rainisic.webdev.blog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.rainisic.webdev.blog.entity.Article;

/**
 * Article DAO class.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class ArticleDao {

	/** Inject MongoDB Operations. */
	@Autowired
	private MongoOperations operations;
	
	/**
	 * 
	 * @param article
	 */
	public void save(Article article) {
		operations.save(article);
	}
	
}
