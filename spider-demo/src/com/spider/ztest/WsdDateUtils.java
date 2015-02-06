package com.spider.ztest;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 日期操作工具类
 * @version 1.0
 */
public class WsdDateUtils {
	   
    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DATE_FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_SHORT = "yyyy-MM-dd";
    
    /**
     * 将日期格式化为"yyyy-MM-dd"格式的日期
     */
    public static Date date2SimpleDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//清除时、分、秒、毫秒
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
    }
    
    /**
     * 将日期格式化为指定格式的日期
     */
    public static Date date2FormatDate(Date date,String formatStr) {
    	String tmp = dateToStr(date, formatStr);
    	return strToDate(tmp, formatStr);
    }

    /**
	 * 返回格式化的日期字符串
	 * 
	 * @param date
	 *        日期
	 * @param format
	 *        格式
	 * @return 格式化的日期字符串
	 */
    public static String dateToStr(Date date, String format)
    {
    	if (date == null) {
    		return null;
    	}
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
	 * 返回格式化的日期字符串
	 * 
	 * @param date
	 *        日期
	 * @return 格式化的日期字符串
	 */
    public static String dateToStr(Date date)
    {
        return dateToStr(date, DATE_FORMAT_LONG);
    }
    
    /**
          返回格式化的日期字符串(带T)
     * @param date
     * @return
     */
    public static String dateToTStr(Date date) {
    	String dateStr = dateToStr(date,"yyyy-MM-dd&HH:mm:ss");
    	return dateStr.replace('&', 'T');
    }

    /**
	 * 将字符串转换为日期
	 * 
	 * @param dateStr
	 *        日期字符串
	 * @param format
	 *        格式
	 * @return 日期
	 * @throws ParseException
	 */
    public static Date strToDate(String dateStr, String format)
    {
    	if (dateStr == null) {
    		return null;
    	}
        DateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(dateStr);
        }
        catch (ParseException e) {
           e.printStackTrace();
        }
		return null;
    }
    
    /**
	 * 将字符串转换为日期
	 * 
	 * @param dateStr
	 *        日期字符串
	 * @return 日期
	 * @throws ParseException
	 */
    public static Date strToDate(String dateStr)
    {
        return strToDate(dateStr, DATE_FORMAT_LONG);
    }

    /**
     * 判断字符串是否为日期类型("yyyy-MM-dd")
     * @param dateStr 字符串
     * @return true是日期类型，否则返回false
     */
    public static boolean isDate(String dateStr) {
        return dateStr.matches("^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$");
    }

    /**
     * 判断字符串是否为日期带时间类型("yyyy-MM-dd HH:mm:ss")
     * @param dateStr 字符串
     * @return true是日期带时间类型，否则返回false
     */
    public static boolean isDateTime(String dateStr) {
        return dateStr.matches("^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)) (([01]{1}\\d{1}|2[0-3]{1}):[0-5]{1}\\d{1}:[0-5]{1}\\d{1})$");
    }

    /**
     * 判断字符串是否为时间类型("HH:mm:ss")
     * @param dateStr 字符串
     * @return true是时间类型，否则返回false
     */
    public static boolean isTime(String dateStr) {
        return dateStr.matches("^([01]{1}\\d{1}|2[0-3]{1}):[0-5]{1}\\d{1}:[0-5]{1}\\d{1}$");
    }
    
    /**
     * 日期增加或减去某个天数
     * 
     * @param dt   需要操作的时间
     * @param num  增加或减去的天数
     * @return   返回操作后的时间
     */
    public static Date getBeforeOrAfterDate(Date dt,int num){
        Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DATE, num);
		return cal.getTime();
     }
    
    /**
     * 日期增加或减去某个时间单位数
     * 
     * @param dt  	需要操作的时间
     * @param num 	增加或减去的天数
     * @param typ	时间单位类型(年，月，日，星期，分钟等)
     * @return   	返回操作后的时间
     */
    public static Date getBeforeOrAfterDate(Date dt,int num, int field){
        Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(field, num);
		return cal.getTime();
    }
    
	/**
	 * 日期增加或减去某个天数
	 * 
	 * @param dt
	 *            需要操作的时间字符串
	 * @param num
	 *            增加或减去的天数
	 * @return 返回操作后的时间字符串
	 */
	public static String getBeforeOrAfterDate(String dt, int num) {
		if (isDate(dt)) {
			Date nextDate = getBeforeOrAfterDate(strToDate(dt,
					DATE_FORMAT_SHORT), num);
			return dateToStr(nextDate, DATE_FORMAT_SHORT);
		} else if (isDateTime(dt)) {
			Date nextDate = getBeforeOrAfterDate(
					strToDate(dt, DATE_FORMAT_LONG), num);
			return dateToStr(nextDate, DATE_FORMAT_LONG);
		}
		return null;
	}
	
	/**
	 * 日期增加或减去某个天数
	 * 
	 * @param dt
	 *            需要操作的时间字符串
	 * @param num
	 *            增加或减去的天数
	 * @param format
	 *            返回的日期字符串格式
	 * 
	 * @return 返回操作后的时间字符串 ,带格式format
	 */
	public static String getBeforeOrAfterDate(String dt, int num, String format) {
		Date nextDate = null;
		if (isDate(dt)) {
			nextDate = getBeforeOrAfterDate(strToDate(dt, DATE_FORMAT_SHORT),
					num);
		} else if (isDateTime(dt)) {
			nextDate = getBeforeOrAfterDate(strToDate(dt, DATE_FORMAT_LONG),
					num);
		}
		return dateToStr(nextDate, format);
	}
    
    /**
     * 返回日期是星期几
     * Calendar.SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
     * 
     * @param dt
     * @return
     */
    public static int getDayOfWeek(Date dt){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(Calendar.DAY_OF_WEEK);
	 }
    
    /**
     * 判断两个日期区间是否有交集
     * 
     * @param a1 第一个日期区间的首日日期
     * @param a2 第一个日期区间的末日日期
     * @param b1 第二个日期区间的首日日期
     * @param b2 第二个日期区间的末日日期
     * 
     * @return  有交集返回true, 没交集返回false
     */
    public static boolean hasIntersection(Date a1, Date a2, Date b1, Date b2) {
    	if ((a1.before(b1) && (a2.after(b1) || a2.equals(b1))) || 
    			((a1.after(b1) || a1.equals(b1))) && ((a1.before(b2)) || (a1.equals(b2)))) 
    		return true;
		return false;
    }
    
	/**
	 * 返回指定日期的月份
	 * 
	 * @param date		日期
	 * @return 			月份
	 */
	public static String getMonthByDate(Date date) {
	   Calendar calendar = Calendar.getInstance();
	   calendar.setTime(date);
	   return String.valueOf(calendar.get(Calendar.MONTH) + 1);
	}
	
	/**
	 * 返回月份所在季度 
	 */
	public static String getQuarterByMonth(String mon) {
		int month = Integer.parseInt(mon);
		return String.valueOf((month-1) / 3 + 1); 
	}

	/**
	 * 返回两个日期小时差
	 */
	public static double getHour(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			return 0;
		}
		long ms = getMilliSecond(d1, d2);
		return ms/1000.00/60/60;
	}
	
	/**
	 * 返回两个日期天数差
	 */
	public static long getDay(Date d1, Date d2){
		if (d1 == null || d2 == null) {
			return 0;
		}
		long ms = getMilliSecond(d1, d2);
		return ms/1000/60/60/24;
	}
	
	/**
	 * 返回两个日期毫秒差
	 */
	public static long getMilliSecond(Date d1, Date d2) {
		long d1MS = d1.getTime();
		long d2MS = d2.getTime();
		return Math.abs(d1MS - d2MS);
	}
	
	/**
	 * 获得递增数秒后的时间
	 * @param date
	 * @param amount 可以为任意整数
	 * @return
	 */
	public static Date addSeconds(Date date,int amount){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, amount);
		return cal.getTime();
	}
	
	/**
	 * 获得递增数分钟后的时间
	 * @param date
	 * @param amount 可以为任意整数
	 * @return
	 */
	public static Date addMinutes(Date date,int amount){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, amount);
		return cal.getTime();
	}
	
	/**
	 * 获得递增数小时后的时间
	 * @param date
	 * @param amount 可以为任意整数
	 * @return
	 */
	public static Date addHours(Date date,int amount){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, amount);
		return cal.getTime();
	}
	
	/**
	 * 获得递增数天后的时间
	 * @param date
	 * @param amount 可以为任意整数
	 * @return
	 */
	public static Date addDays(Date date,int amount){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, amount);
		return cal.getTime();
	}
	
	/**
	 * 在日期上加月数
	 * @param sDate
	 * @param num
	 * @return
	 */
	public static Date addMonths(Date sDate,int num){
		Calendar cal = Calendar.getInstance();
		cal.setTime(sDate);
		cal.add(Calendar.MONTH, num);
		return cal.getTime();
	}
	
	/**
	 * 获得递增数年后的时间
	 * @param date
	 * @param amount 可以为任意整数
	 * @return
	 */
	public static Date addYears(Date date,int amount){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, amount);
		return cal.getTime();
	}
	
	/**
	 * 获取某月的天数
	 * 
	 * @param year
	 *        年份
	 * @param month
	 *        月份
	 * @return 天数
	 */
	public static int getDaysByMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, 0);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 根据年月日获取时间
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return 返回指定时间
	 */
	public static Date getDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
	
	/**
	 * 返回两个日期的分钟数差
	 */
	public static long getMinute(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			return 0;
		}
		long ms = getMilliSecond(d1, d2);
		return ms/1000/60;
	}

	/**
	 * 截取时间（后面填充0，如filed取值Calendar.DAY_OF_MONTH，
	 * 		则返回的时间格式为“yyyy-MM-dd”,时、分、秒、毫秒均为0）
	 * @param date 时间
	 * @param field 时间字段
	 * @return 截取后的时间
	 */
	public static Date truncate(Date date, int field) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		} else {
			Calendar gval = Calendar.getInstance();
			gval.setTime(date);
			modify(gval, field, false);
			return gval.getTime();
		}
	}

	/**
	 * 截取时间（后面填充0，如filed取值Calendar.DAY_OF_MONTH，
	 * 		则返回的时间格式为“yyyy-MM-dd”,时、分、秒、毫秒均为0）
	 * @param date 时间
	 * @param field 时间字段
	 * @return 截取后的时间
	 */
	public static Calendar truncate(Calendar date, int field) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		} else {
			Calendar truncated = (Calendar) date.clone();
			modify(truncated, field, false);
			return truncated;
		}
	}

	/**
	 * 截取时间（后面填充0，如filed取值Calendar.DAY_OF_MONTH，
	 * 		则返回的时间格式为“yyyy-MM-dd”,时、分、秒、毫秒均为0）
	 * @param date 时间
	 * @param field 时间字段
	 * @return 截取后的时间
	 */
	public static Date truncate(Object date, int field) {
		if (date == null)
			throw new IllegalArgumentException("The date must not be null");
		if (date instanceof Date)
			return truncate((Date) date, field);
		if (date instanceof Calendar)
			return truncate((Calendar) date, field).getTime();
		else
			throw new ClassCastException("Could not truncate " + date);
	}

	private static final int fields[][] = { { 14 }, { 13 }, { 12 }, { 11, 10 },
		{ 5, 5, 9 }, { 2, 1001 }, { 1 }, { 0 } };

	private static void modify(Calendar val, int field, boolean round) {
		if (val.get(1) > 280000000)
			throw new ArithmeticException(
					"Calendar value too large for accurate calculations");
		if (field == 14)
			return;
		Date date = val.getTime();
		long time = date.getTime();
		boolean done = false;
		int millisecs = val.get(14);
		if (!round || millisecs < 500)
			time -= millisecs;
		if (field == 13)
			done = true;
		int seconds = val.get(13);
		if (!done && (!round || seconds < 30))
			time -= (long) seconds * 1000L;
		if (field == 12)
			done = true;
		int minutes = val.get(12);
		if (!done && (!round || minutes < 30))
			time -= (long) minutes * 60000L;
		if (date.getTime() != time) {
			date.setTime(time);
			val.setTime(date);
		}
		boolean roundUp = false;
		for (int i = 0; i < fields.length; i++) {
			for (int j = 0; j < fields[i].length; j++)
				if (fields[i][j] == field) {
					if (round && roundUp)
						if (field == 1001) {
							if (val.get(5) == 1) {
								val.add(5, 15);
							} else {
								val.add(5, -15);
								val.add(2, 1);
							}
						} else {
							val.add(fields[i][0], 1);
						}
					return;
				}

			int offset = 0;
			boolean offsetSet = false;
			switch (field) {
			case 1001:
				if (fields[i][0] == 5) {
					offset = val.get(5) - 1;
					if (offset >= 15)
						offset -= 15;
					roundUp = offset > 7;
					offsetSet = true;
				}
				break;

			case 9: // '\t'
				if (fields[i][0] == 11) {
					offset = val.get(11);
					if (offset >= 12)
						offset -= 12;
					roundUp = offset > 6;
					offsetSet = true;
				}
				break;
			}
			if (!offsetSet) {
				int min = val.getActualMinimum(fields[i][0]);
				int max = val.getActualMaximum(fields[i][0]);
				offset = val.get(fields[i][0]) - min;
				roundUp = offset > (max - min) / 2;
			}
			if (offset != 0)
				val.set(fields[i][0], val.get(fields[i][0]) - offset);
		}

		throw new IllegalArgumentException("The field " + field
				+ " is not supported");
	}
	
}
