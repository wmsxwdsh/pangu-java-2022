package com.pangu.utils.date;

import com.pangu.utils.enums.DateUnitEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 线程安全的日期时间工具类
 *
 * @author LZG
 */
public class DateUtil {

    /* "yyyy-MM-dd HH:mm:ss"格式类型 */
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    /* "yyyyMMdd"格式类型 */
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    /* "yyyy-MM-dd"格式类型 */
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    /* "yyyyMMddHHmmss"格式类型 */
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /* "yyyyMMddHHmmssSSS"格式类型 */
    public static final String FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddhhmmssSSS";
    /* "HH:mm:ss"格式类型 */
    public final static String FORMAT_HH_MM_SS = "HH:mm:ss";

    /* "yyyy/MM/dd"格式类型 */
    public final static String FORMAT_SLASH_YYYYMMDD = "yyyy/MM/dd"; //slash斜杠的意思

    /*------start私有方法----------*/

    // 用于存放不同模板的日期
    private static final ThreadLocal<Map<String, SimpleDateFormat>> LOCAL = new ThreadLocal<Map<String, SimpleDateFormat>>() {
        @Override
        protected Map<String, SimpleDateFormat> initialValue() {
            return new HashMap<String, SimpleDateFormat>();
        }
    };

    // 返回一个SimpleDateFormat,每个线程只会new一次pattern对应的sdf
    private static SimpleDateFormat getSdf(String pattern) {
        Map<String, SimpleDateFormat> map = LOCAL.get();
        SimpleDateFormat sdf = map.get(pattern);
        if (sdf == null) {
            sdf = new SimpleDateFormat(pattern);
            map.put(pattern, sdf);
        }
        return sdf;
    }

    /*------end私有方法----------*/

    /**
     * String Date转化为指定模板的Date
     *
     * @param dateStr
     * @param pattern
     * @return java.util.Date
     */
    public static Date stringToDate(String dateStr, String pattern) {
        try {
            SimpleDateFormat sdf = getSdf(pattern);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * date类型数据转化为指定模板的String
     *
     * @param date
     * @param pattern
     * @return java.lang.String
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = getSdf(pattern);
        return sdf.format(date);
    }

    /**
     * 获取当前日期
     *
     * @param pattern 日期的格式模板
     * @return java.lang.String
     */
    public static String getNow(String pattern) {
        SimpleDateFormat sdf = getSdf(pattern);
        return sdf.format(new Date());
    }

    /**
     * 获取昨天的日期(包含时分秒)
     * 结合DateUtil.dateToString()效果更佳
     *
     * @return java.util.Date
     */
    public static Date getYesterday() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.getTime();
    }

    /**
     * 获取明天的日期(包含时分秒)
     * * 结合DateUtil.dateToString()效果更佳
     * * 常用于限定日期时间内完成XXX事的场景
     *
     * @return java.util.Date
     */
    public static Date getTomorrow() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    /**
     * 某日期时间加上指定天数后的日期
     *
     * @param date 需要计算的日期时间
     * @param days 天数
     * @return java.util.Date
     */
    public static Date addDays(Date date, int days) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, days);
        return ca.getTime();
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return int
     */
    public static int getDistanceTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        // 1000 * 60 * 60 * 24
        long result = (afterTime - beforeTime) / (DateUnitEnum.DAY.getMillis());
        return (int) result;
    }

    /**
     * 获取某个date的年份
     *
     * @param date
     * @return int
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取某个date的月份
     *
     * @param date
     * @return int
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取某个date的day
     *
     * @param date
     * @return int
     */
    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取两个日期时间的时间差
     *
     * @param before
     * @param after
     * @param flag   0秒，1分，2时，3天
     * @return int
     */
    public static int getDifferentNum(Date before, Date after, int flag) {
        if (before == null || after == null) {
            return 0;
        }
        long timeInterval = after.getTime() - before.getTime();
        switch (flag) {
            case 0:
                return (int) (timeInterval / 1000);// 秒
            case 1:
                return (int) (timeInterval / (60 * 1000));// 分
            case 2:
                return (int) timeInterval / (60 * 60 * 1000);// 时
            case 3:
                return (int) timeInterval / (60 * 60 * 1000 * 24);// 天
        }
        return 0;
    }

    /**
     * 获取两个日期字符串之间的日期集合
     *
     * @param startTime
     * @param endTime
     * @return java.util.List<java.lang.String>
     */
    public static List<String> getBetweenDate(String startTime, String endTime) {
        // 声明保存日期集合
        List<String> list = new ArrayList<String>();
        try {

            SimpleDateFormat sdf = getSdf(FORMAT_YYYY_MM_DD);
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime() <= endDate.getTime()) {
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate = calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

}