package com.bitacademy.jblog.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//블로거
	@RequestMapping
	public String blogMain(@PathVariable("id") String id, HttpSession session) {
		
		logger.debug("블로그로 이동->");
//		UserVo bloger = userService.getUser(id);
//		BlogVo blog = blogService.getBlogUser(bloger.getUserNo());
//		session.setAttribute("blog", blog);
//		logger.debug("bloger: " + bloger);		 
//		logger.debug("blog: " + session.getAttribute("blog"));				
//		logger.debug("authUser: " + session.getAttribute("authUser"));
//		
//		session.setAttribute("bloger", bloger);
		logger.debug("Get Sesison");
		logger.debug("authUser: " + session.getAttribute("authUser"));
		logger.debug("authBlog: " + session.getAttribute("authBlog"));
		logger.debug("Set Session");
		UserVo bloger = userService.getUser(id);
		BlogVo blog = blogService.getBlogByUserNo(bloger.getUserNo());
		session.setAttribute("bloger", bloger);
		session.setAttribute("blog", blog);
		logger.debug("bloger: " + session.getAttribute("bloger"));
		logger.debug("blog: " + session.getAttribute("blog"));
		logger.debug("----------------------------");

		
		return "blog/blogmain";
	}
	
	//관리자
	@RequestMapping("/admin/settings")
	public String blogSettings(@PathVariable("id") String id, HttpSession session) {
		logger.debug("내블로그 관리->");

		logger.debug("authUser: " + session.getAttribute("authUser"));
		logger.debug("authBlog: " + session.getAttribute("authBlog"));
		logger.debug("bloger: " + session.getAttribute("bloger"));
		logger.debug("blog: " + session.getAttribute("blog"));
		
		
		logger.debug("----------------------------");
		return "blog/admin/admin";
	}
	
	@RequestMapping(value="/admin/settings", method=RequestMethod.POST)
	public String setBasic(
			@RequestParam(value="blog-title") String blogTitle,
			HttpSession session) {
		
		logger.debug("기본설정 변경 액션->");

		BlogVo authBlogTemp = (BlogVo)session.getAttribute("authBlog");
		BlogVo blogTemp = (BlogVo)session.getAttribute("blog");
		
		boolean isSuccess = false;
		
		if (blogTitle == "" || blogTitle == null) {
			authBlogTemp.setBlogTitle(authBlogTemp.getBlogTitle());			
		} else {
			authBlogTemp.setBlogTitle(blogTitle);
			blogTemp.setBlogTitle(blogTitle);
			
			isSuccess = blogService.updateBlogTitle(blogTemp);
			logger.debug("BlogTitle updated");
		}
		
			
		logger.debug("authUser: " + session.getAttribute("authUser"));
		logger.debug("authBlog: " + session.getAttribute("authBlog"));
		logger.debug("bloger: " + session.getAttribute("bloger"));
		logger.debug("blog: " + session.getAttribute("blog"));
		
		logger.debug("----------------------------");
		
		return "redirect:/{id}";
	}
	
	/*
	@RequestMapping(value="/admin/settings", method=RequestMethod.POST)
	public String updateBasicSettings(
			@PathVariable("id") String id,
			@RequestParam(value="blog-title")
			HttpSession session) {
		logger.debug("----------------------------");
		logger.debug("Call updateBasicSettings");
		
		UserVo bloger = userService.getUser(id);
		logger.debug("bloger: " + bloger);
		 
		BlogVo myBlog = blogService.getBlogUser(bloger.getUserNo());
		myBlog.setBlogTitle(bloger.getUserName() + "의 블로그입니다.");
		logger.debug("blog: " + myBlog);
				
		logger.debug("authUser: " + session.getAttribute("authUser"));
		session.setAttribute("bloger", bloger);
		session.setAttribute("myBlog", myBlog);
		logger.debug("----------------------------");
		return "redirect:/{id}";
	}
	*/
	
}
