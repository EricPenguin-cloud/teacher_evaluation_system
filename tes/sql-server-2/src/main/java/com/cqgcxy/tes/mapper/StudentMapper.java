package com.cqgcxy.tes.mapper;

import com.cqgcxy.tes.cnd.Record_scnd;
import com.cqgcxy.tes.cnd.Result_scnd;
import com.cqgcxy.tes.cnd.Studentcnd;
import com.cqgcxy.tes.pojo.Relationship_tcg;
import com.cqgcxy.tes.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Mapper
@Repository
public interface StudentMapper {
    Student get(@Param("name") String name, @Param("password") String password);

    List<Student> studentlist();

    boolean studentdel(int sid);

    boolean studentupdate(Studentcnd studentcnd);

    boolean studentupdateadmin(Studentcnd studentcnd);

    boolean studentpw_reset(int sid);

    boolean updatePasswordStudent(@Param("number") String number, @Param("password") String password);


    //Student getstu(int sid);//根据sid获取学生信息
    int insertstudentcnd(Studentcnd studentcnd);

    List<Relationship_tcg> selectrelationship(int gid);

    int insertstudentevaluation(Result_scnd rts);

    //int insertdetailedevaluate(int result_s_id,String subject,String answer,String score);
    int insertdetailedevaluate(Record_scnd rds);

    List<Record_scnd> selectshowresult(int sid);

    List<Record_scnd> showresult(@Param("sid") int sid,@Param("tid") int tid);

    List<Result_scnd> selectStudentStaete(int sid);

    int selectCountS (@Param("total1") int total1,@Param("total2")int total2);

    int  selectAnswerS(String answer);

}
