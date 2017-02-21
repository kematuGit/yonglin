package com.hd.framework.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hd.framework.common.Constants;
import com.hd.framework.model.CoreUser;
import com.hd.framework.utils.CookieUtil;

public class CommonInterceptor implements HandlerInterceptor {

	public static String[] URIS = new String[] { "/user" };

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		String uri = request.getRequestURI();
//		if (isNeedAuth(uri)) {
//			HttpSession session = request.getSession();
//			Cookie cookie = CookieUtil.getCookie(request, Constants.COOKIE_NAME);
//			if (session != null && cookie != null) {
//				Object user = session.getAttribute(Constants.SESSION_NAME);
//				if (user != null) {
//					CoreUser core = (CoreUser) user;
//					if (!String.valueOf(core.id).equals(cookie.getValue())) {
//						response.sendRedirect(Constants.REDIRECT_LOGIN);
//					}
//				} else {
//					response.sendRedirect(Constants.REDIRECT_LOGIN);
//				}
//			} else {
//				response.sendRedirect(Constants.REDIRECT_LOGIN);
//			}
//		}

		return true;
	}

	private boolean isNeedAuth(String target) {
		for (String uri : URIS) {
			if (target.startsWith(uri)) {
				return true;
			}
		}
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
