package com.tuling.feignservice;


import com.tuling.dao.BaikWarehouseMapper;
import com.tuling.entity.BaikWarehouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/warehouse")
@Slf4j
public class BaikWarehouseController {


    @Autowired
    private RestTemplate restTemplate;

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
        return new BaikWarehouse();
//        return baikWarehouseMapper.getBaikWarehouseById(id);
    }

}
