package com.hd.framework.service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.hd.framework.common.Constants;
import com.hd.framework.model.CoreUser;
import com.hd.framework.model.user.in.LoginEt;
import com.hd.framework.model.user.out.UserRt;

@Service
public class LoginService {

	@Resource
	private UserService userService;

	// 验证登录
	public boolean checkLogin(LoginEt loginEt, HttpSession session, HttpServletResponse response) {
		UserRt userRt = userService.selectOneByUsername(loginEt.username);
		if (userRt != null) {
			if (loginEt.password.equals(userRt.password)) {
				Cookie cookie = new Cookie(Constants.COOKIE_NAME, userRt.id + "");
				cookie.setMaxAge(Constants.COOKIE_AGE);
				response.addCookie(cookie);
				CoreUser coreUser = new CoreUser(userRt);
				session.setAttribute(Constants.SESSION_NAME, coreUser);
				return true;
			}
		}
		return false;
	}

	public boolean checkLogin(LoginEt loginEt) {
		UserRt userRt = userService.selectOneByUsername(loginEt.username);
		if (userRt != null) {
			if (loginEt.password.equals(userRt.password)) {
				return true;
			}
		}
		return false;
	}

}
