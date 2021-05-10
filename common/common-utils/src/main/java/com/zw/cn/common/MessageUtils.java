package com.zw.cn.common;

import java.text.MessageFormat;

public class MessageUtils {

    public static String messageFormat(String pattern, Object... param) {

        if (param.length == 0)
            return pattern;
        return MessageFormat.format(pattern, param);
    }

}
