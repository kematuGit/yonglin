package com.hd.framework.common;

/**
 * 正则通用验证表达式
 * 
 * @author Kite
 * @version v2.0.0
 * @since 2016年3月29日
 */
public interface RegularConstants {

    /** 手机验证（11位数字） */
    String PHONE = "\\d{11}$";

    /** 详细手机验证，核心库不推荐 */
    String MOBILE = "^((1[3,7,8][0-9])|(15[^4,\\D]))\\d{8}$";

    /** 详细邮箱验证，核心库不推荐 */
    String EMAIL = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

    /** 验证字符串前后不能为空格 */
    String NOT_EMPTY = "^\\S*[^\\s]$|[^\\s]{1,}.*[^\\s]$";// 字符串前后不能为空

    /** 只包含英文和数字 */
    String ENGLISH_AND_NUMBER = "^[a-zA-Z0-9_]+$";

    /** 中英文数字 */
    String ENGLISH_NUMBER_CHINESE = "^[a-zA-Z0-9\u4E00-\u9FA5]+$";

    /** 中英文数字加括号和横杆 */
    String VARCHAR = "^[a-zA-Z0-9\u4E00-\u9FA5（）()-]+$";

    /** 学校代码 */
    String SCHOOL_CODE = "^[A-Z]+$";

    /** 来源 */
    String REFERER = "SC|NT";

    String REGEX_CHINESE_AND_ENGLISH = "^[a-zA-Z\u4E00-\u9FA5]+$";
}
