package com.zw.cn.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 赵威
 * @date 2021/4/28 9:37
 * @desc 配置文件映射类
 */
@Data
@Component
public class ConfigProperties {

    /**------------------上上签------------------**/
    /**开发者ID**/
    @Value("${bestSign.developerId}")
    private String bestSignDeveloperId;

    /**私匙**/
    @Value("${bestSign.privateKey}")
    private String bestSignPrivateKey;

    /**认证地址**/
    @Value("${bestSign.serverHost}")
    private String bestSignServerHost;

    /**个人认证方法路径**/
    @Value("${bestSign.personalMethod}")
    private String bestSignPersonalMethod;

    /**企业认证方法路径**/
    @Value("${bestSign.enterpriseMethod}")
    private String bestSignEnterpriseMethod;

    /**认证参数拼接模板**/
    @Value("${bestSign.urlSignParams}")
    private String bestSignUrlSignParams;

}
