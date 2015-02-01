package com.spider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spider.entity.Site;
import com.spider.service.ISiteService;

@Controller
@RequestMapping("/site")
public class SiteController {

	@Autowired
	private ISiteService siteService;
	
	@RequestMapping("/index")
	public ModelAndView toSiteIndex(ModelAndView mav){
		Site site = new Site();
		List<Site> list = siteService.getList(site);
		mav.getModel().put("list", list);
		mav.setViewName("site/site-index");
		return mav;
	}
	
}
