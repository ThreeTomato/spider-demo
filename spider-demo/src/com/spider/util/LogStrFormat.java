package com.spider.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import com.spider.vo.LogVO;

public class LogStrFormat {
	
	public static String formatPerformLogStr(LogVO logVO, String className, String methodName, String costTime){
		StringBuilder logStr = new StringBuilder();
		logStr.append(" ");
		logStr.append(logVO.getClassName());
		logStr.append(".");
		logStr.append(logVO.getMethodName());
		logStr.append("(");
		logStr.append(logVO.getFileName());
		logStr.append(":");
		logStr.append(logVO.getLineNumber());
		logStr.append(") |");
		logStr.append(" CLASSNAME:");
		logStr.append(className);
		logStr.append(" METHODNAME:");
		logStr.append(methodName);
		logStr.append(" COST_TIME:");
		logStr.append(costTime);
		logStr.append("ms");
		return logStr.toString();
	}
	
	public static String formatOperaLogStr(String loginName, LogVO logVO, Map<String, Object> params, Object returnValue){
		StringBuilder logStr = new StringBuilder();
		logStr.append(formatParamsLogStr(logVO, params, returnValue));
		logStr.append(" | loginName:");
		logStr.append(loginName);
		return logStr.toString();
	}
	
	@SuppressWarnings("unchecked")
	private static <T> String formatParamsLogStr(LogVO logVO, T... params){
		T returnValue = params[params.length - 1];
		StringBuilder logStr = new StringBuilder();
		logStr.append(" ");
		logStr.append(logVO.getClassName());
		logStr.append(".");
		logStr.append(logVO.getMethodName());
		logStr.append("(");
		logStr.append(logVO.getFileName());
		logStr.append(":");
		logStr.append(logVO.getLineNumber());
		logStr.append(") |");
		for (int i = 0 ; i < params.length - 1 ; i++) {
			T param = params[i];
			logStr.append(formatParamValues(param));
		}
		logStr.append(formatReturnValues(returnValue));
		return logStr.toString();
	}
	
	@SuppressWarnings("rawtypes")
	private static <T> String formatParamValues(T param){
		StringBuilder logStr = new StringBuilder();
		if (param == null) {
			logStr.append(" PARAM VALUE:{null})");
		} else {
			String paramClassName = param.getClass().getName();
			logStr.append(" PARAMCLASS:(CLASSTYPE:");
			logStr.append(paramClassName);
			 
			if (paramClassName.indexOf("java.lang.Integer")!=-1 || paramClassName.indexOf("java.lang.Long")!=-1 || paramClassName.indexOf("java.lang.String")!=-1
					|| paramClassName.indexOf("java.lang.Float")!=-1 || paramClassName.indexOf("java.lang.Double")!=-1 || paramClassName.indexOf("java.lang.Short")!=-1
					|| paramClassName.indexOf("java.lang.Number")!=-1) {
				logStr.append(" VALUE:{");
				logStr.append(param);
			} else if (paramClassName.indexOf("java.util.HashMap")!=-1 || paramClassName.indexOf("java.util.HashTable")!=-1 || paramClassName.indexOf("java.util.TreeMap")!=-1) {
				logStr.append(" KEY-VALUES:{");
				Map map = (Map)param;
				Iterator iterator = map.entrySet().iterator();
				int n = 1;
				while (iterator.hasNext()) {
					Map.Entry me = (Map.Entry)iterator.next();
					if (n == 1) {
						logStr.append(me.getKey() + ":" + me.getValue());
					} else {
						logStr.append(",");
						logStr.append(me.getKey() + ":" + me.getValue());
					}
					n++;
				}
			} else {
				int n = 1;
				logStr.append(" PARAMS:{");
				Field[] fields = param.getClass().getDeclaredFields();
				for (Field f : fields) {
					if (f.toGenericString().indexOf("static")!=-1 || f.toGenericString().indexOf("final")!=-1) {
						continue;
					}
					String fieldName = f.getName();
					Class fieldType = f.getType();
					Object obj = null;
					if (fieldType.getName().indexOf("boolean") != -1) {
						obj = invokeISMethod(param, fieldName);
					} else {
						obj = invokeGetMethod(param, fieldName);
					}
					
					if (n > 1) {
						logStr.append(",");
					} 
					logStr.append(fieldName + ":" + obj);
					n++;
				}
			}
			logStr.append("})");
		}
		
		return logStr.toString();
	}
	
	private static <T> String formatReturnValues(T returnValue){
		
		return "";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Object invokeISMethod(Object owner, String attrName){
		String methodName = "is" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1);
		Class cla = owner.getClass();
		Class cls[] = {};
		Object[] args = {};
		Method md;
		Object result = null;
		try {
			md = cla.getMethod(methodName, cls);
			result = md.invoke(owner, args);
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
		return result;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Object invokeGetMethod(Object owner, String attrName){
		String methodName = "get" + attrName.substring(0, 1).toUpperCase() + attrName.substring(1);
		Class cla = owner.getClass();
		Class cls[] = {};
		Object[] args = {};
		Method md;
		Object result = null;
		try {
			md = cla.getMethod(methodName, cls);
			result = md.invoke(owner, args);
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
		return result;
	}
	
}
