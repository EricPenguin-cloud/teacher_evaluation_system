package com.cqgcxy.tes.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cqgcxy.tes.Response.Response;
import com.cqgcxy.tes.cnd.Record_scnd;
import com.cqgcxy.tes.cnd.Result_scnd;
import com.cqgcxy.tes.cnd.Studentcnd;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.pojo.Student;
import com.cqgcxy.tes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    //学生登录
    @RequestMapping("StudentLogin")
    public Response StudentLogin(String username, String password) {
        System.out.printf(username);
        Student student = studentService.get(username,password);
        if(null==student){
            return new Response(0,null);
        }
        return new Response(1,student);
    }
    //学生所有信息查询
    @RequestMapping("StudentList")
    public List<Student> studentlist(){
        List<Student> list = studentService.studentlist();
        return list;
    }
    //删除学生信息
    @RequestMapping("Studentdel")
    public boolean studentdel(int sid){
        boolean result = studentService.studentdel(sid);
        return result;
    }
    //更新学生信息
    @RequestMapping("Studentupdate")
    public boolean studentupdate(Studentcnd studentcnd){
        boolean result = studentService.studentupdate(studentcnd);
        return result;
    }

    //学生需评价教师
    @RequestMapping("ShowStudentEvaluateData")
    public Response showstudentdata(int gid){
        List<Relationship_tcg>  relationship_tcg = studentService.selectrelationship(gid);
        return new Response(1,relationship_tcg);
    }
    //学生修改密码
    @RequestMapping("updatePasswordStudent")
    public boolean updatePasswordStudent(String number,String password){
        boolean result = studentService.updatePasswordStudent(number,password);
        return result;
    }
    //学生提交评价结果
    @RequestMapping("CommitStudentEvaluation")
    public String commitstudentevaluation(@RequestParam("result_scnd") String result_scnd,@RequestBody List<Record_scnd> list){

        JSONObject obj = JSON.parseObject(result_scnd);

        int tid = obj.getIntValue("tid");
        int sid = obj.getIntValue("sid");
        String total = obj.getString("total");

        int primaryKey = studentService.insertstudentevaluation(sid,tid,total);
        System.out.println(primaryKey);

        int result = -1;
        for(Record_scnd record_scnd : list) {
            int result_s_id = primaryKey;
            String subject     = record_scnd.getSubject();
            String answer      = record_scnd.getAnswer();
            String score       = record_scnd.getScore();
            System.out.printf(subject+answer+score);
            result = studentService.insertdetailedevaluate(result_s_id,subject,answer,score);
            System.out.println(result);
        }
        if(result >= 0)
            return "success";
        else
            return "fail";
    }


    //学生查看自己评价结果
    @RequestMapping("showevaluateresult")
    public List<Record_scnd> showevaluateresult(int sid){
        List<Record_scnd> showresult = studentService.selectshowresult(sid);
        return  showresult;
    }

    @RequestMapping("selectStudentStaete")
    public List<Result_scnd> selectStudentStaete(int sid){
        List<Result_scnd> staet = studentService.selectStudentStaete(sid);

        return staet;
    }

    //学生根据id与老师id查看评价结果
    @RequestMapping("showResult")
    public List<Record_scnd> showResult(int sid,int tid){
        List<Record_scnd> showEvaluateResults = studentService.showresult(sid,tid);
        return  showEvaluateResults;
    }
    //查询每个分数段对应的老师人数(学生)
    @RequestMapping("selectCountS")
    public List selectCountS(){
        List data = studentService.selectCountS(0,0);
        return data;
    }
    //查询每个指标评选的人数(学生)
    @RequestMapping("selectAnswerS")
    public List selectAnswerS(){
        List data = studentService.selectAnswerS(null);
        return data;
    }
}
