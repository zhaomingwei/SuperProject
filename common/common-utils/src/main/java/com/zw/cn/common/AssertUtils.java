package com.zw.cn.common;

import com.zw.cn.exception.BaseException;

/**
 * @author Marvis
 * @version 2015-6-28下午9:57:42
 */
public class AssertUtils extends BaseAssertUtils {

    /**
     * check Validate Domestic Mobile
     *
     * @param emptyCode   110:请输入手机号
     * @param vCode       112:手机号码格式错误
     * @param loginMobile
     * @throws BaseException
     * @author Marvis
     * @version 2015-6-28下午10:29:47
     */
    public static void validateMobile(int emptyCode, int vCode, String loginMobile) {

        if (StringUtils.isBlank(loginMobile))
            ExceptionUtils.throwSimpleEx(emptyCode);
        if (!StringCheckUtils.isMobile(loginMobile))
            ExceptionUtils.throwSimpleEx(vCode);
    }

    /**
     * check email
     *
     * @author Marvis
     * @version 2015-6-28下午10:29:47
     */
    public static void isEmail(int emptyCode, int code, String email) {

        if (StringUtils.isBlank(email))
            ExceptionUtils.throwSimpleEx(emptyCode);
        if (!StringCheckUtils.isEmail(email))
            ExceptionUtils.throwSimpleEx(code);
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     * @throws BaseException
     * @author Marvis
     * @version 2015-6-28下午10:23:46
     */
    public static void isNum(int code, String str) {
        if (StringUtils.isBlank(str))
            ExceptionUtils.throwSimpleEx(code);
        if (!str.matches("^[0-9]*$"))
            ExceptionUtils.throwSimpleEx(code);
    }
}
