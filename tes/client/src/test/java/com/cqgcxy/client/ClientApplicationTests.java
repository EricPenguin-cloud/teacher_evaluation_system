package com.cqgcxy.client;

import com.cqgcxy.client.service.SqlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {
    @Autowired
    private SqlService sqlService;

    @Test
    public void contextLoads() {

        //System.out.println(studentService.StudentLogin("169000818","123456").toString());
        System.out.println(sqlService.AdminLogin("123","123456"));
    }

}
