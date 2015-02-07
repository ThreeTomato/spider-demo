package com.spider.ztest.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunnable {

	public static void main(String[] args) {
		
		//demo1();
		
		//demo2();
		
		//demo3();
		
		demo4();

	}
	
	public static void demo1(){
		
		Demo1 d1 = new Demo1("tom");
		Demo1 d2 = new Demo1("jack");
		
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		
	}
	
	public static void demo2(){
		
		Demo2 d1 = new Demo2();
		Demo2 d2 = new Demo2();
		
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		
		t1.start();
		t2.start();
		
	}
	
	public static void demo3(){
		
		Demo2 d1 = new Demo2();
		Demo2 d2 = new Demo2();
		
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		pool.execute(t1);
		pool.execute(t2);
		
		pool.shutdown();
		
	}
	
	public static void demo4(){
		
		Demo2 d1 = new Demo2();
		Demo2 d2 = new Demo2();
		Demo2 d3 = new Demo2();
		
		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		Thread t3 = new Thread(d3);
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<10; i++){
			pool.execute(new Thread(new Demo2()));
		}
		
		pool.shutdown();
		
	}
	
	
	
}
