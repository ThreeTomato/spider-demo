package com.spider.util;

import java.util.Collection;

public class ValidateUtil {

	public static boolean isValid(String str){
		return str != null && !"".equals(str.trim());
	}
	
	public static boolean isValid(Object[] arr){
		return arr != null && arr.length > 0;
	}
	
	public static boolean isValid(@SuppressWarnings("rawtypes") Collection col){
		return col != null && !col.isEmpty();
	}
	
}
