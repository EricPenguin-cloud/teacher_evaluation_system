package com.cqgcxy.client.controller;

import com.cqgcxy.client.bean.Course;
import com.cqgcxy.client.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class CourseController {

    @Autowired
    SqlService sqlService;
    //添加课程
    @RequestMapping("addCourse")
    public String addCourse(String name){
        return sqlService.addCourse(name);
    }
    //查询所有课程
    @RequestMapping("courseList")
    public List<Course> courseList(){
        return sqlService.courseList();
    }
}
