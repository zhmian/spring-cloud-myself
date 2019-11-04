package com.tuling.ribbonclient1;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tuling.entity.BaikWarehouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class BaikWarehouseController {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="50"),
    })
    @RequestMapping("/getBaikWarehouseById")
    public BaikWarehouse getBaikWarehouseById(@RequestParam Integer id){
        System.out.println(11111);
        return restTemplate.getForObject("http://feign-service:8102/warehouse/getBaikWarehouseById?id="+id,BaikWarehouse.class);
    }

    @RequestMapping("/getCorrect")
    public BaikWarehouse getCorrect(@RequestParam Integer id){
        System.out.println(2222);
        return restTemplate.getForObject("http://feign-service:8102/warehouse/getCorrect?id="+id,BaikWarehouse.class);
    }

    public BaikWarehouse defaultFallBack(Integer id){
        BaikWarehouse baikWarehouse = new BaikWarehouse();
        baikWarehouse.setId(-1);
        baikWarehouse.setAddr("ribbon client降级方法");
        return baikWarehouse;
    }
}
