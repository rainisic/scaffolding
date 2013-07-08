/* @(#) IndexController.java
 * Project:	blog
 * Package: com.rainisic.webdev.blog.web
 * Author:	rainisic
 * Date:	Jul 1, 2013
 * Copyright © 2010-2013 by Rainisic. All rights reserved.
 */
package com.rainisic.webdev.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rainisic
 * 
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(ModelMap model, String dataType) {
		model.addAttribute("dataType", dataType);
		return "forward:/article/list";
	}

}
