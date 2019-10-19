package com.cqgcxy;

import com.alibaba.fastjson.JSON;
import com.cqgcxy.bean.EvaluateCell;
import com.cqgcxy.bean.EvaluateTable;
import com.cqgcxy.configuration.JedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CqgcxyApplicationTests {

    @Autowired
    JedisConfig jedisConfig;

    @Test
    public void contextLoads() {
        //Jedis jedis = jedisConfig.getJedis();
        //System.out.printf(jedis.get("d"));

        String s_item = "{\n" +
                "\tid:1,\n" +
                "\tname:\"教师评价调查问卷\",\n" +
                "\tevaluate_item:[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\tid:1,\n" +
                "\t\t\t\t\tcontent:\"该教师具有责任心\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:2,\n" +
                "\t\t\t\t\tcontent:\"该教师上课使用普通话\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:3,\n" +
                "\t\t\t\t\tcontent:\"该教师上课为学生提供讨论的机会\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:4,\n" +
                "\t\t\t\t\tcontent:\"该教师上课能使用现代信息技术教学\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:5,\n" +
                "\t\t\t\t\tcontent:\"该教师认真批改布置的作业\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:6,\n" +
                "\t\t\t\t\tcontent:\"该教师不具有不良现象，如吸烟、接打手机、迟到、早退、无故不上课等\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:7,\n" +
                "\t\t\t\t\tcontent:\"该教师言行举止得体\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:8,\n" +
                "\t\t\t\t\tcontent:\"该教师愿意课后为学生解答问题\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:9,\n" +
                "\t\t\t\t\tcontent:\"该教师教学具有特色，有一定吸引力\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:10,\n" +
                "\t\t\t\t\tcontent:\"该教师指导学生参加或组织一些实践活动\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\n" +
                "\t]\n" +
                "}\n";
        String t_item="{\n" +
                "\tid:2,\n" +
                "\tname:\"教师评价调查问卷\",\n" +
                "\tevaluate_item:[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\tid:1,\n" +
                "\t\t\t\t\tcontent:\"该教师不具有不良现象，如迟到、早退等\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:2,\n" +
                "\t\t\t\t\tcontent:\"该教师工作衣着得体、举止大方\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:3,\n" +
                "\t\t\t\t\tcontent:\"该教师同事关系处理得当，能与同事较好相处\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:4,\n" +
                "\t\t\t\t\tcontent:\"该教师工作时具有活力\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:5,\n" +
                "\t\t\t\t\tcontent:\"该教师能很好的跟学生沟通\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:6,\n" +
                "\t\t\t\t\tcontent:\"该教师教学具有特色，受学生欢迎\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:7,\n" +
                "\t\t\t\t\tcontent:\"该教师对学生尽职尽责，为学生着想\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:8,\n" +
                "\t\t\t\t\tcontent:\"该教师为人处事周到，行为作风优秀\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:9,\n" +
                "\t\t\t\t\tcontent:\"该教师具有上进心\",\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t\t\t{\n" +
                "\t\t\t\t\tid:10,\n" +
                "\t\t\t\t\tcontent:\"该教师工作之余能进行自我提高\",\n" +
                "\t\t\t\t}\n" +
                "\t\t\t\t\n" +
                "\t\t\t\t\n" +
                "]\n" +
                "}\n";
        //EvaluateTable evaluateTable =JSON.parseObject(t_item,EvaluateTable.class);
        //System.out.printf(evaluateTable.toString());
        Jedis jedis = jedisConfig.getJedis();
        //jedis.set("","");
        //jedis.lpush("evaluate_item",s_item);
        //jedis.lpush("evaluate_item",t_item);
        List<String> list = jedis.lrange("evaluate_item", 0 ,2);
        System.out.println(list);


    }

}
