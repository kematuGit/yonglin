package com.hd.framework.common;

public interface Constants {

	// 手机号码长度
	public static final int MOBILE_LENGTH = 11;
	
	// 用户名最小长度
	public static int USERNAME_MIN = 4;
	
	// 用户名和密码最大长度
	public static int USERNAME_MAX = 18,PASSWORD_MAX = 18;
	
	// 密码最小长度
	public static int PASSWORD_MIN = 6;
	
	// 无效状态
	public static int NO_VALID = 1;
	
	// 默认第一页
	public static int DEFAULT_PAGE_INDEX = 1;
	
	// 默认一页显示几条
	public static int DEFAULT_PAGE_SIZE=10;
	
	// 入库
	public static int STORAGE_TYPE_ONE = 1;
	
	// 出库
	public static int STORAGE_TYPE_TWO = 2;
	
	// 盘库
	public static int STORAGE_TYPE_THREE = 3;
	
	// sessionName
	public static String SESSION_NAME = "BASE_SESSION";
	
	public static String COOKIE_NAME = "BASE_COOKIE";
	
	public static String REDIRECT_LOGIN = "/login.php";
	
	// Cookie-Age (seconds)
	public static int COOKIE_AGE = 30*60;
	
	
}
