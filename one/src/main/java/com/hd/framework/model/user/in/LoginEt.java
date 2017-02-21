package com.hd.framework.model.user.in;

import java.util.HashMap;
import java.util.Map;

import com.hd.framework.common.Constants;
import com.hd.framework.utils.ValidateUtil;

public class LoginEt {

	public String username;

	public String password;

	public Map<String, Object> valite() {
		Map<String, Object> message = new HashMap<String, Object>();
		if ((!ValidateUtil.vUsername(this.username, true, Constants.USERNAME_MIN, Constants.USERNAME_MAX))
				|| (!ValidateUtil.vUsername(this.password, true, Constants.PASSWORD_MIN, Constants.PASSWORD_MAX))) {
			message.put("login", "账号或密码格式不符");
		}
		return message;
	}
}
