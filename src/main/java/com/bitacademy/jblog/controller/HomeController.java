package com.bitacademy.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject( "message", "Hello");
		mav.setViewName("index");
		return mav;
	}
}
