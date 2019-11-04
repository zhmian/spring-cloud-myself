package com.tuling.api;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 配置类
 */
public class MainFeignConfig {

    /**
     * 打印日志
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; //日志级别
    }

}
