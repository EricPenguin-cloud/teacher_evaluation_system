package com.cqgcxy.client.controller;

import com.cqgcxy.client.bean.Grade;
import com.cqgcxy.client.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class GradeController {
    @Autowired
    private SqlService sqlService;

    //添加班级
    @RequestMapping("addGrade")
    public String insertGrade(String name){
        return sqlService.insertGrade(name);
    }
    //查询所有班级
    @RequestMapping("gradeList")
    public List<Grade> gradeList(){
        return sqlService.gradeList();
    }
}

