package com.pangu.utils.encrypt.signature;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * md5签名工具类
 *
 * @author LZG
 * @date 2019/3/4
 */
public class Md5SignUtil {

    public static String md5SignKey = "pangu-java";

    /**
     * 加签（&key=拼接到最后）
     *
     * @param text 需要签名的字符串
     * @param key  密钥
     * @return java.lang.String
     */
    public static String sign(String text, String key) {
        text = text + "&key=" + key;
        return DigestUtils.md5Hex(getContentBytes(text, "UTF-8"));
    }

    /**
     * 验签
     *
     * @param text 需要验签的字符串
     * @param sign 签名结果
     * @param key  密钥
     * @return boolean
     */
    public static boolean verify(String text, String sign, String key) {
        text = text + "&key=" + key;
        String mySign = DigestUtils.md5Hex(getContentBytes(text, "UTF-8"));
        if (mySign.equals(sign)) {
            return true;
        } else {
            return false;
        }
    }


    private static byte[] getContentBytes(String content, String charset) {
        if ((charset == null) || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            //编码转换异常
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }


    //测试
    public static void main(String[] args) {
        //MD5加签验签测试
        String key = "liuzhongguochn@gmail.com";
        String text = "测试";
        String sign = sign(text, key);

        System.out.println("密钥：" + key);
        System.out.println("原文：" + text);
        System.out.println("加签：" + sign);
        System.out.println("验签：" + verify(text, sign, key));

        System.out.println("------------------------");

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountId", "admin");
        paramMap.put("name", "刘德华");
        paramMap.put("device", "android");
        paramMap.put("comment", "是个帅哥");

        String jsonKey = "GodIsAGirl";
        String jsonStr = LinkStrUtil.createLinkString(paramMap, true);
        String jsonSign = sign(jsonStr, jsonKey);

        System.out.println("密钥：" + jsonKey);
        System.out.println("原文：" + jsonStr);
        System.out.println("加签：" + jsonSign);
        System.out.println("验签：" + verify(jsonStr, jsonSign, jsonKey));
    }

}