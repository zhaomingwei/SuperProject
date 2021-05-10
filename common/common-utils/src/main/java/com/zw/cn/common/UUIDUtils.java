package com.zw.cn.common;

import java.util.UUID;

public class UUIDUtils {

    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").toUpperCase();
    }
}
