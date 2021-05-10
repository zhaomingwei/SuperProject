package com.zw.cn.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     * 使用md5的算法进行加密
     *
     * @param plainText
     * @param returnUpperCase 是返回否大写
     * @return
     */
    public static String md5(String plainText, boolean returnUpperCase) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return returnUpperCase ? md5code.toUpperCase() : md5code;
    }

    /**
     * 使用md5的算法进行加密,
     * 返回大写
     */
    public static String md5(String plainText) {
        return md5(plainText, true);
    }

    public static void main(String[] args) {
        System.out.println(md5("商务标签syappkey"));
        System.out.println(md5("商务标签symaster_secret"));
    }

}
