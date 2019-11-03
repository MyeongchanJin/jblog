package com.bitacademy.jblog.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.UserVo;
import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.UserService;

@Controller
@RequestMapping("/{id}")
public class BlogController {
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping
	public String blogMain(@PathVariable("id") String id, HttpSession session) {
		
		UserVo bloger = userService.getUser(id);
		logger.debug("bloger: " + bloger);
		 
		BlogVo blog = blogService.getBlogUser(bloger.getUserNo());
		logger.debug("blog: " + blog);
				
		logger.debug("authUser: " + session.getAttribute("authUser"));
		session.setAttribute("bloger", bloger);
		session.setAttribute("blog", blog);
		
		return "blog/blogmain";
	}
}
