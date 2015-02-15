package com.spider.service.impl;

import org.springframework.stereotype.Service;

@Service("sayOk")
public class SayOk {

	public void say(){
		System.err.println("ok");
	}
	
}
