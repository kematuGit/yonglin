package com.hd.framework.utils;

public abstract class PageUtil {

	public static int totalPage(int total, int pageSize) {
		if ((total % pageSize) == 0) {
			return (total / pageSize);
		}
		return (total / pageSize + 1);
	}
}
