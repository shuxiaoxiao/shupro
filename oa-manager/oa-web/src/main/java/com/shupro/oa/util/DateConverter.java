package com.shupro.oa.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.shupro.core.utils.lang.DateUtil;

/**
 * 页面传入的日期是String，后台接收是Date
 * @author shu
 *
 */
public class DateConverter implements Converter<String, Date> {
	
	/**日期格式*/
	public static final List<String> datePatternList = new ArrayList<>();
	static{
		datePatternList.add("yyyy-MM");
		datePatternList.add("yyyy-MM-dd");
		datePatternList.add("yyyy-MM-dd hh:mm");
		datePatternList.add("yyyy-MM-dd hh:mm:ss");
		datePatternList.add("yyyyMMdd");
		datePatternList.add("yyyyMMddhh:mm:ss");
	}
	
	@Override
	public Date convert(String source) {
		if("".equals(source)|| source == null){
			return null;
		}
		
		String datePattern = "";
		if(source.matches("^\\d{4}-\\d{1,2}$")){ 
			datePattern = datePatternList.get(0);
		}else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
			datePattern = datePatternList.get(1);
		}else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
			datePattern = datePatternList.get(2);
		}else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
			datePattern = datePatternList.get(3);
		}else {
			throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
		}
		
		return DateUtil.strToDate(source, datePattern);
	}
}