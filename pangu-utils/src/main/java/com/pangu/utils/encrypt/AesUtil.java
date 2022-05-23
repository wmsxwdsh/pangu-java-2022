package com.pangu.utils.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * AES加密工具类
 *
 * @author LZG
 * @date 2019/3/22
 */
public class AesUtil {

    // 编码
    private static final String ENCODING = "UTF-8";
    // 算法定义
    private final static String AES = "AES";
    // 指定填充方式
    private static final String CIPHER_CBC_PADDING = "AES/CBC/PKCS5Padding";
    // 偏移量(CBC中使用，增强加密算法强度)
    private static final String IV_SEED = "1234567812345678";
    private final static int HEX2BYTE_2 = 2;
    private final static int HEX2BYTE_16 = 16;
    private static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encrypt(String content, String encryptMmpd)
            throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException, NoSuchPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException {
        SecretKeySpec key = getKeySpecFromBytes(encryptMmpd.toUpperCase());
        Cipher cipher = Cipher.getInstance(CIPHER_CBC_PADDING);
        IvParameterSpec iv = new IvParameterSpec(IV_SEED.getBytes(ENCODING));
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] result = cipher.doFinal(content.getBytes("UTF-8"));
        return toHexString(result);
    }

    public static String decrypt(String content, String encryptMmpd)
            throws NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException,
            NoSuchPaddingException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        SecretKeySpec key = getKeySpecFromBytes(encryptMmpd.toUpperCase());
        // 偏移
        IvParameterSpec iv = new IvParameterSpec(IV_SEED.getBytes(ENCODING));
        Cipher cipher = Cipher.getInstance(CIPHER_CBC_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] result = cipher.doFinal(hex2byte(content.getBytes("UTF-8")));
        return new String(result);
    }

    private static SecretKeySpec getKeySpecFromBytes(String strBytes) {
        SecretKeySpec spec = new SecretKeySpec(hex2byte(strBytes.getBytes()), AES);
        return spec;
    }

    private static byte[] hex2byte(byte[] b) {
        if (b.length % HEX2BYTE_2 != 0) {
            throw new IllegalArgumentException("长度不是偶数!");
        }
        byte[] b2 = new byte[b.length / HEX2BYTE_2];
        for (int n = 0; n < b.length; n += HEX2BYTE_2) {
            String item = new String(b, n, HEX2BYTE_2);
            b2[(n / HEX2BYTE_2)] = (byte) Integer.parseInt(item, HEX2BYTE_16);
        }
        return b2;
    }

    private static String toHexString(byte[] byteArray) {
        StringBuffer sb = new StringBuffer(byteArray.length * 2);
        for (int i = 0; i < byteArray.length; i++) {
            sb.append(hexChar[((byteArray[i] & 0xF0) >>> 4)]);
            sb.append(hexChar[(byteArray[i] & 0xF)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String content = "2019";
        String salt = "46EBA22EF5204DD5B110A1F730513965";

        System.out.println("原文:" + content);

        String s1 = AesUtil.encrypt(content, salt);
        System.out.println("AES加密后:" + s1);

        System.out.println("AES解密后:" + AesUtil.decrypt(s1, salt));
    }

}