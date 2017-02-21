package com.hd.framework.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public abstract class CookieUtil {

	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				return cookie;
			}
		}
		return null;
	}
	
	public static void remove(HttpServletRequest request,String cookieName){
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				cookie.setMaxAge(0);
			}
		}
	}
}
