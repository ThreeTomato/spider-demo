package com.spider.dao;

import java.util.List;
import com.spider.entity.Site;

public interface SiteMapper {

	public int insert(Site site);
	
	public void delete(int id);
	
	public int update(Site site);
	
	public Site getById(int id);
	
	public List<Site> getList(Site site);
	
}
