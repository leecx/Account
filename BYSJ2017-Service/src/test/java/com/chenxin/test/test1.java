package com.chenxin.test;
/**
 *@author  created by licx
 *@data    2017年6月5日---下午8:11:55
 */
public class test1 {
	
	public static void main(String[] args) {
		//double double1 = (Double) null;
		//System.out.println(double1);
		//Double double2 = new Double(0.0);
		//System.out.println(0.0>0);
		String s = "撒的健康(阿萨德就离开)";
		System.out.println(s.contains("(阿萨德就离开)"));
		System.out.println(s.substring(0,s.indexOf("(")));
		
	}

}
