/* @(#) ArticleController.java
 * Project:	blog
 * Package: com.rainisic.webdev.blog.web.article
 * Author:	rainisic
 * Date:	Jul 3, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.blog.web.article;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rainisic.webdev.blog.entity.Article;
import com.rainisic.webdev.blog.service.ArticleService;
import com.rainisic.webdev.commons.vo.Page;

/**
 * @author rainisic
 * 
 */
@Controller
@RequestMapping("article")
public class ArticleController {

	/** Inject article service. */
	@Resource
	private ArticleService articleService;

	/**
	 * Load article list.
	 * 
	 * @param model
	 *            Spring model map.
	 * @param page
	 *            Pagination.
	 * @return
	 */
	@RequestMapping("list")
	public String list(ModelMap model, String dataType, Page page) {

		// Query article list.
		List<Article> articles = articleService.list(page);

		// Add to model map.
		model.addAttribute("articles", articles);

		if (dataType != null && dataType.equals("raw")) {
			return "raw.article.list";
		} else {
			return "site.article.list";
		}
	}

	/**
	 * Display article.
	 * 
	 * @param model
	 *            Spring model map.
	 * @param uri
	 *            Article URI.
	 * @return Article display page.
	 */
	@RequestMapping(value = "{uri}", method = RequestMethod.GET)
	public String display(ModelMap model, String dataType, @PathVariable String uri) {

		// Query article.
		Article article = articleService.display(uri);

		// Add to model map.
		model.addAttribute("article", article);
		
		if (dataType != null && dataType.equals("raw")) {
			return "raw.article.display";
		} else {
			return "site.article.display";
		}
	}

	/**
	 * Get article JSON.
	 * 
	 * @param uri
	 *            Article URI.
	 * @return Article JSON.
	 */
	@RequestMapping("json/{uri}")
	@ResponseBody
	public Object json(@PathVariable String uri) {
		return articleService.display(uri);
	}

	/**
	 * Enter the editor page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "editor", method = RequestMethod.GET)
	public String editor(ModelMap model, String uri, String dataType) {

		if (uri != null) {
			Article article = articleService.display(uri);
			model.addAttribute("article", article);
		}
		
		if (dataType != null && dataType.equals("raw")) {
			return "raw.article.editor";
		} else {
			return "site.article.editor";
		}
	}

	/**
	 * 
	 * @param article
	 * @return
	 */
	@RequestMapping(value = "publish", method = RequestMethod.POST)
	@ResponseBody
	public Object publish(Article article) {

		// Define result map.
		Map<String, Object> result = new HashMap<String, Object>();
		
		// Set publish time.
		article.setPublishTime(Calendar.getInstance().getTime());

		// Save article.
		articleService.save(article);

		// Set execute result.
		result.put("statusCode", 200);
		result.put("message", "Publish article successfully.");
		return result;
	}
	
	/**
	 * 
	 * @param article
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(Article article) {
		
		// Define result map.
		Map<String, Object> result = new HashMap<String, Object>();
		
		// Update article.
		articleService.update(article);
		
		// Set execute result.
		result.put("statusCode", 200);
		result.put("message", "Update article successfully.");
		return result;
		
	}
}
