package com.pro.xwt.common.utils;

public class Rex {
	private static String mathReg = "\\w{32}";
	/** 
	 * 字符串的替换 
	 */
	public static String getReplace(String str,String replaceStr) { 
		String stri = str.replaceAll(mathReg,replaceStr) ; 
		return stri;
	}
}
