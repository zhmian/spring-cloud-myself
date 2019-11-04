package com.tuling.feignclient;

import com.tuling.api.BaikWarehouseClient;
import com.tuling.entity.BaikWarehouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class BaikWarehouseController {

    @Resource
    private BaikWarehouseClient baikWarehouseClient;

    @RequestMapping("/getBaikWarehouseById")
    public BaikWarehouse getBaikWarehouseById(@RequestParam Integer id) throws InterruptedException {
        System.out.println(11111);
        return baikWarehouseClient.getBaikWarehouseById(id);
    }

    @RequestMapping("/getCorrect")
    public BaikWarehouse getCorrect(@RequestParam Integer id) throws InterruptedException {
        Thread.sleep(100);
        return baikWarehouseClient.getCorrect(id);
    }

    @RequestMapping("/getCookie")
    public Cookie[] getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
        return cookies;
    }
}
