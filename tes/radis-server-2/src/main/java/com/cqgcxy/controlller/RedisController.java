package com.cqgcxy.controlller;

import com.alibaba.fastjson.JSON;
import com.cqgcxy.bean.EvaluateTable;
import com.cqgcxy.configuration.JedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
public class RedisController {

    @Autowired
    JedisConfig jedisConfig;


    @RequestMapping("hello")
    public EvaluateTable sayHello(){
        Jedis jedis = jedisConfig.getJedis();
        List<String> list = jedis.lrange("evaluate_item", 0 ,2);
        EvaluateTable evaluateTable = JSON.parseObject(list.get(1),EvaluateTable.class);
        //System.out.printf(list.toString());
        return evaluateTable;
    }
    @RequestMapping("tea_item")
    public EvaluateTable getTeaItem(){
        Jedis jedis = jedisConfig.getJedis();
        List<String> list = jedis.lrange("evaluate_item", 0 ,2);
        EvaluateTable evaluateTable = JSON.parseObject(list.get(0),EvaluateTable.class);
        //System.out.printf(list.toString());
        return evaluateTable;
    }
}
