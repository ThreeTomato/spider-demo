package com.spider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spider.dao.SiteMapper;
import com.spider.entity.Site;
import com.spider.service.ISiteService;

@Service("siteService")
public class SiteServiceImpl implements ISiteService {

	@Autowired
	private SiteMapper siteDao;
	
	@Override
	public int insert(Site site) {
		// TODO Auto-generated method stub
		return siteDao.insert(site);
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		siteDao.delete(id);
	}
	
	@Override
	public int update(Site site) {
		// TODO Auto-generated method stub
		return siteDao.update(site);
	}
	
	@Override
	public Site getById(int id) {
		// TODO Auto-generated method stub
		return siteDao.getById(id);
	}
	
	@Override
	public List<Site> getList(Site site) {
		// TODO Auto-generated method stub
		return siteDao.getList(site);
	}

}
