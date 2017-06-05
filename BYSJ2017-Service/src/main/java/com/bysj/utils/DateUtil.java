package com.bysj.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

/**
 *@author  created by licx
 *@data    2017年5月22日---上午12:46:50
 */
public class DateUtil {
	
	/**
	 * 获得当前周区间
	 * @param date
	 * @return
	 */
	public static String getWeekInterval(Date date){
		Calendar cal = Calendar.getInstance();  
	     cal.setTime(date);  
	     // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
	     int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	     if (1 == dayWeek) {  
	        cal.add(Calendar.DAY_OF_MONTH, -1);  
	     }  
	     // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期  
	     // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
	     cal.setFirstDayOfWeek(Calendar.MONDAY);  
	     // 获得当前日期是一个星期的第几天  
	     int day = cal.get(Calendar.DAY_OF_WEEK);  
	     // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
	     cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);  
	     SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String imptimeBegin = sdf.format(cal.getTime());  
	     // System.out.println("所在周星期一的日期：" + imptimeBegin);  
	     cal.add(Calendar.DATE, 6);  
	     String imptimeEnd = sdf.format(cal.getTime());  
	     // System.out.println("所在周星期日的日期：" + imptimeEnd);  
	     return imptimeBegin + "-" + imptimeEnd;  
	}
	
	/**
	 * 获得当前月区间
	 * @param date
	 * @return
	 */
	public static String getMonthInterval(Date date){
		SimpleDateFormat format = new SimpleDateFormat("MM月dd日"); 
		  //获取前月的第一天
        Calendar   cal_1=Calendar.getInstance();//获取当前日期 
        cal_1.setTime(date);
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        String firstDay = format.format(cal_1.getTime());
        //System.out.println("-----1------firstDay:"+firstDay);
        //获取前月的最后一天
        Calendar cale = Calendar.getInstance();   
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH,cale.getActualMaximum(Calendar.DAY_OF_MONTH));//设置为1号,当前日期既为本月第一天 
        String lastDay = format.format(cale.getTime());
        //System.out.println("-----2------lastDay:"+lastDay);
		return firstDay+"-"+lastDay;
	}
	
	/**
	 * 获得周区间，新
	 * @param date
	 * @return
	 */
	public static String getWeekRegion(Date date){
		DateTime dateTime = new DateTime(date.getTime());
		String startDay = dateTime.withDayOfWeek(DateTimeConstants.MONDAY).toString("MM月dd日");
		String endDay = dateTime.withDayOfWeek(DateTimeConstants.SUNDAY).toString("MM月dd日");
		return startDay+"-"+endDay;
		
	}
	
	public static void main(String[] args) {
		Date date = new Date();
		date.setMonth(1);
		String timeInterval = getWeekInterval(date);
		String monthInterval = getMonthInterval(date);
		System.out.println(monthInterval);
		System.out.println(timeInterval);
	}

}
