package com.spider.util;

import java.util.HashMap;
import java.util.Map;

public class CommonUtil {
	
	public static void main(String[] args) {
		 for (int i = 0; i < 20; i++) { 
            long x = SequenceUtils.getInstance().getNextKeyValue("aaa"); 
            System.out.println(x); 
        } 
	}
}

class SequenceUtils { 
    private static SequenceUtils _instance = new SequenceUtils(); 
    private Map<String, KeyInfo> keyMap = new HashMap<String, KeyInfo>(20); //Sequence�������� 
    private static final int POOL_SIZE = 10;      //Sequenceֵ�����С 

    /** 
     * ��ֹ�ⲿʵ���� 
     */ 
    private SequenceUtils() { 
    } 

    /** 
     * ��ȡSequenceUtils�ĵ������� 
     * @return SequenceUtils�ĵ������� 
     */ 
    public static SequenceUtils getInstance() { 
        return _instance; 
    } 

    /** 
     * ��ȡ��һ��Sequence��ֵ 
     * @param keyName Sequence���� 
     * @return ��һ��Sequence��ֵ 
     */ 
    public synchronized long getNextKeyValue(String keyName) { 
        KeyInfo keyInfo = null; 
        Long keyObject = null; 
        if (keyMap.containsKey(keyName)) { 
            keyInfo = keyMap.get(keyName); 
        } else { 
            keyInfo = new KeyInfo(keyName, POOL_SIZE); 
            keyMap.put(keyName, keyInfo); 
        } 
        keyObject = keyInfo.getNextKey(); 
        return keyObject; 
    } 
}

class KeyInfo { 
    private long maxKey;        //��ǰSequence��������ֵ 
    private long minKey;        //��ǰSequence�������Сֵ 
    private long nextKey;       //��һ��Sequenceֵ 
    private int poolSize;       //Sequenceֵ�����С 
    private String keyName;     //Sequence������ 
    public KeyInfo(String keyName, int poolSize){ 
        this.poolSize = poolSize; 
        this.keyName = keyName; 
    } 

    public String getKeyName() { 
        return keyName; 
    } 

    public long getMaxKey() { 
        return maxKey; 
    } 

    public long getMinKey() { 
        return minKey; 
    } 

    public int getPoolSize() { 
        return poolSize; 
    } 

    /** 
     * ��ȡ��һ��Sequenceֵ 
     * 
     * @return ��һ��Sequenceֵ 
     * @throws SQLException 
     */ 
    public synchronized long getNextKey() { 
        if (nextKey > maxKey) { 
            maxKey += 10;
            System.err.println("update maxKey to " + maxKey);
        } 
        return nextKey++; 
    }
}