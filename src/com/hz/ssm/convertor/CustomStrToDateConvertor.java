package com.hz.ssm.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 自定义的一个全局时间转换器
 * S,  source  源
 * 
 * T  target   目标
 * @author Administrator
 *
 */
public class CustomStrToDateConvertor implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}	
		
		return null;
	}

}
