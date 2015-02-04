package com.spider.ztest.fetch;

public class U {
	private int depth;
    private String url;
 
    public U(int depth, String url) {
        super();
        this.depth = depth;
        this.url = url;
    }
 
    public int getDepth() {
        return depth;
    }
 
    public void setDepth(int depth) {
        this.depth = depth;
    }
 
    public String getUrl() {
        return url;
    }
 
    public void setUrl(String url) {
        this.url = url;
    }
 
    @Override
    public String toString() {
        return "[…Ó∂»:" + depth + ",URL:" + url + "]";
    }
}
