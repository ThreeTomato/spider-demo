package com.spider.ztest.fetch;

import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.http.HttpStatus;

public abstract class Fetch implements Runnable{
	private static final String HTTP_PROTROL = "http://";
    public final static String USER_AGENT_H = "User-Agent";
    public final static String REFERER_H = "Referer";
    public final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.172 Safari/537.22";
    private U root;
    private int depth;
    private String host;
 
    public String getHost() {
        return host;
    } 
 
    public void setHost(String host) {
        this.host = host;
    }
 
    public Fetch(U root, int depth) {
        super();
        this.root = root;
        this.depth = depth;
    }
 
    public Fetch(String root, int depth) {
        this.root = new U(0, root);
        this.depth = depth;
    }
 
    public U getRoot() {
        return root;
    }
 
    public void setRoot(U root) {
        this.root = root;
    }
 
    public int getDepth() {
        return depth;
    }
 
    public void setDepth(int depth) {
        this.depth = depth;
    }
 
    @Override
    public void run() {
        try {
            this.get(root);
        } catch (Exception e) {
            Thread.yield();
        }
    }
 
    @SuppressWarnings("deprecation")
    protected void get(U u) throws Exception {
        HttpClient client = new HttpClient();
        if (u.getDepth() + 1 > this.depth) {
            return;
        }
        GetMethod get = new GetMethod(u.getUrl());
        get.setRequestHeader(USER_AGENT_H, USER_AGENT);
        int status = client.executeMethod(get);
        if (status == Integer.parseInt(HttpStatus.OK.toString())) {
            InputStream in = get.getResponseBodyAsStream();
            this.setHost(HTTP_PROTROL + get.getHostConfiguration().getHost());
            process(in);
        }
    }
 
    protected abstract void process(InputStream in) throws Exception;
}
