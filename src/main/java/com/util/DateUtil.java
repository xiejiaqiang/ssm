package com.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <日期公共组件> <br>
 * <功能详细描述>日期工具类
 * @author 解佳强
 *
 */

public class DateUtil {
/**
 * 日志组件
 */
	//8位日期格式
	public static final String DATE_CHAR="yyyyMMdd";
	//8位时间格式
	public static final String TIME_CHAR="HH:mm:ss";
	
	/**
	 * 私有构造
	 */
	private DateUtil(){
		
	}
	/**
	 * 将当前日期转为字符串，如：yyyyMMdd
	 * @author Xie
	 * @return String 返回当前日期的字符串，格式为（yyyyMMdd）
	 */
	public static String  getChar8(){
		return DateFormatUtils.format(new Date(), DATE_CHAR);
	}

	/**
	 * 将当前日期转为字符串，如：yyyyMMdd
	 * @author Xie
	 * @return String 返回当前日期的字符串，格式为（yyyyMMdd）
	 */
	public static String  getChar82(){
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd");
	}

	/**
	 * 获取前一个月日期
	 * @return
	 */
	public static String  getBeforeMonth1(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
		Date day =  c.getTime();
		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		return str;
	}
	/**
	 * 获取前2个月日期
	 * @return
	 */
	public static String  getBeforeMonth2(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 2);
		Date day =  c.getTime();
		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		return str;
	}

	/**
	 * 获取前一天日期
	 * @return
	 */
	public static String  getBeforeDate1(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
		Date day =  c.getTime();
		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		return str;
	}
	/**
	 * 获取前2天日期
	 * @return
	 */
	public static String  getBeforeDate2(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, c.get(Calendar.DATE) - 2);
		Date day =  c.getTime();
		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		return str;
	}


	/**
	 * 获取前一年日期
	 * @return
	 */
	public static String  getBeforeYear1(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
		Date day =  c.getTime();
		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		return str;
	}
	/**
	 * 获取前2年日期
	 * @return
	 */
	public static String  getBeforeYear2(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 2);
		Date day =  c.getTime();
		String str=  new SimpleDateFormat("yyyy-MM-dd").format(day);
		return str;
	}

	/**
	 * 将当前时间转为字符串，如：HH:mm:ss
	 * @author Xie
	 * @return String 返回当前日期的字符串，格式为（HH:mm:ss）
	 */
	public static String  getDate8(){
		return DateFormatUtils.format(new Date(), TIME_CHAR);
	}
	/**
	 * 将当前时间转为字符串，如：HH:mm:ss.S
	 * @author Xie
	 * @return String 返回当前日期的字符串，格式为（HH:mm:ss.S）
	 */
	public static String  getDate10(){
		return DateFormatUtils.format(new Date(), TIME_CHAR+".S");
	}
	/**
	 * 将指定日期转为字符串，如：yyyyMMdd
	 * @author Xie
	 * @param time 时间戳
	 * @return String 返回当前日期的字符串，格式为（yyyyMMdd）
	 */
	public static String  getChar8(Timestamp time){
		return DateFormatUtils.format(time.getTime(), DATE_CHAR);
	}
	
	/**
	 * 将当前日期转为字符串，如：yyyy-MM-dd HH:mm:ss
	 * @author Xie
	 * @return String 返回当前日期的字符串，格式为（yyyy-MM-dd HH:mm:ss）
	 */
	public static String  getChar19(){
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 将当前日期转为字符串，如：yyyMMddHHmmss
	 * @author Xie
	 * @return String 返回当前日期的字符串，格式为（yyyMMddHHmmss）
	 */
	public static String  getChar14(){
		return DateFormatUtils.format(new Date(), "yyyMMddHHmmss");
	}
	
	/**
	 * 将当前日期转为字符串，如：yyyy-MM-dd HH:mm:ss.S
	 * @author Xie
	 * @return String 返回当前日期的字符串，格式为（yyyy-MM-dd HH:mm:ss.S）
	 */
	public static String  getChar21(){
		return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.S");
	}
	/**
	 * 判断昨天是否签到(用于统计用户连续签到天数)
	 * @author Xie
	 * @param date 上次签到的时间
	 * @return Boolean true:昨天签过到了 false:昨天没有签到
	 */
	public static Boolean zuoPD(String date){
		Calendar calendar = Calendar.getInstance();//得到日历
		calendar.setTime(new Date());//当前时间赋予给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1);//设置为前一天
		calendar.getTime();//前一天时间
	String zuoDate=	DateFormatUtils.format(calendar.getTime(), "yyyyMMdd").toString();//转换为我需要的格式
int Date =Integer.valueOf(date.split("\\-")[0]+date.split("\\-")[1]+date.split("\\-")[2].split("\\ ")[0]);
int zuooDate =Integer.valueOf(zuoDate);
      if(Date==zuooDate){
    	  return true;
      }
      else{
    	  return false;  
      }
	}
	
	/**
	 * 获取用户的年龄
	 * @author Xie
	 * @param date 出生日期
	 * @return String 年龄
	 */
	public static String  getAges(String date){
		int sr=Integer.valueOf(date.substring(0, 4));
		int dq=Integer.valueOf(DateFormatUtils.format(new Date(), "yyyy"));
		return String.valueOf(dq-sr);
	}
	/**
	 * 判断签到是否为今天(用于判断今天是否签到)
	 * @author Xie
	 * @param date 上次签到的时间
	 * @return Boolean true:今天签过到了 false:今天没有签到
	 */
	public static Boolean jinPD(String date){
		if(date==null){
			return false;
		}
		String dates= DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		String datess=date.substring(0, 10);
		if(dates.equals(datess)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 将日期格式化成String类型
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatTime(Date date,String pattern){
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 将日期格式化成String类型
	 * @param date
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date ParseTime(String date,String pattern) throws ParseException{
		return new SimpleDateFormat(pattern).parse(date);
	}

	public static Date TimeStampToDate(String timeStamp){
		long longTimeStamp = new Long(timeStamp);
		Date date = new Date(longTimeStamp);
		return date;
	}
}
