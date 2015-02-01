package com.spider.entity;

/**
 * 
 * @typename Site
 * @description site entity
 * @author 0000
 * @date 2015-2-1
 */
public class Site {

	private int id;
	private String name;
	private String domain;
	private String startUrl;
	private int linkFilterType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getStartUrl() {
		return startUrl;
	}
	public void setStartUrl(String startUrl) {
		this.startUrl = startUrl;
	}
	public int getLinkFilterType() {
		return linkFilterType;
	}
	public void setLinkFilterType(int linkFilterType) {
		this.linkFilterType = linkFilterType;
	}
	@Override
	public String toString() {
		return "Site [id=" + id + ", name=" + name + ", domain=" + domain
				+ ", startUrl=" + startUrl + ", linkFilterType="
				+ linkFilterType + "]";
	}
	
}
