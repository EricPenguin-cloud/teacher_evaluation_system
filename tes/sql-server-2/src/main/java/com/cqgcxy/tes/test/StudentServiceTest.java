package com.cqgcxy.tes.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cqgcxy.tes.cnd.*;
import com.cqgcxy.tes.mapper.AdminMapper;
import com.cqgcxy.tes.mapper.StudentMapper;
import com.cqgcxy.tes.mapper.TeacherMapper;
import com.cqgcxy.tes.pojo.Course;
import com.cqgcxy.tes.pojo.Grade;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.pojo.Teacher;
import com.cqgcxy.tes.service.*;
import com.cqgcxy.tes.service.impl.StudentServiceImpl;
import org.apache.poi.hssf.record.formula.functions.T;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentServiceTest {
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	StudentService studentService;
	@Autowired
    StudentServiceImpl service;
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	TeacherService teacherService;
	@Autowired
	AdminService adminService;
	@Autowired
	GradeService gradeService;
	@Autowired
	CourseService courseService;
	@Autowired
	StudentMapper studentMapper;
	@Test
	public void test(){

		/*int i= gradeService.insertGrade("16900010");

		List<Grade> gradeList = gradeService.selectGradeList();

		int j = courseService.insertCourse("面向对象");

		List<Course> courseList = courseService.selectCourseList();

		System.out.println(i);

		for (int m=0;m<gradeList.size();m++){
			System.out.println(gradeList.get(m).getId()+gradeList.get(m).getName());
		}
		System.out.println(j);
		for (int n=0;n<courseList.size();n++){
			System.out.println(gradeList.get(n).getId()+courseList.get(n).getName());
		}*/

		/*Relationship_tcgcnd rt = new Relationship_tcgcnd();
		rt.setCid(9);
		rt.setGid(9);
		rt.setTid(9);
		int r = adminService.insertRelationship(rt);
		System.out.println(r);*/

//		List<Result_scnd> list = studentMapper.selectStudentStaete(1);
//
//		for (int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getTid());
//		}
		System.out.println(studentMapper.get("169000702","123456"));

	}
}
