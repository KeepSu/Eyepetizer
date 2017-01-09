package com.tzs.eyepetizer.util;


import android.util.Log;

import java.util.Calendar;

/**
 * 时间工具类
 */

public class TimeUtil {

    /**
     * 把int类型的事件转换成01'20"的格式
     *
     * @param time
     * @return
     */
    public static String getDurnig(int time) {
        String during = "";
        if (time / 60 < 10) {
            during = "0";
        }
        during = during + time / 60 + "' ";
        if (time % 60 < 10) {
            during = during + "0";
        }
        during = during + time % 60 + "\"";
        return during;
    }

    /**
     * 获取当天的日期
     */
    public static String getDateToday() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String result = "-" + getWeekDay(week) + "," + getMonth(month) + "." + getDay(day) + "-";
        return result;
    }

    /**
     * 获取日数
     */
    private static String getDay(int day) {
        if (day < 10) {
            return "0" + day;
        }
        return "" + day;
    }

    /**
     * 获取月份
     */
    private static String getMonth(int month) {
        String result = null;
        switch (month) {
            case 0:
                result = "Jan";
                break;
            case 1:
                result = "Feb";
                break;
            case 2:
                result = "Mar";
                break;
            case 3:
                result = "Apr";
                break;
            case 4:
                result = "May";
                break;
            case 5:
                result = "Jun";
                break;
            case 6:
                result = "Jul";
                break;
            case 7:
                result = "Aug";
                break;
            case 8:
                result = "Sep";
                break;
            case 9:
                result = "Oct";
                break;
            case 10:
                result = "Nov";
                break;
            case 11:
                result = "Dec";
                break;
        }

        return result;
    }

    /**
     * 获取星期数
     */
    private static String getWeekDay(int week) {
        String result = null;
        switch (week) {
            case 2:
                result = "Monday";
                break;
            case 3:
                result = "Tuesday";
                break;
            case 4:
                result = "Wednesday";
                break;
            case 5:
                result = "Thursday";
                break;
            case 6:
                result = "Friday";
                break;
            case 7:
                result = "Saturday";
                break;
            case 1:
                result = "Sunday";
                break;
        }
        return result;
    }

}
