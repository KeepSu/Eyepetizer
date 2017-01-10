package com.tzs.eyepetizer.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by TZS on 2017/1/5.
 */

public class DecodeUtil {

    /**
     * URLDecode
     * @param string 要解码的字符串
     * @return 解码后的字符串
     */
    public static String StringDecode (String string) {
        String str = null;
        try {
            str = URLDecoder.decode(string, "UTF-8");
            return str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}