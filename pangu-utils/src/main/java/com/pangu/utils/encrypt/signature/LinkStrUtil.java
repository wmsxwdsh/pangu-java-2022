package com.pangu.utils.encrypt.signature;

import java.util.*;

/**
 * 连接字符串工具类
 * 1、常用于json串加签
 * 2、可以对参数进行ASCII码排序
 * 3、测试用例附详细使用
 * 4、微信支付加签官方工具也是此手法
 *
 * @author LZG
 * @date 2018/8/27
 */
public class LinkStrUtil {

    /**
     * 把Map所有元素按照"参数=参数值"的模式用&拼接的字符串
     *
     * @param params   元素集合Map
     * @param needSort 是否对key按ASCII码排序
     * @return java.lang.String
     */
    public static String createLinkString(Map<String, Object> params, boolean needSort) {

        List<String> keys = new ArrayList<String>(params.keySet());

        //对key按ASCII码顺序提序
        if (needSort)
            Collections.sort(keys);

        String handledStr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = params.get(key);

            if (value instanceof HashMap) {
                HashMap<String, Object> valueHashMap = (HashMap<String, Object>) value;
                value = "{" + createLinkString(valueHashMap, needSort) + "}";
            }

            //null不参与签名、""(空串)不参与签名、sign_info不参与签名
            if (null == value || "".equals(value) || key.equalsIgnoreCase("sign_info")) {
                continue;
            }

            if (i == (keys.size() - 1)) {
                // 拼接时，不包括最后一个&字符
                handledStr = handledStr + key + "=" + value.toString();
            } else {
                handledStr = handledStr + key + "=" + value.toString() + "&";
            }

        }

        return handledStr;
    }

}