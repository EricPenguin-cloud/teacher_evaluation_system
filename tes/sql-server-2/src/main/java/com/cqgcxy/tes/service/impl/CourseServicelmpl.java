package com.cqgcxy.tes.service.impl;

import com.cqgcxy.tes.mapper.CourseMapper;
import com.cqgcxy.tes.pojo.Course;
import com.cqgcxy.tes.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServicelmpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public int insertCourse(String name) {
        return courseMapper.insertCourse(name);
    }

    @Override
    public List<Course> selectCourseList() {
        return courseMapper.selectCourseList();
    }
}
