package com.cqgcxy.tes.service.impl;

import com.cqgcxy.tes.cnd.Record_tcnd;
import com.cqgcxy.tes.cnd.Relationship_tcgcnd;
import com.cqgcxy.tes.cnd.Result_tcnd;
import com.cqgcxy.tes.mapper.TeacherMapper;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.pojo.Teacher;
import com.cqgcxy.tes.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Override
    public List<Result_tcnd> selectTeacherSate(int t_id1) {
        return teacherMapper.selectTeacherSate(t_id1);
    }

    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public Teacher get(String username, String password) {
        Teacher teacher = teacherMapper.get(username,password);
        if(teacher!=null)
            return teacher;
        return null;
    }

    @Override
    public List<Teacher> teacherlist() {
        return teacherMapper.teacherlist();
    }

    @Override
    public boolean teacherdel(int tid) {
        boolean flag = teacherMapper.teacherdel(tid);
        if (flag){return true;}
        return false;
    }

    @Override
    public boolean teacherupdate(Teacher teacher) {
        boolean flag = teacherMapper.teacherupdate(teacher);
        if (flag){return true;}
        return false;
    }

    @Override
    public boolean teacherpw_reset(int tid) {
        boolean flag = teacherMapper.teacherpw_reset(tid);
        if (flag){return true;}
        return false;
    }

    @Override
    public boolean updatePasswordTeacher(String number, String password) {
        return teacherMapper.updatePasswordTeacher(number,password);
    }

    @Override
    public Relationship_tcgcnd selectteachercourse(int tid) {
        return teacherMapper.selectteachercourse(tid);
    }

    @Override
    public List<Relationship_tcg> selectteachercolleague(int cid,int tid) {
        return teacherMapper.selectteachercolleague(cid,tid);
    }

    //插入评价信息返回主键
    @Override
    public int insertteacherevaluation(int t_id1, int t_id2, String total) {
        Result_tcnd rtt = new Result_tcnd();
        rtt.setT_id1(t_id1);
        rtt.setT_id2(t_id2);
        rtt.setTotal(total);
        int i = teacherMapper.insertteacherevaluation(rtt);
        int primaryKey = rtt.getId();
        return primaryKey;
    }

    @Override
    public int insertdatateacherevaluate(int result_t_id, String subject, String answer, String score) {
        Record_tcnd rdt = new Record_tcnd();
        rdt.setResult_t_id(result_t_id);
        rdt.setSubject(subject);
        rdt.setAnswer(answer);
        rdt.setScore(score);
        return teacherMapper.insertdatateacherevaluate(rdt);
    }

    @Override
    public List<Record_tcnd> selectshowresultteacher(int tid) {

        return teacherMapper.selectshowresultteacher(tid);
    }

    @Override
    public List<Record_tcnd> selectShowResult(int t_id1,int t_id2) {

        return teacherMapper.selectShowResult(t_id1,t_id2);
    }

    @Override
    public List selectCountT(int total1, int total2) {
        List arr = new ArrayList<>();
        int count = 0;
        for (int i=0;i<100;){
            total1=i;
            i=i+10;
            total2=i;
            count = teacherMapper.selectCountT(total1,total2);
            arr.add(count);
        }
        return arr;
    }
    @Override
    public List selectAnswerT(String answer) {
        List arr = new ArrayList<>();
        int count = 0;
        for (int i=0;i<4;i++){
            if (i==1){answer="非常满意";}
            else if (i==2){answer="一般满意";}
            else if (i==3){answer="满意";}
            else {answer="不满意";}
            count = teacherMapper.selectAnswerT(answer);
            arr.add(count);
        }
        return arr;
    }
}
