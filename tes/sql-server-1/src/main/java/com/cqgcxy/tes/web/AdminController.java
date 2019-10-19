package com.cqgcxy.tes.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cqgcxy.tes.Response.Response;
import com.cqgcxy.tes.cnd.Relationship_tcgcnd;
import com.cqgcxy.tes.cnd.Studentcnd;
import com.cqgcxy.tes.mapper.AdminMapper;
import com.cqgcxy.tes.pojo.*;
import com.cqgcxy.tes.service.AdminService;
import com.cqgcxy.tes.service.StudentService;
import com.cqgcxy.tes.service.TeacherService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminMapper adminMapper;

    //管理员登录
    @RequestMapping("AdminLogin")
    @ResponseBody
    public Response StudentLogin(String username, String password) {
        Administrator admin = adminService.get(username,password);
        if(null==admin){
            return new Response(0,null);
        }
        return new Response(1,admin);
    }
    //管理员修改自己密码
    public boolean adminPasswordUpdate(String username,String password){

        boolean result = adminService.adminPasswordUpdate(username,password);

        return result;
    }
    //管理员重置学生密码
    @RequestMapping("passwords_s")
    @ResponseBody
    public boolean passwords_s(int sid){
        boolean result = studentService.studentpw_reset(sid);
        return result;
    }
    //管理员重置教师密码
    @RequestMapping("passwords_t")
    @ResponseBody
    public boolean passwords_t(int tid){
        boolean result = teacherService.teacherpw_reset(tid);
        return result;
    }
    //管理员更改学生信息
    @RequestMapping("studentupdateadmin")
    @ResponseBody
    public boolean studentupdateadmin(Studentcnd studentcnd){
        boolean result = studentService.studentupdateadmin(studentcnd);
        return result;
    }

    @RequestMapping(value = "test")
    @ResponseBody
    public String test(@RequestParam("param") String param,@RequestBody Student data){
        JSONObject obj = JSON.parseObject(param);
        System.out.printf(obj.getString("name"));
        //System.out.printf(data.getName());
        return obj.getString("name");
    }

    //exec导入学生信息
    @RequestMapping("ImportFileStudent")
    @ResponseBody
    public boolean importfileStu(@RequestBody List<Studentcnd> studentcnds) throws IOException {
        for(Studentcnd studentcnd:studentcnds){
            int result = studentService.insertstudentcnd(studentcnd);
            if(result!=1){
                return false;
            }
        }
        return true;
    }

    //exec导入教师信息
    @RequestMapping("ImportFileTeacher")
    @ResponseBody
    public boolean importfile(@RequestBody  List<Teacher> teachers)  {
        System.out.printf(teachers.toString());
        for(Teacher teacher : teachers){
            int result = adminService.insertTeacher(teacher);
            if(result!=1){
                return false;
            }
        }
        return true;
    }

    //给教师分配课程及上课的班级,传入的是id不是名称
    @RequestMapping("StudentTeacherRelationship")
    @ResponseBody
    public String insertStudentTeacherRelationship(int tid,int gid,int cid){
        Relationship_tcgcnd relationship_tcgcnd = new Relationship_tcgcnd();

        relationship_tcgcnd.setTid(tid);
        relationship_tcgcnd.setCid(cid);
        relationship_tcgcnd.setGid(gid);

        int result =adminService.insertRelationship(relationship_tcgcnd);
        if(result >= 0)
            return "success";
        else
            return "fail";
    }
    //给教师分配课程及上课的班级,传入的是id不是名称
    @RequestMapping("get_tcg_id")
    @ResponseBody
    public List<Integer> get_tcg_id(){
        return adminMapper.get_tcg_id();
    }

}
