package com.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static final String FORMAT_yyMMdd = "yyyyMMdd";
	public static final String FORMAT_yyMMdd_VERGULE = "yyyy/MM/dd";
	public static final String FORMAT_HHMMSS = "HHmmss";
	public static final String FORMAT_HHMMSS_COLON = "HH:mm:ss";
	public static final String FORMAT_y2M2d24 = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将字符串时间转为转为时间类型
	 * @param dateInStr	字符串时间
	 * @param format	字符串时间的格式
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDate(String dateInStr, String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(dateInStr);	
	}
	
	/**
	 * 获取当前时间的时间戳
	 * @return
	 */
	public static Long getTimeStampForNow(){
		return System.currentTimeMillis();
	}
	
	/**
	 * 获取当前时间的年
	 * @param	type	Calendar表时间类型的静态类型（如：Calendar.YEAR）
	 * @return
	 */
	public static int getTimeForNowByType(int type) throws Exception{
		Calendar calendar = Calendar.getInstance();
		return calendar.get(type);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
