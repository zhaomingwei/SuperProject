package com.zw.cn.aspect;

import com.zw.cn.base.LogTypeEnum;

import java.lang.annotation.*;

/**
 * controller层日志打印注解
 *
 * @Author ZhaoWei
 * @Date 2021/5/8
 * @Time 2021-05-08 16:39:12
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MethodLogger {

    /**
     * 日志打印类型， 默认请求日志全部打印
     * 
     * @return
     */
    LogTypeEnum logType() default LogTypeEnum.FULL;

    /**
     * 方法描述
     * @return :
     */
    String value() default "";

}
