package com.cqgcxy.tes.service;



import com.cqgcxy.tes.cnd.Record_scnd;
import com.cqgcxy.tes.cnd.Record_tcnd;
import com.cqgcxy.tes.cnd.Relationship_tcgcnd;
import com.cqgcxy.tes.cnd.Result_tcnd;
import com.cqgcxy.tes.pojo.Record_t;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Result_tcnd> selectTeacherSate(int t_id1);

    Teacher get(String number, String password);

    List<Teacher> teacherlist();

    boolean teacherdel(int tid);

    boolean teacherupdate(Teacher teacher);

    boolean teacherpw_reset(int tid);

    boolean updatePasswordTeacher(String number, String password);

    Relationship_tcgcnd selectteachercourse(int tid);

    List<Relationship_tcg> selectteachercolleague(int cid, int tid);

    int insertteacherevaluation(int t_id1, int t_id2, String total);

    int insertdatateacherevaluate(int result_t_id, String subject, String answer, String score);

    List<Record_tcnd> selectshowresultteacher(int tid);

    List<Record_tcnd> selectShowResult(int t_id1,int t_id2);

    List selectCountT(int total1,int total2);

    List selectAnswerT(String answer);
}
