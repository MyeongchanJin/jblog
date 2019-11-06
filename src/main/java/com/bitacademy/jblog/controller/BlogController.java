package com.bitacademy.jblog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.jblog.repository.BlogVo;
import com.bitacademy.jblog.repository.CategoryVo;
import com.bitacademy.jblog.repository.PostVo;
import com.bitacademy.jblog.repository.UserVo;
import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.service.UserService;

@Controller
@RequestMapping("/{id}")
public class BlogController {
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PostService postService;
	
	//블로거
	@RequestMapping
	public String blogMain(@PathVariable("id") String id, HttpSession session) {
		
		logger.debug("블로그로 이동->");

		logger.debug("Get Sesison");
		logger.debug("authUser: " + session.getAttribute("authUser"));
		logger.debug("authBlog: " + session.getAttribute("authBlog"));
		logger.debug("Set Session");
		UserVo bloger = userService.getUser(id);
		BlogVo blog = blogService.getBlogByUserNo(bloger.getUserNo());
		List<CategoryVo> categoryList = categoryService.getCategoryList();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("bloger", bloger);
		session.setAttribute("blog", blog);
		logger.debug("category: " + session.getAttribute("categoryList"));
		logger.debug("bloger: " + session.getAttribute("bloger"));
		logger.debug("blog: " + session.getAttribute("blog"));
		logger.debug("----------------------------");

		
		return "blog/blogmain";
	}
	
	
	@RequestMapping("/admin/{option}")
	public String settings(
			@ModelAttribute CategoryVo cvo,
			@PathVariable("id") String id,
			@PathVariable("option") String option,
			Model categoryListModel,
			Model postNumberListModel,
			Model model,
			HttpSession session) {
		logger.debug("내블로그 관리(" + option + ")->");

		session.setAttribute("opt", option);
		logger.debug("option: " + option);
		
		if ("category".equals(option)) {
			logger.debug("CategoryList->");
			List<CategoryVo> categoryList = categoryService.getCategoryList();
			categoryListModel.addAttribute("categoryList", categoryList);
			logger.debug("Category: " + categoryList);
			
		} else if ("write".equals(option)) {
			logger.debug("PostList->");
			List<PostVo> postList = postService.getPostList();
			model.addAttribute("postList", postList);
			logger.debug("post: " + postList);
		}

		logger.debug("authUser: " + session.getAttribute("authUser"));
		logger.debug("authBlog: " + session.getAttribute("authBlog"));
		logger.debug("bloger: " + session.getAttribute("bloger"));
		logger.debug("blog: " + session.getAttribute("blog"));
		logger.debug("category: " + session.getAttribute("categoryList"));
		
		logger.debug("----------------------------");
		return "blog/admin/admin";
	}
	
	@RequestMapping(value="/admin/basic", method=RequestMethod.POST)
	public String setBasic(
			@RequestParam(value="blog-title") String blogTitle,
			/* Multipart로 형변환 하기 */
			@RequestParam(value="blog-logo") String logoFile,
			HttpSession session) {
		
		logger.debug("기본설정 변경 액션->");
		
		BlogVo authBlogTemp = (BlogVo)session.getAttribute("authBlog");
		BlogVo blogTemp = (BlogVo)session.getAttribute("blog");
		
		boolean isSuccess = false;
		
		logger.debug(blogTitle);
		logger.debug("input not null: " + blogTitle);
		authBlogTemp.setBlogTitle(blogTitle);
		blogTemp.setBlogTitle(blogTitle);
			
		isSuccess = blogService.updateBlogTitle(blogTemp);
		logger.debug("BlogTitle updated");
							
		logger.debug("authUser: " + session.getAttribute("authUser"));
		logger.debug("authBlog: " + session.getAttribute("authBlog"));
		logger.debug("bloger: " + session.getAttribute("bloger"));
		logger.debug("blog: " + session.getAttribute("blog"));
		logger.debug("category: " + session.getAttribute("categoryList"));
		
		logger.debug("----------------------------");

		return "redirect:/{id}";
	}
	
	@RequestMapping(value="/admin/category", method=RequestMethod.POST)
	public String setCategory(
			@ModelAttribute CategoryVo cvo,
			@RequestParam(value="cate-name") String cateName,
			@RequestParam(value="cate-desc") String description,
			Model categoryListModel,
			Model postNumberListModel,
			HttpSession session) {
		
		logger.debug("기본설정 변경 액션(category)->");

		//	insert into category table
		cvo.setUserNo((Long)((BlogVo)session.getAttribute("authBlog")).getUserNo());
		cvo.setCateName(cateName);
		cvo.setDescription(description);
		logger.debug("cvo: " + cvo);
		boolean isSuccess = categoryService.insertCategory(cvo);
		logger.debug("category inserted");
		//logger.debug("CategoryVo test");
		logger.debug("CategoryList->");
		
		
		
		
		logger.debug("CategoryList->");
		List<CategoryVo> categoryList = categoryService.getCategoryList();
		categoryListModel.addAttribute("categoryList", categoryList);
		logger.debug("Category: " + categoryList);
		

		
		logger.debug("authUser: " + session.getAttribute("authUser"));
		logger.debug("authBlog: " + session.getAttribute("authBlog"));
		logger.debug("bloger: " + session.getAttribute("bloger"));
		logger.debug("blog: " + session.getAttribute("blog"));
		logger.debug("category: " + session.getAttribute("categoryList"));
		
		logger.debug("----------------------------");

		return "blog/admin/admin-category";
	}
	
	@RequestMapping(value="/admin/write", method=RequestMethod.POST)
	public String setPost(
			@ModelAttribute PostVo pvo,
			@RequestParam(value="post-title") String postTitle,
			@RequestParam(value="post-category") Long cateNo,
			@RequestParam(value="post-content") String postContent,
			Model model,
			HttpSession session) {
		
		logger.debug("기본설정 변경 액션(post)->");
		
		logger.debug("insert call");
		
		logger.debug("PostList->");
		List<PostVo> postList = postService.getPostList();
		model.addAttribute("postList", postList);
		
		logger.debug("post: " + postList);
		
		logger.debug("post-title: " + postTitle);
		logger.debug("post-category: " + cateNo);
		logger.debug("post-content: " + postContent);
		
		pvo.setCateNo(cateNo);
		pvo.setPostTitle(postTitle);
		pvo.setPostContent(postContent);
		logger.debug("pvo: " + pvo);
		boolean isSuccess = postService.insertPost(pvo);
		
		logger.debug("post inserted!");
		
		logger.debug("-----------------------------");
	
		logger.debug("authUser: " + session.getAttribute("authUser"));
		logger.debug("authBlog: " + session.getAttribute("authBlog"));
		logger.debug("bloger: " + session.getAttribute("bloger"));
		logger.debug("blog: " + session.getAttribute("blog"));
		logger.debug("category: " + session.getAttribute("categoryList"));
		
		logger.debug("----------------------------");

		return "redirect:/{id}";
	}
	
}
