package com.spider.vo;

public class LogVO {

	private String className;
	private String methodName;
	private int lineNumber;
	private String fileName;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "LogVo [className=" + className + ", methodName=" + methodName
				+ ", lineNumber=" + lineNumber + ", fileName=" + fileName + "]";
	}
	
}
