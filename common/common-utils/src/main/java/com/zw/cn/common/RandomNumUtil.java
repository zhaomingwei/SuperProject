package com.zw.cn.common;

import java.util.Random;

public class RandomNumUtil {

    public static final int defaultLength = 6;

    private static Random random = new Random();
    public final static int BINARY = 2;
    public final static int OCTAL = 8;
    public final static int DECIMAL = 10;
    public final static int HEX = 16;

    public static String randomNum(int length, int scale) {
        String no = "";
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(scale);
        }
        switch (scale) {
            case BINARY:
                for (int i : arr) {
                    no = no + Integer.toBinaryString(i);
                }
                break;
            case OCTAL:
                for (int i : arr) {
                    no = no + Integer.toOctalString(i);
                }
                break;
            case DECIMAL:
                for (int i : arr) {
                    no = no + Integer.toString(i);
                }
                break;
            case HEX:
                for (int i : arr) {
                    no = no + Integer.toHexString(i);
                }
                break;
            default:
                throw new IllegalArgumentException("进制不合法");
        }
        return no;
    }

    /**
     * 默认6位随机数字码
     *
     * @return
     * @author ZhaoWei
     * @date 2016年10月27日 下午8:26:42
     */
    public static String randomNum() {
        return randomNum(defaultLength);
    }

    public static String randomNum(int length) {
        return randomNum(length, DECIMAL);
    }

}
