package com.spider.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class LoginController {

	@RequestMapping("/doLogin")
	public ModelAndView doLogin(ModelAndView mav, HttpServletRequest request, HttpServletResponse response){
		Cookie cookie = new Cookie("user","tom");
		response.addCookie(cookie);
		mav.setViewName("login");
		return mav;
	}
	
}
