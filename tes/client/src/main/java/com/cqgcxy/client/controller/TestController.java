package com.cqgcxy.client.controller;

import com.cqgcxy.client.bean.EvaluateTable;
import com.cqgcxy.client.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("hello")
    public EvaluateTable sayHello(){
        return redisService.sayHello();
    }
    @RequestMapping("tea_item")
    public EvaluateTable getTeaItem(){
        return redisService.getTeaItem();
    }
}
