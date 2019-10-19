package com.cqgcxy.tes.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cqgcxy.tes.Response.Response;
import com.cqgcxy.tes.cnd.Record_scnd;
import com.cqgcxy.tes.cnd.Record_tcnd;
import com.cqgcxy.tes.cnd.Relationship_tcgcnd;
import com.cqgcxy.tes.cnd.Result_tcnd;
import com.cqgcxy.tes.pojo.Record_t;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.pojo.Result_t;
import com.cqgcxy.tes.pojo.Teacher;
import com.cqgcxy.tes.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    //教师登录
    @RequestMapping("TeacherLogin")
    public Response TeacherLogin(String username, String password) {
        Teacher teacher = teacherService.get(username,password);
        if(null==teacher){
            return new Response(0,null);
        }
        return new Response(1,teacher);
    }
    //教师所有信息查询
    @RequestMapping("Teacherlist")
    public List<Teacher> teacherlist(){
        List<Teacher> list = teacherService.teacherlist();
        return list;
    }
    //删除教师信息
    @RequestMapping("Teacherdel")
    public boolean teacherdel(int tid){
        boolean result = teacherService.teacherdel(tid);
        return result;
    }
    //教师修改密码
    @RequestMapping("updatePasswordTeacher")
    public boolean updatePasswordTeacher(String number,String password){
        boolean result = teacherService.updatePasswordTeacher(number,password);
        return result;
    }
    //更新教师信息,传入修改的教师信息
    @RequestMapping("Teacherupdate")
    public boolean teacherupdate(Teacher teacher){
        boolean result = teacherService.teacherupdate(teacher);
        return result;
    }
    //教师需评的同行教师
    @RequestMapping("ShowTeacherEvaluateData")
    @ResponseBody
    public List<Relationship_tcg> showteacherdata(int tid){
        Relationship_tcgcnd relationship_tcg = teacherService.selectteachercourse(tid);
        int cid = relationship_tcg.getCid();
        List<Relationship_tcg> colleaguelist =teacherService.selectteachercolleague(cid,tid);
        return colleaguelist;
    }
    //老师提交评价结果
    @RequestMapping("CommitTeacherEvaluation")
    public String committeacherevaluation(@RequestParam("result_scnd") String result_scnd, @RequestBody List<Record_tcnd> list){
        JSONObject obj = JSON.parseObject(result_scnd);
        int t_id1 = obj.getIntValue("t_id1");
        int t_id2 = obj.getIntValue("t_id2");
        String total = obj.getString("total");

        int primaryKey = teacherService.insertteacherevaluation(t_id1,t_id2,total);
        System.out.println(primaryKey);
        int result = -1;
        for(Record_tcnd record_tcnd : list) {
//            record_tcnd.setResult_t(result_t);
            int result_t_id = primaryKey;
            String subject     = record_tcnd.getSubject();
            String answer      = record_tcnd.getAnswer();
            String score       = record_tcnd.getScore();

            System.out.printf(subject+answer+score);
            result = teacherService.insertdatateacherevaluate(result_t_id,subject,answer,score);
        }
        if(result >= 0){
            return "success";}
        else{
            return "fail";}
    }
    //教师查看自己评价结果
    @RequestMapping("showevaluateresultteacher")
    public List<Record_tcnd> showevaluateresult(int tid){
        List<Record_tcnd> showresult = teacherService.selectshowresultteacher(tid);
        return  showresult;
    }
    //查询教师评教状态
    @RequestMapping("selectTeacherSate")
    public List<Result_tcnd> selectTeacherSate(int t_id1){
        List<Result_tcnd> staet = teacherService.selectTeacherSate(t_id1);
        return staet;
    }

    //教师查看自己评价结果
    @RequestMapping("showEvaluateResult")
    public List<Record_tcnd> showEvaluateResult(int t_id1,int t_id2){
        List<Record_tcnd> showEvaluateResultt = teacherService.selectShowResult(t_id1,t_id2);
        return  showEvaluateResultt;
    }
    //查询每个分数段对应的老师人数(教师)
    @RequestMapping("selectCountT")
    public List selectCountT(){
        List data = teacherService.selectCountT(0,0);
        return data;
    }
    //查询每个指标评选的人数(教师)
    @RequestMapping("selectAnswerT")
    public List selectAnswerT(){
        List data = teacherService.selectAnswerT(null);
        return data;
    }

}
