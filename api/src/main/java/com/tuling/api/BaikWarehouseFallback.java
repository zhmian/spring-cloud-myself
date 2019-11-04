package com.tuling.api;

import com.tuling.entity.BaikWarehouse;
import org.springframework.stereotype.Component;

@Component
public class BaikWarehouseFallback implements BaikWarehouseClient {
    @Override
    public BaikWarehouse getBaikWarehouseById(Integer id) {
        BaikWarehouse baikWarehouse = new BaikWarehouse();
        baikWarehouse.setId(-1);
        baikWarehouse.setAddr("server端降级了");
        return baikWarehouse;
    }

    @Override
    public BaikWarehouse getCorrect(Integer id) {
        return null;
    }
}
