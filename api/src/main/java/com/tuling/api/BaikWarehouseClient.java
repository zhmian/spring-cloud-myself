package com.tuling.api;


import com.tuling.entity.BaikWarehouse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "feign-service",configuration = MainFeignConfig.class, fallback = BaikWarehouseFallback.class,path = "/warehouse")
//@FeignClient(name = "feignservice",configuration = PartFeignConfig.class, fallback = BaikWarehouseFallback.class,path = "/warehouse")//局部降级
public interface BaikWarehouseClient {

    @RequestMapping("/getBaikWarehouseById")
    public BaikWarehouse getBaikWarehouseById(@RequestParam Integer id);

    @RequestMapping("/getCorrect")
    BaikWarehouse getCorrect(@RequestParam Integer id);
}
