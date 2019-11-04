package com.tuling.feignservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.tuling")
@EnableEurekaClient
@MapperScan("com.tuling.dao")
public class FeignserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignserviceApplication.class, args);
    }

}
