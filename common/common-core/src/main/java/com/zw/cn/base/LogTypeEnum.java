package com.zw.cn.base;

import lombok.Getter;

/**
 * @Author ZhaoWei
 * @Date 2021/5/8
 * @Time 2021-05-08 16:39:44
 */
@Getter
public enum LogTypeEnum {

    REQUEST_PARAM, // 打印请求入参,url

    RESPONSE, // 打印响应结果

    FULL // 全部
}