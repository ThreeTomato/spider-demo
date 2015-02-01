package com.spider.ztest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spider.entity.Site;
import com.spider.service.ISiteService;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ContextConfiguration(locations = {"classpath*:config/applicationContext.xml"})
public class SiteTest {

	@Autowired
	private ISiteService siteService;
	
	private int id;
	private Site site;
	private int result;
	private boolean flag;
	private List<Site> list;
	
	@Test
	public void sayHi(){
		System.err.println("hi");
	}
	
	@Test
	public void insert(){
		site = new Site();
		site.setId(1001);
		site.setName("cnblogs");
		site.setDomain("http://www.cnblogs.com/");
		site.setStartUrl("http://www.cnblogs.com/");
		site.setLinkFilterType(2);
		result = siteService.insert(site);
		System.err.println(result);	//   1
	}
	
	@Test
	public void delete(){
		id = 1001;
		siteService.delete(id);
		flag = true;
		System.err.println(flag);
	}
	
	@Test
	public void update(){
		site = new Site();
		site.setId(1000);
		site.setStartUrl("blog.csdn.net");
		result = siteService.update(site);
		System.err.println(result);	//   1
	}
	
	@Test
	public void getById(){
		id = 1000;
		site = siteService.getById(id);
		System.err.println(site.getStartUrl());
	}
	
	@Test
	public void getList(){
		site = new Site();
		list = siteService.getList(site);
		System.err.println(list.size());
	}
}
