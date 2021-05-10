package com.zw.cn.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCheckUtils {

    /**
     * 身份证校验正则表达式
     **/
    private static final String idCardNoPattern = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";

    /**
     * 手机号校验正则表达式
     **/
    private static final String phonePattern = "^((13[0-9])|(14[5-9])|(15([0-3]|[5-9]))|(16[6-7])|(17[1-8])|(18[0-9])|(19[1|3])|(19[5|6])|(19[8|9]))\\d{8}$";

    /**
     * 国内手机号验证
     *
     * @param mobile
     * @return 验证通过返回true
     */
    public static boolean isMobile(String mobile) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile(phonePattern); // 验证手机号
        m = p.matcher(mobile);
        b = m.matches();
        return b;
    }

    /**
     * 电话号码验证
     *
     * @param telphone
     * @return 验证通过返回true
     */
    public static boolean isPhone(String telphone) {
        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean b = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
        if (telphone.length() > 9) {
            m = p1.matcher(telphone);
            b = m.matches();
        } else {
            m = p2.matcher(telphone);
            b = m.matches();
        }
        return b;
    }

    /**
     * 邮箱验证
     *
     * @param email
     * @return 验证通过返回true
     */
    public static boolean isEmail(String email) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[a-zA-Z0-9_%.-]+@[a-zA-Z0-9-_]+.([a-zA-Z0-9-_]{2,5})$");
        m = p.matcher(email);
        b = m.matches();
        return b;
    }

}
