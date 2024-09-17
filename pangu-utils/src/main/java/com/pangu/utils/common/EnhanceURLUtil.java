package com.pangu.utils.common;

import cn.hutool.core.util.URLUtil;

/**
 * 可用于 Sub Convert
 * @author LZG
 */
public class EnhanceURLUtil {

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
        // 解码，还原出原来
        String lastUrl = "";
        String firstUrl = decode(lastUrl);
        System.out.println(firstUrl);

        System.out.println("---------");

        // 生成加码的
        String sourceUrl = "";
        String result = decode(sourceUrl);
        System.out.println(result);

    }

}

