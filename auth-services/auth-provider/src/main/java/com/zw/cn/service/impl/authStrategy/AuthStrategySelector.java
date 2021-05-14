package com.zw.cn.service.impl.authStrategy;

import com.zw.cn.service.impl.authStrategy.strategyInterface.AuthStrategy;
import com.zw.cn.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 赵威
 * @date 2021/4/27 19:20
 * @desc 认证策略类上下文
 */
@Slf4j
@Component
public class AuthStrategySelector implements ApplicationContextAware {

    private static Map<String, AuthStrategy> strategyMap = new ConcurrentHashMap<>();

    private AuthStrategySelector() {}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("AuthStrategySelector初始化开始");
        Map<String, AuthStrategy> map = applicationContext.getBeansOfType(AuthStrategy.class);
        for (AuthStrategy value : map.values()) {
            strategyMap.put(value.getType(), value);
        }
        log.info("AuthStrategySelector初始化完成,strategyMap:" + JsonUtil.toString(strategyMap));
    }

    public AuthStrategy getAuthStrategy(String code){
        return strategyMap.get(code);
    }
}
