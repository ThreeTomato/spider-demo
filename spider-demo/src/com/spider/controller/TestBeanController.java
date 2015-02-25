package com.spider.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spider.service.impl.SayOk;

@Controller
@RequestMapping("/test")
public class TestBeanController implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@RequestMapping("/getBean")
	public void getBean(){
		SayOk ok = (SayOk) applicationContext.getBean("sayOk");
		ok.say();
		System.out.println("--------------");
		ok.action();
	}
	
}
