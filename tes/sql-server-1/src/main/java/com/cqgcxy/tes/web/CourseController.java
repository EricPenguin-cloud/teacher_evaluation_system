package com.cqgcxy.tes.web;

import com.cqgcxy.tes.pojo.Course;
import com.cqgcxy.tes.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
    //添加课程
    @RequestMapping("addCourse")
    public String addCourse(String name){

        int result = courseService.insertCourse(name);
        if (result>0){
            return "添加成功";
        }
        return "添加失败";

    }
    //查询所有课程
    @RequestMapping("courseList")
    public List<Course> courseList(){

        List<Course> courseList = courseService.selectCourseList();

        return courseList;
    }
}
