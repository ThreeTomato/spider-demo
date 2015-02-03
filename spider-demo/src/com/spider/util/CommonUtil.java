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
    private Map<String, KeyInfo> keyMap = new HashMap<String, KeyInfo>(20); //Sequence载体容器 
    private static final int POOL_SIZE = 10;      //Sequence值缓存大小 

    /** 
     * 禁止外部实例化 
     */ 
    private SequenceUtils() { 
    } 

    /** 
     * 获取SequenceUtils的单例对象 
     * @return SequenceUtils的单例对象 
     */ 
    public static SequenceUtils getInstance() { 
        return _instance; 
    } 

    /** 
     * 获取下一个Sequence键值 
     * @param keyName Sequence名称 
     * @return 下一个Sequence键值 
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
    private long maxKey;        //当前Sequence载体的最大值 
    private long minKey;        //当前Sequence载体的最小值 
    private long nextKey;       //下一个Sequence值 
    private int poolSize;       //Sequence值缓存大小 
    private String keyName;     //Sequence的名称 
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
     * 获取下一个Sequence值 
     * 
     * @return 下一个Sequence值 
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