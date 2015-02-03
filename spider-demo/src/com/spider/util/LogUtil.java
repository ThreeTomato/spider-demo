package com.spider.util;

import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;

import com.spider.entity.Site;
import com.spider.vo.LogVO;

public class LogUtil {
	
	static final Logger performLogger = Logger.getLogger("performance");

	static final Logger operaLogger = Logger.getLogger("operation");
	
	public static void writePerformLog(@SuppressWarnings("rawtypes") Class clazz, String methodName, long startTime, long endTime){
		LogVO logVO = getCurrentThreadStackTrace();
		performLogger.info(LogStrFormat.formatPerformLogStr(logVO, clazz.getName(), methodName, Long.toString(endTime - startTime)));
	}
	
	public static void writeOperaLog(String loginName, Map<String, Object> params, Object returnValue){
		LogVO logVO = getCurrentThreadStackTrace();
		operaLogger.info(LogStrFormat.formatOperaLogStr(loginName, logVO, params, returnValue));
	};
	
	
	private static LogVO getCurrentThreadStackTrace() {
		LogVO logVO = new LogVO();
		StackTraceElement ste = Thread.currentThread().getStackTrace()[3];
		String className = ste.getClassName();
		String methodName = ste.getMethodName();
		int lineNumber = ste.getLineNumber();
		String fileName = ste.getFileName();
		logVO.setClassName(className);
		logVO.setMethodName(methodName);
		logVO.setLineNumber(lineNumber);
		logVO.setFileName(fileName);
		return logVO;
	}
	
	public static void main(String[] args) {
		Site site = new Site();
		site.setName("csdn");
		File src = new File("F:\\log.txt");
		File dst = new File("F:\\log.txt.bak");
		long startTime = System.currentTimeMillis();
		FileUtil.copy(src, dst);
		long endTime = System.currentTimeMillis();
		LogUtil.writePerformLog(FileUtil.class, "copy", startTime, endTime);
		
	}
	
	
	
}
