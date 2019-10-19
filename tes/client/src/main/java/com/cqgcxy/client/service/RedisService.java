package com.cqgcxy.client.service;


import com.cqgcxy.client.bean.EvaluateTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "RADIS-SERVER")
@Service
public interface RedisService {
    @RequestMapping("hello")
    EvaluateTable sayHello();

    @RequestMapping("tea_item")
    EvaluateTable getTeaItem();
}
