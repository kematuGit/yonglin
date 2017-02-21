package com.hd.framework.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;

import com.hd.framework.common.Constants;
import com.hd.framework.model.BasicUser;

public abstract class SessionUtil {

	public static BasicUser currentUser(NativeWebRequest webRequest) {
		if (webRequest.getAttribute(Constants.SESSION_NAME, RequestAttributes.SCOPE_SESSION) != null) {
			return (BasicUser) webRequest.getAttribute(Constants.SESSION_NAME, RequestAttributes.SCOPE_SESSION);
		}
		return null;
	}

	public static BasicUser currentUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			return (BasicUser) session.getAttribute(Constants.SESSION_NAME);
		}
		return null;
	}
	
	public static void remove(HttpServletRequest request,String sessionName){
		request.getSession().setAttribute(sessionName, null);
	}
	
}
