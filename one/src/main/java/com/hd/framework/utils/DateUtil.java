package com.hd.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class DateUtil {

	public static String YMD_HMS = "yyyy-MM-dd HH:mm:ss";

	public static String YMD = "yyyy-MM-dd";

	public static String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

	public static String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };

	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String getWeekOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysName[intWeek];
	}

	public static Date getTodayStartTime() {
		return getTodayTime("START-TIME");
	}

	public static Date getTodayEndTime() {
		return getTodayTime("END-TIME");
	}

	public static Date getFutureTime(int days) {
		return plus(getTodayEndTime(), Calendar.DAY_OF_YEAR, days);
	}

	private static Date getTodayTime(String startOrEnd) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		if (startOrEnd.equals("START-TIME")) {
			return today.getTime();
		}

		if (startOrEnd.equals("END-TIME")) {
			today.add(Calendar.HOUR_OF_DAY, 24);
			return today.getTime();
		}

		return null;
	}

	public static Date getTommorrowOne() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(GregorianCalendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static long getCountMinutes(Date startTime, Date endTime) {
		if (startTime == null || endTime == null) {
			return 0;
		}
		return (endTime.getTime() - startTime.getTime()) / (1000 * 60);
	}

	public static long getCountSeconds(Date startTime, Date endTime) {
		if (startTime == null || endTime == null) {
			return 0;
		}
		return (endTime.getTime() - startTime.getTime()) / (1000);
	}

	/**
	 * 
	 * @param date
	 * @param type
	 *            Calendar的枚举类型
	 * @param days
	 * @return
	 */
	public static Date plus(Date date, int type, int days) {
		Calendar today = Calendar.getInstance();
		today.setTime(date);
		today.add(type, days);// 把日期往后增加一天.整数往后推,负数往前移动
		return today.getTime();
	}

	/**
	 * 获取分钟
	 */
	public static long getCountMinutes(Date date, int type, int days) {
		return plus(date, type, days).getTime() / 60000;
	}

	/**
	 * 获取分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long getCountMinutes(Date date) {
		return (date.getTime() - System.currentTimeMillis()) / 60000;
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getTodayLeftMinutes() {
		long hour = 60;
		long time = System.currentTimeMillis() / 60000;// 秒
		// System.currentTimeMillis() 是零时区的时间戳，所以你要加上8个小时才行。
		time += 8 * hour;
		time %= 24 * hour;
		time = 24 * hour - time;
		return time;
	}

	public static int getCountWeeks(Date startDate, Date endDate) {
		Calendar begin = new GregorianCalendar();
		Calendar end = new GregorianCalendar();
		begin.setTime(startDate); // Calendar的月从0-11，所以4月是3.
		end.setTime(endDate); // Calendar的月从0-11，所以5月是4.

		int count = 1;
		// end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天

		while (begin.before(end)) {
			if (begin.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				count++;
			}
			begin.add(Calendar.DAY_OF_YEAR, 1);
		}

		return count;
	}

	/**
	 * 获取时间差（天）
	 * 
	 * @param date
	 * @return
	 */
	public static long getTimeDayDifference(Date date) {
		if (null == date) {
			return 0;
		}
		return (zeroTime(new Date()).getTime() - zeroTime(date).getTime()) / (1000 * 60 * 60 * 24);
	}

	public static Date zeroTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}
}
