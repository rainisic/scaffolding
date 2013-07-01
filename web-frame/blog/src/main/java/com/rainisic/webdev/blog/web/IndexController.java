/* @(#) IndexController.java
 * Project:	blog
 * Package: com.rainisic.webdev.blog.web
 * Author:	rainisic
 * Date:	Jul 1, 2013
 * Copyright © 2010-2013 by Beijing Novel-SuperTV Digital TV Technology Co., Ltd. All rights reserved.
 */
package com.rainisic.webdev.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rainisic
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Success");
		return "site.index.index";
	}
}
