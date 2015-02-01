package com.spider.entity;

/**
 * 
 * @typename Sequence
 * @description create primary key
 * @author 0000
 * @date 2015-2-1
 */
public class Sequence {

	private String seqName;
	private int seqCurrent;
	private int seqIncrease;
	
	public String getSeqName() {
		return seqName;
	}
	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}
	public int getSeqCurrent() {
		return seqCurrent;
	}
	public void setSeqCurrent(int seqCurrent) {
		this.seqCurrent = seqCurrent;
	}
	public int getSeqIncrease() {
		return seqIncrease;
	}
	public void setSeqIncrease(int seqIncrease) {
		this.seqIncrease = seqIncrease;
	}
	
	@Override
	public String toString() {
		return "Sequence [seqName=" + seqName + ", seqCurrent=" + seqCurrent
				+ ", seqIncrease=" + seqIncrease + "]";
	}
}
