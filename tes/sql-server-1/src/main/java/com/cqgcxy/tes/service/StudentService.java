package com.cqgcxy.tes.service;

import com.cqgcxy.tes.cnd.*;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.pojo.Student;

import java.util.List;

public interface StudentService {
    Student get(String name, String password);

    List<Student> studentlist();

    boolean studentdel(int tid);

    boolean studentupdate(Studentcnd studentcnd);

    boolean studentupdateadmin(Studentcnd studentcnd);

    boolean studentpw_reset(int tid);

    boolean updatePasswordStudent(String number, String password);

    List<Relationship_tcg> selectrelationship(int gid);

    int insertstudentevaluation(int sid, int tid, String total);

    int insertdetailedevaluate(int result_s_id, String subject, String answer, String score);

    int insertstudentcnd(Studentcnd studentcnd);

    List<Record_scnd> selectshowresult(int sid);

    List<Result_scnd> selectStudentStaete(int sid);
    List<Record_scnd> showresult(int t_id1, int t_id2);
    List selectCountS (int total1,int total2);

    List selectAnswerS(String answer);
}
