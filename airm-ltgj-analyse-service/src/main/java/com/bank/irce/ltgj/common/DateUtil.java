package com.bank.irce.ltgj.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *  日期处理工具类
 **/
public final class DateUtil {

    public static final String FORMAT_DATE_1 = "yyyyMMdd";

    public static final String FORMAT_DATE_2 = "yyyyMMdd";

    public static final String FORMAT_DATE_3 = "yyyy年MM月";

    public static final String FORMAT_DATE_4 = "yyyy.MM.dd HH:mm:ss";

    public static final String FORMAT_DATE_5 = "yyyy.MM.dd";

    public static final String FORMAT_DATE_6 = "yyyy-MM-dd";

    public static final String FORMAT_DATE_7 = "yyyy年MM月dd日";

    public static final String FORMAT_DATE_8 = "yyyy年MM月dd日到期";

    public static final String FORMAT_DATE_9 = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_DATE_10 = "M月d日";

    public static final String FORMAT_DATE_11 = "MM-dd";

    private static final SimpleDateFormat FORMAT_DATE_2_PATTERN = new SimpleDateFormat(FORMAT_DATE_2);

    /**
     * 计算YYYYMMDD的时间差
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int betweenDate(String date1,String date2) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE_2);
        long end = formatter.parse(date1).getTime();
        long start= formatter.parse(date2).getTime();
        long time = (end-start);
        long internal = time/(1000*60*60*24);
        return (int) internal;
    }

    public static Date stampToDate(String s, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(s);
        return date;
    }



    public static String dateToStamp(Date date, String pattern) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        res = simpleDateFormat.format(date);
        return res;
    }
    public static String getCurTimeStamp() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(date);
    }
    public static String getNowyyyy_MM_dd_HH_mm_ss() {
        Date date = new Date(System.currentTimeMillis());
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    public static String getNowyyyyMMddHHmmss() {
        Date date = new Date(System.currentTimeMillis());
        return formatDate(date, "yyyyMMddHHmmss");
    }
    public static String getNowyyyyMMdd() {
        Date date = new Date(System.currentTimeMillis());
        return formatDate(date, "yyyyMMdd");
    }
    public static String getNowyyyy_MM_dd() {
        Date date = new Date(System.currentTimeMillis());
        return formatDate(date, "yyyy-MM-dd");
    }
    public static String getNowyyyy_MM() {
        Date date = new Date(System.currentTimeMillis());
        return formatDate(date, "yyyy-MM");
    }
    public static String getNowyyyy_d() {
        Date date = new Date(System.currentTimeMillis());
        return formatDate(date, "d");
    }
    public static Date GetDate(String date, String Format) throws ParseException {
        Date tmpdate = null;
        DateFormat df = new SimpleDateFormat(Format);
        tmpdate = df.parse(date);
        return tmpdate;
    }
    public static String getYesyyyy_MM_dd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return formatDate(calendar.getTime(), "yyyy-MM-dd");
    }
    /**
     * 格式化日期
     *
     * @param dateStr 字符型日期
     * @param format  格式
     * @return 返回日期
     */
    public static Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(format);
            //String dt = dateStr.replaceAll("-", "/");
            /*if ((!dateStr.equals("")) && (dateStr.length() < format.length())) {
                dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]", "0");
            }*/
            date =  df.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }


    /**
     * 格式化日期
     *
     * @param dateStr 字符型日期
     * @param format  格式
     * @return 返回日期
     */
    public static Date parseDate_NoCheck(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(format);
            date = (Date) df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @param dateStr
     * @return Date
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, "yyyy/MM/dd");
    }

    /**
     * @param dateStr
     * @return Date
     */
    public static Date parseDate1(String dateStr) {
        return parseDate(dateStr, "yyyy-MM-dd");
    }

    /**
     * 格式化输出日期
     *
     * @param date   日期
     * @param format 格式
     * @return 返回字符型日期
     */
    public static String format(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                DateFormat df = new SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 常用的格式化日期
     *
     * @param date Date
     * @return String
     */
    public static String formatDate(Date date, String format) {
        return format(date, format);
    }

    /**
     * 常用的格式化日期
     *
     * @param date Date
     * @return String
     */
    public static String formatDate(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 输出时间
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 返回年份
     *
     * @param date 日期
     * @return 返回年份
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 返回月份
     *
     * @param date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日份
     *
     * @param date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 返回字符型日期
     *
     * @param date 日期
     * @return 返回字符型日期
     */
    public static String getDate(Date date) {
        return format(date, "yyyy/MM/dd");
    }

    /**
     * 返回字符型时间
     *
     * @param date 日期
     * @return 返回字符型时间
     */
    public static String getTime(Date date) {
        return format(date, "HH:mm:ss");
    }

    /**
     * 返回字符型日期时间
     *
     * @param date 日期
     * @return 返回字符型日期时间
     */
    public static String getDateTime(Date date) {
        return format(date, "yyyy/MM/dd HH:mm:ss");
    }

    /**
     * 日期相加
     *
     * @param date 日期
     * @param day  天数
     * @return 返回相加后的日期
     */
    public static Date addDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 日期相减
     *
     * @param date  日期
     * @param date1 日期
     * @return 返回相减后的日期
     */
    public static int diffDate(Date date, Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
    }

    /**
     * 取得指定月份的第一天
     *
     * @param strdate String
     * @return String
     */
    public static String getMonthBegin(String strdate) {
        Date date = parseDate(strdate);
        return format(date, "yyyy-MM") + "-01";
    }

    /**
     * 取得指定月份的最后一天
     *
     * @param strdate String
     * @return String
     */
    public static String getMonthEnd(String strdate) {
        Date date = parseDate(getMonthBegin(strdate));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return formatDate(calendar.getTime());
    }

    /**
     * 计算传入值是否星期(六)
     *
     * @param str
     * @return boolean - 是返回true
     */
    public boolean checkWeek6(String str, int week) {
        boolean flag = false;
        int realWeek = 0;
        str = str.replace('/', '-');
        Calendar cal = Calendar.getInstance();
        cal.setTime(java.sql.Date.valueOf(str.substring(0, 10)));
        realWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (realWeek == (week + 1)) {
            flag = true;
        }
        return flag;
    }

    public static Date parseMonth(Date date) {
        String str = DateUtil.format(date, "yyyy.MM.dd");
        return DateUtil.parseDate(str, "yyyy.MM.dd");
    }

    /**
     * 月份增加 i
     *
     * @param date
     * @return
     */
    public static Date addMonth(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i);
        return calendar.getTime();
    }

    public static String replaceDay(String date,String day){
        StringBuffer sb = new StringBuffer(date.substring(0,10));
        StringBuffer replace = sb.replace(sb.length() - 2, sb.length(), day);
        return replace.toString();
    }

    public static Date addDay(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, i);
        return calendar.getTime();
    }

    public static int getMothDiff(Date arg1,Date arg2){
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(arg1);
        c2.setTime(arg2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c1.get(Calendar.DAY_OF_MONTH);
        int yearInterval = year1-year2;
        if ( month1<month2 || month1==month2 && day1<day2 ){
            yearInterval--;
        }
        int monthInterval = (month1+12)-month2;
        if (day1<day2){
            monthInterval--;
        }
        monthInterval%=12;
        int monthsDiff = Math.abs(yearInterval*12 + monthInterval);
        return  monthsDiff;
    }

    public static Date getMinDate(List<Date> dateList){
        dateList.sort((a1,a2) -> {
            if(a1.after(a2)){
                return 1;
            }else {
                return -1;
            }
        });
        return dateList.get(0);
    }

    public static int monthBetween(Date now,Date before){
        return (DateUtil.getYear(now)-DateUtil.getYear(before))*12 +
                (DateUtil.getMonth(now)-DateUtil.getMonth(before)) +
                (DateUtil.getDay(now) >= DateUtil.getDay(before) ? 1 : 0);
    }
    /**
     * 求两个yyyy-MM-dd格式日期较小者
     *
     * @param oriDate 日期1
     * @param newDate  日期2
     * @return 返回日期
     */
    public static String  getSmallerDate1(String oriDate,String newDate) {
        if (oriDate == null || oriDate == "" || oriDate == "NaN"){
            return newDate;
        }else if (newDate == null || newDate == "" || newDate == "NaN"){
            return oriDate;
        } else {
            Date parseDatea1 = parseDate(oriDate, "yyyy-MM-dd");
            Date parseDatea2 = parseDate(newDate, "yyyy-MM-dd");
            if (parseDatea1.getTime() < parseDatea2.getTime()) {
                return oriDate;
            } else {
                return newDate;
            }
        }
    }

    public static Date getMaxDate(List<Date> dateList){
        dateList.sort((a1,a2) -> {
            if(a1.before(a2)){
                return 1;
            }else {
                return -1;
            }
        });
        return dateList.get(0);
    }

    /**
     * 求两个yyyy.MM.dd格式日期较大者
     *
     * @param oriDate 原始日期1
     * @param newDate 新日期2
     * @return 返回日期
     */
    public static String  getBiggerDate(String oriDate,String newDate){
        if (oriDate == null){
            return newDate;
        }else if (newDate == null){
            return oriDate;
        }else{
            Date parseDatea1 = parseDate(oriDate, "yyyy.MM.dd");
            Date parseDatea2 = parseDate(newDate, "yyyy.MM.dd");
            if (parseDatea1.getTime() > parseDatea2.getTime()){
                return oriDate;
            }else {
                return newDate;
            }
        }
    }
    /**
     * 求两个yyyy-MM-dd格式日期较大者
     *
     * @param oriDate 原始日期1
     * @param newDate 新日期2
     * @return 返回日期
     */
    public static String  getBiggerDate1(String oriDate,String newDate){
        if (oriDate == null || oriDate == "" || oriDate == "NaN"){
            return newDate;
        }else if (newDate == null || newDate == "" || newDate == "NaN"){
            return oriDate;
        }else{
            Date parseDatea1 = parseDate(oriDate, "yyyy-MM-dd");
            Date parseDatea2 = parseDate(newDate, "yyyy-MM-dd");
            if (parseDatea1.getTime() > parseDatea2.getTime()){
                return oriDate;
            }else {
                return newDate;
            }
        }
    }
    public static String  getSmallerDate2(String oriDate,String newDate) {
        if (oriDate == null || oriDate == "" || oriDate == "NaN"){
            return newDate;
        }else if (newDate == null || newDate == "" || newDate == "NaN"){
            return oriDate;
        } else {
            Date parseDatea1 = parseDate(oriDate, "yyyy-MM");
            Date parseDatea2 = parseDate(newDate, "yyyy-MM");
            if (parseDatea1.getTime() < parseDatea2.getTime()) {
                return oriDate;
            } else {
                return newDate;
            }
        }
    }

    public static void main(String[] args) {
        Date lastDate = DateUtil.parseDate("2019-02-12", "yyyy-MM-dd");
        Date lastDay = DateUtil.parseDate("2019-03-12", "yyyy-MM-dd");
        Long day = (lastDay.getTime()-lastDate.getTime())/(24*60*60*1000);
        System.out.println(day);
    }

}
