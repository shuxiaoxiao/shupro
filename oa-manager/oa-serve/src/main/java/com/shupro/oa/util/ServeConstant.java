package com.shupro.oa.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务常量类
 * @author shu
 *
 */
public class ServeConstant {

	/**文件上传类型*/
	public static final Map<String, String> uploadTypeMap = new HashMap<>();
	
	static{
		// 1代表合同，2代表附加合同，3代表企业资质，4代表仓库图片， 其他可以不传递types
		uploadTypeMap.put("1", "");
		uploadTypeMap.put("2", "");
		uploadTypeMap.put("3", "");
		uploadTypeMap.put("4", "");
		uploadTypeMap.put("5", "");
		uploadTypeMap.put("other", "other");
		
	}

}
