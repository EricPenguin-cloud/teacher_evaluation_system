package com.cqgcxy.tes.mapper;

import com.cqgcxy.tes.cnd.Record_tcnd;
import com.cqgcxy.tes.cnd.Relationship_tcgcnd;
import com.cqgcxy.tes.cnd.Result_scnd;
import com.cqgcxy.tes.cnd.Result_tcnd;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface TeacherMapper {
    List<Result_tcnd> selectTeacherSate(int t_id1);
    Teacher get(@Param("number") String number, @Param("password") String password);

    List<Teacher> teacherlist();

    boolean teacherdel(int tid);

    boolean teacherupdate(Teacher teacher);

    boolean teacherpw_reset(int tid);

    boolean updatePasswordTeacher(@Param("number") String number, @Param("password") String password);

    Relationship_tcgcnd selectteachercourse(int tid);

    List<Relationship_tcg> selectteachercolleague(@Param("cid") int cid, @Param("tid") int tid);

    int insertteacherevaluation(Result_tcnd rtt);

    int insertdatateacherevaluate(Record_tcnd rdt);

    List<Record_tcnd> selectshowresultteacher(int tid);

    List<Record_tcnd> selectShowResult(@Param("t_id1") int t_id1,@Param("t_id2")int t_id2);
    int selectCountT(@Param("total1") int total1,@Param("total2")int total2);

    int  selectAnswerT(String answer);
}
