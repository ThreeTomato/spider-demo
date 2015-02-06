package com.spider.ztest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.spider.vo.UserVo;

/**
 * json转换为list
 * @author liubao
 * 适用  前台保存多个对象时可将对象以json形式传至后台操作
 */
public class JsonUtil {

	public static void main(String[] args) {
		
//		Date date = new Date();
//		Timestamp createDate1 = new Timestamp(date.getTime());
		
		//自动生成32位字符串
		String temp_uuid = (UUID.randomUUID()).toString();
		String id = temp_uuid.substring(0, 8) + temp_uuid.substring(9, 13)
				+ temp_uuid.substring(14, 18) + temp_uuid.substring(19, 23)
				+ temp_uuid.substring(24);
		System.out.println(id);
		
		String indexMdda = "";//定义字符串接收前台传来的json
		List<UserVo> kpiList = new ArrayList<UserVo>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			UserVo[] kpiArray = mapper.readValue(indexMdda, UserVo[].class);
			kpiList = Arrays.asList(kpiArray);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int j = 0; j < kpiList.size(); j++) {
			
		}
	}
}
