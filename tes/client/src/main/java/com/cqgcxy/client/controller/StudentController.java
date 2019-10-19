package com.cqgcxy.client.controller;

import com.cqgcxy.client.bean.*;
import com.cqgcxy.client.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class StudentController {
    @Autowired
    private SqlService sqlService;

    //学生登录
    @RequestMapping(value = "StudentLogin",method = RequestMethod.POST)
    public Response StudentLogin(String username, String password) {
        return sqlService.StudentLogin(username,password);
    }

    //学生所有信息查询
    @RequestMapping("StudentList")
    public List<Student> studentlist(){
        return sqlService.studentlist();
    }

    //删除学生信息
    @RequestMapping("Studentdel")
    public boolean studentdel(int sid){
       return  sqlService.studentdel(sid);
    }

    //更新学生信息
    @RequestMapping("Studentupdate")
    public boolean studentupdate(Studentcnd studentcnd){
        return  sqlService.studentupdate(studentcnd);
    }

    //学生需评价教师
    @RequestMapping("ShowStudentEvaluateData")
    public Response showstudentdata(int gid){
        return sqlService.showstudentdata(gid);
    }

    //学生修改密码
    @RequestMapping("updatePasswordStudent")
    public boolean updatePasswordStudent(String number,String password){
        return  sqlService.updatePasswordStudent(number,password);
    }

    //学生提交评价结果
    @PostMapping("CommitStudentEvaluation")
    public String commitstudentevaluation(@RequestParam("result_scnd") String result_scnd, @RequestBody List<Record_scnd> list){
        return sqlService.commitstudentevaluation(result_scnd,list);
    }
    //学生查看自己评价结果
    @RequestMapping("showevaluateresult")
    public List<Record_scnd> showevaluateresult(int sid){
        return sqlService.showStuevaluateresult(sid);
    }
    @RequestMapping("selectStudentStaete")
    public List<Result_scnd> selectStudentStaete(int sid){
        return sqlService.selectStudentStaete(sid);
    }
    //学生根据id与老师id查看评价结果
    @RequestMapping("showResult")
    public List<Record_scnd> showResult(int sid,int tid){
        return sqlService.showResult(sid,tid);
    }

    //查询每个分数段对应的老师人数(学生)
    @RequestMapping("selectCountS")
    public List selectCountS(){
        return sqlService.selectCountS();
    }
    //查询每个指标评选的人数(学生)
    @RequestMapping("selectAnswerS")
    public List selectAnswerS(){
        return sqlService.selectAnswerS();
    }
}
