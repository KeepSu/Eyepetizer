package com.tzs.eyepetizer.util;

/**
 * Created by h on 2016/12/29.
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
}
