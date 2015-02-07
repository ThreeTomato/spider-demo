package com.spider.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	public static String getMD5(String srcStr){
		
		if(!ValidateUtil.isValid(srcStr)){
			return null;
		}
		
		byte[] src = srcStr.getBytes();
		
		return getMD5(src);
		
	}
	
	public static String getMD5(byte[] src){
		
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
							 'e', 'f' };
		char[] str = new char[32];
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(src);
			byte[] tmp = md.digest();
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(str);
	}
	
}
