package com.cqgcxy.tes.mapper;

import com.cqgcxy.tes.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    int insertCourse(String name);

    List<Course> selectCourseList();
}
