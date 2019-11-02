package com.bitacademy.jblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BlogController {
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@RequestMapping("/{userName}")
	public String blogMain(@PathVariable("userName") String userName ) {
		
		return "blog/blogmain";
	}

}
