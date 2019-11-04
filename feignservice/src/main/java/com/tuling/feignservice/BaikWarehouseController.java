package com.tuling.feignservice;


import com.tuling.dao.BaikWarehouseMapper;
import com.tuling.entity.BaikWarehouse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/warehouse")
public class BaikWarehouseController {


    @Resource
    private BaikWarehouseMapper baikWarehouseMapper;

    @RequestMapping("/getBaikWarehouseById")
    public BaikWarehouse getBaikWarehouseById(@RequestParam Integer id){
        System.out.println(111111111);
        if (true){
            throw new RuntimeException("1111111111");
        }
        return baikWarehouseMapper.getBaikWarehouseById(id);
    }

    @RequestMapping("/getCorrect")
    public BaikWarehouse getCorrect(@RequestParam Integer id){
        return baikWarehouseMapper.getBaikWarehouseById(id);
    }

}
