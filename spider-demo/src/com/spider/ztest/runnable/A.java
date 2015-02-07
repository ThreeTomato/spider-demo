package com.spider.ztest.runnable;

public class A {

	private int aa = 100;

	public void add(int num){
		this.aa = aa + num;
	}
	
	
	
	public synchronized int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}
	
}
