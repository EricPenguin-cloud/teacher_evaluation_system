package com.cqgcxy.tes.service.impl;

import com.cqgcxy.tes.cnd.Record_scnd;
import com.cqgcxy.tes.cnd.Studentcnd;
import com.cqgcxy.tes.mapper.StudentMapper;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.cnd.Result_scnd;
import com.cqgcxy.tes.pojo.Student;
import com.cqgcxy.tes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    //学生登录并返回Student
    @Override
    public Student get(String name, String password) {
        Student student = studentMapper.get(name,password);
        if(student!=null)
            return student;
        return null;
    }
    //查询学生所有信息
    @Override
    public List<Student> studentlist() {
        return studentMapper.studentlist();
    }
    //根据学生id删除学生
    @Override
    public boolean studentdel(int sid) {
        boolean flag = studentMapper.studentdel(sid);
        if (flag){return true;}
        return false;
    }
    //根据学生id更新学生基本信息
    @Override
    public boolean studentupdate(Studentcnd studentcnd) {
        boolean flag = studentMapper.studentupdate(studentcnd);
        if (flag){return true;}
        return false;
    }
    //管理员根据学生id更改学生所有信息
    @Override
    public boolean studentupdateadmin(Studentcnd studentcnd) {
        boolean flag = studentMapper.studentupdateadmin(studentcnd);
        if (flag){return true;}
        return false;
    }
    //管理员根据学生id重置学生密码
    @Override
    public boolean studentpw_reset(int sid) {
        boolean flag = studentMapper.studentpw_reset(sid);
        if (flag){return true;}
        return false;
    }

    @Override
    public boolean updatePasswordStudent(String number, String password) {
        return studentMapper.updatePasswordStudent(number,password);
    }

    //导入学生信息
    @Override
    public int insertstudentcnd(Studentcnd studentcnd) {
        int i = studentMapper.insertstudentcnd(studentcnd);
        return i;
    }


    //根据学生的年级id查询与其他表的所有信息
    @Override
    public List<Relationship_tcg> selectrelationship(int gid) {
        return studentMapper.selectrelationship(gid);
    }

    //插入评价信息返回主键
    @Override
    public int insertstudentevaluation(int sid, int tid, String total) {
        Result_scnd rts = new Result_scnd();
        rts.setSid(sid);
        rts.setTid(tid);
        rts.setTotal(total);
        int i = studentMapper.insertstudentevaluation(rts);
        int primaryKey = rts.getId();
        return primaryKey;
    }
    //插入详细评价信息，
    @Override
    public int insertdetailedevaluate(int result_s_id, String subject, String answer, String score) {
        Record_scnd rds = new Record_scnd();
        rds.setResult_s_id(result_s_id);
        rds.setSubject(subject);
        rds.setAnswer(answer);
        rds.setScore(score);
        int result = studentMapper.insertdetailedevaluate(rds);
        return result;
    }
    //学生查看自己的评价结果
    @Override
    public List<Record_scnd> selectshowresult(int sid) {

        return studentMapper.selectshowresult(sid);
    }

    @Override
    public List<Result_scnd> selectStudentStaete(int sid) {
        return studentMapper.selectStudentStaete(sid);
    }

    //学生查看自己的评价结果
    @Override
    public List<Record_scnd> showresult(int sid, int tid) {

        return studentMapper.showresult(sid,tid);
    }

    @Override
    public List selectCountS(int total1, int total2) {
        List arr = new ArrayList<>();
        int count = 0;
        for (int i=0;i<100;){
            total1=i;
            i=i+10;
            total2=i;
            count = studentMapper.selectCountS(total1,total2);
            arr.add(count);
        }
        return arr;
    }

    @Override
    public List selectAnswerS(String answer) {
        List arr = new ArrayList<>();
        int count = 0;
        for (int i=0;i<4;i++){
            if (i==1){answer="非常满意";}
            else if (i==2){answer="一般满意";}
            else if (i==3){answer="满意";}
            else {answer="不满意";}
            count = studentMapper.selectAnswerS(answer);
            arr.add(count);
        }
        return arr;
    }
}
