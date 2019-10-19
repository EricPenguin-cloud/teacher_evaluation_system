package com.cqgcxy.client.controller;

import com.cqgcxy.client.bean.Response;
import com.cqgcxy.client.bean.Student;
import com.cqgcxy.client.bean.Studentcnd;
import com.cqgcxy.client.bean.Teacher;
import com.cqgcxy.client.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    SqlService sqlService;


    //管理员登录
    @RequestMapping("AdminLogin")
    @ResponseBody
    public Response StudentLogin(String username, String password) {
        return sqlService.AdminLogin(username,password);
    }

    //管理员重置学生密码
    @RequestMapping("passwords_s")
    @ResponseBody
    public boolean passwords_s(int sid){
        return sqlService.passwords_s(sid);
    }
    //管理员重置教师密码
    @RequestMapping("passwords_t")
    @ResponseBody
    public boolean passwords_t(int tid){
        return sqlService.passwords_t(tid);
    }
    //管理员更改学生信息
    @RequestMapping("studentupdateadmin")
    @ResponseBody
    public boolean studentupdateadmin(Studentcnd studentcnd){
        return sqlService.studentupdateadmin(studentcnd);
    }

    @RequestMapping(value = "test")
    @ResponseBody
    public String test(@RequestParam("param") String param, @RequestBody Student data){
        return sqlService.test(param,data);
    }

    //exec导入学生信息
    @RequestMapping("ImportFileStudent")
    @ResponseBody
    public boolean importfileStu(@RequestBody List<Studentcnd> studentcnds){
        return sqlService.importfileStu(studentcnds);
    }

    //exec导入教师信息
    @RequestMapping("ImportFileTeacher")
    @ResponseBody
    public boolean importfile(@RequestBody  List<Teacher> teachers)  {
        return sqlService.importfile(teachers);
    }

    //给教师分配课程及上课的班级,传入的是id不是名称
    @RequestMapping("StudentTeacherRelationship")
    @ResponseBody
    public String insertStudentTeacherRelationship(int tid,int gid,int cid){
        return sqlService.insertStudentTeacherRelationship(tid,gid,cid);
    }
    //给教师分配课程及上课的班级,传入的是id不是名称
    @RequestMapping("get_tcg_id")
    @ResponseBody
    public List<Integer> get_tcg_id(){
        return sqlService.get_tcg_id();
    }

}
