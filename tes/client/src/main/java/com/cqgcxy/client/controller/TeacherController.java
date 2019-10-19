package com.cqgcxy.client.controller;

import com.cqgcxy.client.bean.*;
import com.cqgcxy.client.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class TeacherController {
    @Autowired
    private SqlService sqlService;

    //教师登录
    @RequestMapping("TeacherLogin")
    public Response TeacherLogin(String username, String password) {
        return sqlService.TeacherLogin(username,password);
    }
    //教师所有信息查询
    @RequestMapping("Teacherlist")
    public List<Teacher> teacherlist(){
        return sqlService.teacherlist();
    }
    //删除教师信息
    @RequestMapping("Teacherdel")
    public boolean teacherdel(int tid){
        return sqlService.teacherdel(tid);
    }
    //教师修改密码
    @RequestMapping("updatePasswordTeacher")
    public boolean updatePasswordTeacher(String number,String password){
        return  sqlService.updatePasswordTeacher(number,password);
    }
    //更新教师信息,传入修改的教师信息
    @RequestMapping("Teacherupdate")
    public boolean teacherupdate(Teacher teacher){
        return sqlService.teacherupdate(teacher);
    }
    //教师需评的同行教师
    @RequestMapping("ShowTeacherEvaluateData")
    @ResponseBody
    public List<Relationship_tcg> showteacherdata(int tid){
        return sqlService.showteacherdata(tid);
    }
    //老师提交评价结果
    @RequestMapping("CommitTeacherEvaluation")
    public String committeacherevaluation(@RequestParam("result_scnd") String result_scnd, @RequestBody List<Record_tcnd> list){
        return sqlService.committeacherevaluation(result_scnd,list);
    }
    //教师查看自己评价结果
    @RequestMapping("showevaluateresultteacher")
    public List<Record_tcnd> showevaluateresult(int tid){
        return sqlService.showTeaevaluateresult(tid);
    }
    //查询教师评教状态
    @RequestMapping("selectTeacherSate")
    public List<Result_tcnd> selectTeacherSate(int t_id1){
        return sqlService.selectTeacherSate(t_id1);
    }

    //教师查看自己评价结果
    @RequestMapping("showEvaluateResult")
    public List<Record_tcnd> showEvaluateResult(int t_id1,int t_id2){
        return sqlService.showEvaluateResult(t_id1,t_id2);
    }
    //查询每个分数段对应的老师人数(教师)
    @RequestMapping("selectCountT")
    public List selectCountT(){
        return sqlService.selectCountT();
    }
    //查询每个指标评选的人数(教师)
    @RequestMapping("selectAnswerT")
    public List selectAnswerT(){
       return sqlService.selectAnswerT();
    }
}
