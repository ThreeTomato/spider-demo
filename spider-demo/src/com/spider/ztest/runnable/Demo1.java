package com.spider.ztest.runnable;

public class Demo1 implements Runnable {

	private String name;
	
	public Demo1(String name){
		this.setName(name);
	}
	
	@Override
	public void run() {
		for(int i=1; i<10; i++){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i == 5 && "jack".equals(name)){
				Thread.yield();
			}
			System.err.println(name + ":" + i);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
