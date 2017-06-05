package com.chenxin.dateTest;

import java.util.Date;

import org.joda.time.DateTime;

/**
 *@author  created by licx
 *@data    2017年6月4日---下午3:51:38
 */
public class DateTest {
	
	public static void main(String[] args) {
		DateTime dateTime = new DateTime().withMonthOfYear(10);
		System.out.println(dateTime);
		System.out.println(dateTime.getDayOfYear());
		System.out.println(dateTime.getDayOfWeek());
		System.out.println(dateTime.getYear());
		System.out.println(dateTime.getMonthOfYear());
		System.out.println(dateTime.getDayOfMonth());
		System.out.println(dateTime.getDayOfWeek());
		System.out.println(dateTime.withDayOfWeek(1).toString("MM月dd日"));
		System.out.println(dateTime.dayOfMonth().getMaximumValue());
		System.out.println(dateTime);
	}
	
}
