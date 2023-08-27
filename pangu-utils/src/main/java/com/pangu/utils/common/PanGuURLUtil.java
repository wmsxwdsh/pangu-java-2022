package com.pangu.utils.common;

import cn.hutool.core.util.URLUtil;

/**
 * @author LZG
 */
public class PanGuURLUtil {

    /**
     * url encode
     * @param url
     * @return
     */
    public static String encode(String url) {
        return URLUtil.encode(url);
    }

    /**
     * url decode（解码）
     * @param url
     * @return
     */
    public static String decode(String url) {
        return URLUtil.decode(url);
    }


    public static void main(String[] args) {
        String testUrl = "";
        String result = decode(testUrl);
        System.out.println(result);
    }

}

