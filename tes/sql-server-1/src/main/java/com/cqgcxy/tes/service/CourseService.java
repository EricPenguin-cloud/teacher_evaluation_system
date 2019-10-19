package com.cqgcxy.tes.service;

import com.cqgcxy.tes.pojo.Course;

import java.util.List;

public interface CourseService {

    int insertCourse(String name);

    List<Course> selectCourseList();
}
