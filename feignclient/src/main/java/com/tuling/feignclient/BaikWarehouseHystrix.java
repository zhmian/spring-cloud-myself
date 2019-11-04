package com.tuling.feignclient;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.tuling.entity.BaikWarehouse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaikWarehouseHystrix extends HystrixCommand {

    protected BaikWarehouseHystrix(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }

    @Override
    protected BaikWarehouse getFallback() {
        log.info("降级方法。。。。。。。。。。。。。。。。");
        BaikWarehouse baikWarehouse = new BaikWarehouse();
        baikWarehouse.setId(-1);
        baikWarehouse.setAddr("降级了");
        return baikWarehouse;
    }
}
