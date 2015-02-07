package com.spider.ztest.runnable;

public class Demo2 implements Runnable {

	private A a = new A();
	
	@Override
	public void run() {
		for(int i=0; i<5; i++){
			a.add(10);
			System.err.println(a.getAa() + "--" + Thread.currentThread().getName());
		}
	}

}
