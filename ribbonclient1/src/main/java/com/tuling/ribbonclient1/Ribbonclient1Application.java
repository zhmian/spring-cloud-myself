package com.tuling.ribbonclient1;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.tuling")
@EnableEurekaClient
//@EnableFeignClients(basePackages = "com.tuling")
@EnableCircuitBreaker //ribbon 开启熔断
public class Ribbonclient1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ribbonclient1Application.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * ribbon dashboard监控，只能监控加上@HystrixCommand注解的
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);  //系统启动时加载顺序
        registrationBean.addUrlMappings("/actuator/hystrix.stream");//路径
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
