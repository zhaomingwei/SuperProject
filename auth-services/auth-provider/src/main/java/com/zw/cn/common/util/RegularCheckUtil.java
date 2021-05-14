package com.zw.cn.common.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @author 赵威
 * @date 2021/4/29 19:30
 * @desc 校验规则
 */
@Component
public class RegularCheckUtil {

    /** 身份证校验正则表达式 **/
    private static final String idCardNoPattern = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";

    /** 手机号校验正则表达式 **/
    private static final String phonePattern = "^((13[0-9])|(14[5-9])|(15([0-3]|[5-9]))|(16[6-7])|(17[1-8])|(18[0-9])|(19[1|3])|(19[5|6])|(19[8|9]))\\d{8}$";

    /**
     * 验证字符串长度
     * @param min 最小长度
     * @param max 最大长度
     * @param msg 要验证的字符串
     * @return 字符串长度是否在指定范围 true 是 false 否
     */
    public static boolean validLength(int min, int max, String msg){
        String pattern = "^.{" + min + "," + max + "}$";
        return Pattern.matches(pattern, msg);
    }

    /**
     * 验证手机号
     * @param phone 需要验证的手机号
     * @return true 正确 false 不正确
     */
    public static boolean validPhone(String phone){
        return Pattern.matches(phonePattern, phone);
    }

    /**
     * 验证身份证号
     * @param idCardNo 需要验证的身份证号
     * @return true 正确 false 不正确
     */
    public static boolean validIdCardNo(String idCardNo){
        return Pattern.matches(idCardNoPattern, idCardNo);
    }

}
