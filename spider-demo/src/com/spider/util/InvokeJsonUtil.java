package com.spider.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeJsonUtil {

	public static String toJson(Object obj){

		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for(Field field : fields){
			String fName = field.getName();
			Method method;
			try {
				method = clazz.getMethod("get"+fName.substring(0,1).toUpperCase()+fName.substring(1));
				sb.append("'" + fName + "':'" + method.invoke(obj) + "',");
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return sb.substring(0,sb.lastIndexOf(",")) + "}";
		
	}
	
}
