package com.zw.cn.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <pre>
 * <b>
 *   private StringBuffer format(Date date, StringBuffer toAppendTo,
 *                              FieldDelegate delegate) {
 *   // Convert input date to time field list
 *      calendar.setTime(date);
 * </b></pre>
 * DateFormat中定义了protected 的Calendar类：calendar,用其传递参数,所以导致SimpleDateFormat继承了DateFormat,在内部方法进行参数传递,造成线程安全问题,
 * 故此类中,采用ThreadLocal进行变量独享,来尝试解决此问题
 *
 * @author ZhaoWei
 * @ClassName DateUtils
 * @Description
 * @date 2016年1月8日 下午3:37:46
 */
public class DateUtils {

    protected static final String[] ALL_FORMATS = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd", "yyMMdd",
            "yyyyMMddHHmmss", "yyyyMMddHHmmssSSS", "HH:mm", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM"};


    @SuppressWarnings("serial")
    private static Map<String, ThreadLocal<DateFormat>> threadLocalPool = new HashMap<String, ThreadLocal<DateFormat>>() {{
        put("StampFmt", new ThreadLocal<DateFormat>());
        put("DateFmt", new ThreadLocal<DateFormat>());
        put("DateTimeFmt", new ThreadLocal<DateFormat>());
        put("DateMinuteFmt", new ThreadLocal<DateFormat>());
        put("DateZipFmt", new ThreadLocal<DateFormat>());
        put("DateTimeZipFmt", new ThreadLocal<DateFormat>());
        put("TimeZipFmt", new ThreadLocal<DateFormat>());
        put("StampZipFmt", new ThreadLocal<DateFormat>());
        put("YearMonthFmt", new ThreadLocal<DateFormat>());
    }};
    /**
     * yyyy-MM-dd'T'HH:mm:ss.SSSZ
     */
    public static final DateFormat StampFmt = getDateFormat("StampFmt", "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    /**
     * yyyy-MM-dd
     */
    public static final DateFormat DateFmt = getDateFormat("DateFmt", "yyyy-MM-dd");
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final DateFormat DateTimeFmt = getDateFormat("DateTimeFmt", "yyyy-MM-dd HH:mm:ss");
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final DateFormat DateMinuteFmt = getDateFormat("DateMinuteFmt", "yyyy-MM-dd HH:mm");
    /**
     * yyMMdd
     */
    public static final DateFormat DateZipFmt = getDateFormat("DateZipFmt", "yyMMdd");
    /**
     * yyyyMMddHHmmss
     */
    public static final DateFormat DateTimeZipFmt = getDateFormat("DateTimeZipFmt", "yyyyMMddHHmmss");
    /**
     * HH:mm
     */
    public static final DateFormat TimeZipFmt = getDateFormat("TimeZipFmt", "HH:mm");
    /**
     * yyyyMMddHHmmssSSS
     */
    public static final DateFormat StampZipFmt = getDateFormat("StampZipFmt", "yyyyMMddHHmmssSSS");
    /**
     * yyyy-MM
     */
    public static final DateFormat YearMonthFmt = getDateFormat("YearMonthFmt", "yyyy-MM");

    public static DateFormat defaultDateFmt = DateTimeFmt;

    private static DateFormat getDateFormat(String key, String pattern) {
        ThreadLocal<DateFormat> threadLocal = threadLocalPool.get(key);
        DateFormat df = threadLocal.get();
        if (df == null) {
            df = new SimpleDateFormat(pattern);
            threadLocal.set(df);
        }
        return df;
    }

    /**
     * 以默认defaultDateFmt(yyyy-MM-dd HH:mm:ss)解析时间,<br>
     *
     * @param source
     * @return
     * @throws ParseException
     */
    public static Date parse(String source) throws ParseException {
        return parse(defaultDateFmt, source);
    }

    public static Date parse(DateFormat dateFormet, String source) throws ParseException {
        return dateFormet.parse(source);
    }

    /**
     * 默认defaultDateFmt(yyyy-MM-dd HH:mm:ss)解析时间字符串
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(defaultDateFmt, date);
    }

    public static String format(DateFormat dateFormet, Date date) {
        return dateFormet.format(date);
    }

    /**
     * 取当前时间
     *
     * @param format defaultDateFmt
     * @return
     */
    public static String formatCurrentTime() {
        return formatCurrentTime(defaultDateFmt);
    }

    /**
     * 取当前时间
     *
     * @param format
     * @return
     */
    public static String formatCurrentTime(DateFormat sdf) {
        Date now = new Date();
        return sdf.format(now);
    }

    /**
     * 取当前时间
     *
     * @param format 格式示例： yyyyMMddHHmmss
     * @return
     */
    public static String formatCurrentTime(String format) {
        SimpleDateFormat outFormat = new SimpleDateFormat(format);
        return formatCurrentTime(outFormat);
    }


    private static Date getDate(Date date, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        if (null != date) {
            calendar.setTime(date);
        }
        calendar.add(field, amount);
        return calendar.getTime();
    }

    private static Date getDate(int field, int amount) {
        return getDate(null, field, amount);
    }

    public static Date addHours(Date date, int hours) {
        return getDate(date, Calendar.HOUR, hours);
    }

    public static Date addHours(int hours) {
        return getDate(Calendar.HOUR, hours);
    }

    public static Date addMins(int mins) {
        return getDate(Calendar.MINUTE, mins);
    }

    public static Date addMins(Date date, int mins) {
        return getDate(date, Calendar.MINUTE, mins);
    }

    public static Date addSecond(int mins) {
        return getDate(Calendar.SECOND, mins);
    }

    public static Date addSecond(Date date, int mins) {
        return getDate(date, Calendar.SECOND, mins);
    }

    public static Date addDays(int days) {
        return getDate(Calendar.DAY_OF_MONTH, days);
    }

    public static Date addDays(Date date, int days) {
        return getDate(date, Calendar.DAY_OF_MONTH, days);
    }

    public static Date addWeeks(int weeks) {
        return getDate(Calendar.WEEK_OF_YEAR, weeks);
    }

    public static Date addWeeks(Date date, int weeks) {
        return getDate(date, Calendar.WEEK_OF_YEAR, weeks);
    }

    public static Date addMonths(int months) {
        return getDate(Calendar.MONTH, months);
    }

    public static Date addMonths(Date date, int months) {
        return getDate(date, Calendar.MONTH, months);
    }

    public static Date addYears(int years) {
        return getDate(Calendar.YEAR, years);
    }

    public static Date addYears(Date date, int years) {
        return getDate(date, Calendar.YEAR, years);
    }

    /**
     * @param fromDate: start Date
     * @param toDate:   end Date
     * @return
     */
    public static long getSecondsBetween(Date fromDate, Date toDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);

        Calendar anotherCalendar = Calendar.getInstance();
        anotherCalendar.setTime(toDate);
        return (anotherCalendar.getTimeInMillis() - calendar.getTimeInMillis()) / 1000;
    }

    /**
     * 判断两个日期是否同一天
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean isSameDay(Date first, Date second) {
        Date range[] = getDayPeriod(first);
        return second.after(range[0]) && second.before(range[1]);
    }

    /**
     * 计算一天的起始时间和结束时间.
     *
     * @param date
     * @return
     */
    public static Date[] getDayPeriod(Date date) {
        if (date == null) {
            return null;
        }
        Date[] dtary = new Date[2];
        dtary[0] = getDayMinTime(date);
        dtary[1] = getDayMaxTime(date);
        return dtary;
    }

    /**
     * 获得当前天的最小时间
     *
     * @param date
     * @return
     */
    public static Date getDayMinTime() {
        return getDayMinTime(new Date());
    }

    /**
     * 获得当前天的最小时间
     *
     * @param date
     * @return
     */
    public static Date getConcurrentDayMinTime() {
        return getDayMinTime(new Date());
    }

    /**
     * 获得指定日期的最小时间
     *
     * @param date
     * @return
     */
    public static Date getDayMinTime(Date date) {
        return getSpecifiedTime(date, 0, 0, 0);
    }

    /**
     * 获得指定日期的最小时间(Calendar)
     *
     * @param date
     * @return Calendar
     */
    public static Calendar getDayMinTime2(Date date) {
        return getSpecifiedCalendar(date, 0, 0, 0);
    }

    /**
     * 获得指定日期的指定时、分、秒日期
     *
     * @param date
     * @param hours
     * @param minutes
     * @param seconds
     * @return
     */
    public static Date getSpecifiedTime(Date date, int hours, int minutes, int seconds) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.clear(Calendar.MILLISECOND);
        c.set(Calendar.HOUR_OF_DAY, hours);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.SECOND, seconds);
        return c.getTime();
    }

    /**
     * 获得指定日期的指定时、分、秒日期(Calendar)
     *
     * @param date
     * @param hours
     * @param minutes
     * @param seconds
     * @return
     */
    public static Calendar getSpecifiedCalendar(Date date, int hours, int minutes, int seconds) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.clear(Calendar.MILLISECOND);
        c.set(Calendar.HOUR_OF_DAY, hours);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.SECOND, seconds);

        return c;
    }

    /**
     * 获得指定日期的最大时间
     *
     * @param date
     * @return
     */
    public static Date getDayMaxTime(Date date) {
        return getSpecifiedTime(date, 23, 59, 59);
    }

    /**
     * 获得当天的最大时间
     *
     * @param date
     * @return
     */
    public static Date getDayMaxTime() {
        return getDayMaxTime(new Date());
    }

    /**
     * 获取第二天凌晨时间
     *
     * @param date
     * @return
     */
    public static Date getNextZeroDay() {
        return getNextZeroDay(new Date());
    }

    /**
     * 获取昨天凌晨时间
     *
     * @param date
     * @return
     */
    public static Date getYesterdayZeroDay(Date date) {
        return getSpecifiedTime(date, -24, 00, 00);
    }

    /**
     * 获取昨天凌晨时间
     *
     * @param date
     * @return Date
     */
    public static Date getYesterdayZeroDay() {
        return getYesterdayZeroDay(new Date());
    }

    /**
     * 获取昨天凌晨时间
     *
     * @param date
     * @return Calendar
     */
    public static Calendar getYesterdayZeroDay2(Date date) {
        return getSpecifiedCalendar(date, -24, 00, 00);
    }

    /**
     * 获取昨天凌晨时间
     *
     * @param date
     * @return
     */
    public static Calendar getYesterdayZeroDay2() {
        return getYesterdayZeroDay2(new Date());
    }

    /**
     * 获取第二天凌晨时间
     *
     * @param date
     * @return
     */
    public static Date getNextZeroDay(Date date) {
        return getSpecifiedTime(date, 24, 00, 00);
    }

    /**
     * 获取第二天凌晨时间
     *
     * @param date
     * @return
     */
    public static Calendar getNextZeroDay2(Date date) {
        return getSpecifiedCalendar(date, 24, 00, 00);
    }

    /**
     * super add in 2015-07-10 获取两日期相差几天
     **/
    public static int getBetweenDay(Date date1, Date date2) {
        Calendar d1 = new GregorianCalendar();
        d1.setTime(date1);
        Calendar d2 = new GregorianCalendar();
        d2.setTime(date2);
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            // d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * 获得当前日期的上个周一的日期
     *
     * @param date
     * @return
     * @author ZhaoWei
     * @date 2017年5月11日 下午4:56:58
     */
    public static Date getLastMonday() {

        return getLastMonday(new Date());
    }

    /**
     * 获得指定日期的上个周一的日期
     *
     * @param date
     * @return
     * @author ZhaoWei
     * @date 2017年5月11日 下午4:56:58
     */
    public static Date getLastMonday(Date date) {

        Calendar c = getYesterdayZeroDay2(date);
        c.add(Calendar.WEEK_OF_MONTH, -1);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getTime();
    }

    /**
     * 获取当前日期的上个周日的日期
     *
     * @param date
     * @return
     * @author ZhaoWei
     * @date 2017年5月11日 下午4:57:14
     */
    public static Date getLastSunday() {

        return getLastSunday(new Date());
    }

    /**
     * 获取指定日期的上个周日的日期
     *
     * @param date
     * @return
     * @author ZhaoWei
     * @date 2017年5月11日 下午4:57:14
     */
    public static Date getLastSunday(Date date) {

        Calendar c = getYesterdayZeroDay2(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return c.getTime();
    }

    /**
     * @return date
     * @throws
     * @Title: getCurrentMonthFirstDay
     * @Description: 获取当前月1号的日期
     * @author QihaoJin
     */
    public static Date getCurrentMonthFirstDay() {
        return getCurrentMonthFirstDay(new Date());
    }

    /**
     * @param date
     * @return date
     * @throws
     * @Title: getCurrentMonthFirstDay
     * @Description: 获取指定日期当月1号的日期
     * @author QihaoJin
     */
    public static Date getCurrentMonthFirstDay(Date date) {

        Calendar c = getDayMinTime2(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * @param date
     * @return Date
     * @throws
     * @Title: getLastMonthFirstDay
     * @Description: 获取指定日期上个月1号的日期
     * @author QihaoJin
     */
    public static Date getLastMonthFirstDay(Date date) {
        Calendar c = getDayMinTime2(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * @param date
     * @param
     * @return Date
     * @throws
     * @Title: getCurrentWeekMonday
     * @Description: 获取当前周周一的日期
     * @author QihaoJin
     */
    public static Date getCurrentWeekMonday() {
        return getCurrentWeekMonday(new Date());
    }

    /**
     * @param date
     * @param
     * @return Date
     * @throws
     * @Title: getCurrentWeekMonday
     * @Description: 获取指定日期当前周周一的日期
     * @author QihaoJin
     */
    public static Date getCurrentWeekMonday(Date date) {

        Calendar c = getDayMinTime2(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getTime();
    }

    /**
     * @param date
     * @param
     * @return Date
     * @throws
     * @Title: getLastWeekMonday
     * @Description: 获取指定日期上周周一的日期
     * @author QihaoJin
     */
    public static Date getLastWeekMonday(Date date) {
        return getLastMonday(date);
    }
}
