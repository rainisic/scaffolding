/* @(#) ArticleService.java
 * Project:	blog
 * Package: com.rainisic.webdev.blog.service
 * Author:	rainisic
 * Date:	Jul 3, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.blog.service;

import java.util.List;

import com.rainisic.webdev.blog.entity.Article;
import com.rainisic.webdev.commons.vo.Page;

/**
 * @author rainisic
 * 
 */
public interface ArticleService {

	/**
	 * Save article.
	 * 
	 * @param article
	 *            Article to save.
	 */
	public void save(Article article);

	/**
	 * Update article.
	 * 
	 * @param article
	 *            Article to update.
	 */
	public void update(Article article);

	/**
	 * Display article by URI.
	 * 
	 * @param uri
	 *            Article URI.
	 * @return Article.
	 */
	public Article display(String uri);

	/**
	 * List article and paging.
	 * 
	 * @param page
	 *            Paging restrictions.
	 * @return Article list.
	 */
	public List<Article> list(Page page);

}
