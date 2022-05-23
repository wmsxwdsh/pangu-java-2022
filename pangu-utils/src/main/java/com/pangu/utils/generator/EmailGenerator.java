package com.pangu.utils.generator;

/**
 * 电子邮箱生成器
 *
 * @author LZG
 * @date 2018/11/5
 */
public class EmailGenerator {

    private static String base = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");

    /**
     * 生成email
     *
     * @return java.lang.String
     */
    public static String generate() {
        //生成4到12之间任意一个数字个的字符
        int length = getNum(4, 12);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * base.length());
            sb.append(base.charAt(number));
        }

        sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
        return sb.toString();
    }

    /**
     * 生成任一数字(最小start ， 最大end ）
     *
     * @return int
     */
    private static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

}