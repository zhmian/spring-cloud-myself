package com.tuling.feignclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigController {

//    @Value("${spring.profiles}")
    private String profile;

    @Value("${spring.application.name}")
    private String name;

    @Value("${variable}")
    private String variable;

    @RequestMapping("/getConfig")
    public Map<String,String> getConfig(){
        Map<String,String> map = new HashMap<>();
        map.put("profile",profile);
        map.put("name",name);
        if ("N".equals(variable)) {
            map.put("variable",variable+"之前的业务逻辑");
        }else {
            map.put("variable",variable +"新的业务逻辑");
        }
        return map;
    }
}
