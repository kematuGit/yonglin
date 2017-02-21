package com.hd.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.hd.framework.common.RegularConstants;

public abstract class ValidateUtil {

	// 验证手机
	public static boolean vMobile(String mobile, boolean isMust, int min, int max) {
		return regular(mobile, isMust, RegularConstants.MOBILE, min, max);
	}

	// 验证邮箱
	public static boolean vEmail(String email, boolean isMust, int min, int max) {
		return regular(email, isMust, RegularConstants.EMAIL, min, max);
	}

	// 验证账号
	public static boolean vUsername(String username, boolean isMust, int min, int max) {
		return regular(username, isMust, RegularConstants.ENGLISH_AND_NUMBER, min, max);
	}

	// 验证密码
	public static boolean vPassword(String password, boolean isMust, int min, int max) {
		return regular(password, isMust, RegularConstants.ENGLISH_AND_NUMBER, min, max);
	}

	// 验证字符串长度
	public static boolean vStrLen(String target, boolean isMust, int min, int max) {
		return regular(target, isMust, RegularConstants.VARCHAR, min, max);
	}

	private static boolean regular(String target, boolean isMust, String rConstants, int min, int max) {
		if (!isMust) {
			if (StringUtils.isEmpty(target)) {
				return true;
			}
		} else {
			if (StringUtils.isEmpty(target)) {
				return false;
			}
		}
		if (min > 0 && max > min) {
			if (target.length() < min || target.length() > max) {
				return false;
			}
		}
		Pattern pattern = Pattern.compile(rConstants);
		Matcher matcher = pattern.matcher(target);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}
}
