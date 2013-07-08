/* @(#) ArticleServiceImpl.java
 * Project:	blog
 * Package: com.rainisic.webdev.blog.service.impl
 * Author:	rainisic
 * Date:	Jul 3, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rainisic.webdev.blog.dao.ArticleDao;
import com.rainisic.webdev.blog.entity.Article;
import com.rainisic.webdev.blog.service.ArticleService;
import com.rainisic.webdev.commons.vo.Page;

/**
 * @author rainisic
 * 
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	/** Inject article DAO. */
	@Resource
	private ArticleDao articleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rainisic.webdev.blog.service.ArticleService#save(com.rainisic.webdev
	 * .blog.entity.Article)
	 */
	@Override
	public void save(Article article) {
		articleDao.save(article);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rainisic.webdev.blog.service.ArticleService#update(com.rainisic.webdev
	 * .blog.entity.Article)
	 */
	@Override
	public void update(Article article) {
		articleDao.update(article);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rainisic.webdev.blog.service.ArticleService#display(java.lang.String)
	 */
	@Override
	public Article display(String uri) {
		return articleDao.getByURI(uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rainisic.webdev.blog.service.ArticleService#list(com.rainisic.webdev
	 * .commons.vo.Page)
	 */
	@Override
	public List<Article> list(Page page) {
		return articleDao.list();
	}
}
