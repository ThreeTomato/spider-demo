package com.spider.ztest.fetch;

public class FetchTest {

	public static void main(String[] args) {
		 try {
	            AchorFetch a = new AchorFetch("http://www.sina.com", 2);
	            new Thread(a).start();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
}
