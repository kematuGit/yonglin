package com.hd.framework.utils;

public abstract class StringUtil {

	public static String format(int len,int target) {
		return String.format("%04d", target);
	}
}
