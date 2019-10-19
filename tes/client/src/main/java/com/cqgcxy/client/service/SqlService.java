package com.cqgcxy.client.service;

import com.cqgcxy.client.bean.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "SQL-SERVER")
@Service
public interface SqlService {

    //参数一律要加@RequestParam或@RequestBody

    /**
     * /AdminController
     */
    //管理员登录
    @PostMapping("AdminLogin")
    @ResponseBody
    Response AdminLogin(@RequestParam String username,@RequestParam String password);
    //管理员重置学生密码
    @RequestMapping("passwords_s")
    @ResponseBody
    boolean passwords_s(@RequestParam int sid);
    //管理员重置教师密码
    @RequestMapping("passwords_t")
    @ResponseBody
    boolean passwords_t(@RequestParam int tid);
    //管理员更改学生信息
    @RequestMapping("studentupdateadmin")
    @ResponseBody
    boolean studentupdateadmin(@RequestParam Studentcnd studentcnd);
    @RequestMapping(value = "test")
    @ResponseBody
    String test(@RequestParam("param") String param,@RequestBody Student data);
    //exec导入学生信息
    @RequestMapping("ImportFileStudent")
    @ResponseBody
    boolean importfileStu(@RequestBody List<Studentcnd> studentcnds);
    //exec导入教师信息
    @RequestMapping("ImportFileTeacher")
    @ResponseBody
    boolean importfile(@RequestBody  List<Teacher> teachers);
    //给教师分配课程及上课的班级,传入的是id不是名称
    @RequestMapping("StudentTeacherRelationship")
    @ResponseBody
    String insertStudentTeacherRelationship(@RequestParam int tid,@RequestParam int gid,@RequestParam int cid);
    //给教师分配课程及上课的班级,传入的是id不是名称
    @RequestMapping("get_tcg_id")
    @ResponseBody
    List<Integer> get_tcg_id();
    /**
     * /StudentController
     */
    @PostMapping("StudentLogin")
    Response StudentLogin(@RequestParam String username,@RequestParam String password);
    //学生所有信息查询
    @RequestMapping("StudentList")
    List<Student> studentlist();
    //删除学生信息
    @RequestMapping("Studentdel")
    boolean studentdel(@RequestParam int sid);
    //更新学生信息
    @RequestMapping("Studentupdate")
    boolean studentupdate(@RequestParam Studentcnd studentcnd);
    //学生需评价教师
    @RequestMapping("ShowStudentEvaluateData")
    Response showstudentdata(@RequestParam int gid);
    //学生修改密码
    @RequestMapping("updatePasswordStudent")
    boolean updatePasswordStudent(@RequestParam String number,@RequestParam String password);
    //学生提交评价结果
    @RequestMapping("CommitStudentEvaluation")
    String commitstudentevaluation(@RequestParam("result_scnd") String result_scnd, @RequestBody List<Record_scnd> list);
    //学生查看自己评价结果
    @RequestMapping("showevaluateresult")
    List<Record_scnd> showStuevaluateresult(@RequestParam int sid);
    @RequestMapping("selectStudentStaete")
    List<Result_scnd> selectStudentStaete(@RequestParam int sid);
    //学生根据id与老师id查看评价结果
    @RequestMapping("showResult")
    List<Record_scnd> showResult(@RequestParam int sid,@RequestParam int tid);

    /**
     * /TeacherController
     */
    //教师登录
    @RequestMapping("TeacherLogin")
    Response TeacherLogin(@RequestParam String username,@RequestParam String password);
    //教师所有信息查询
    @RequestMapping("Teacherlist")
    List<Teacher> teacherlist();
    //删除教师信息
    @RequestMapping("Teacherdel")
    boolean teacherdel(@RequestParam int tid);
    //教师修改密码
    @RequestMapping("updatePasswordTeacher")
    boolean updatePasswordTeacher(@RequestParam String number,@RequestParam String password);
    //更新教师信息,传入修改的教师信息
    @RequestMapping("Teacherupdate")
    boolean teacherupdate(@RequestParam Teacher teacher);
    //教师需评的同行教师
    @RequestMapping("ShowTeacherEvaluateData")
    @ResponseBody
    List<Relationship_tcg> showteacherdata(@RequestParam int tid);
    //老师提交评价结果
    @RequestMapping("CommitTeacherEvaluation")
    String committeacherevaluation(@RequestParam("result_scnd") String result_scnd, @RequestBody List<Record_tcnd> list);
    //教师查看自己评价结果
    @RequestMapping("showevaluateresultteacher")
    List<Record_tcnd> showTeaevaluateresult(@RequestParam int tid);
    //查询教师评教状态
    @RequestMapping("selectTeacherSate")
    List<Result_tcnd> selectTeacherSate(@RequestParam int t_id1);
    //教师查看自己评价结果
    @RequestMapping("showEvaluateResult")
    List<Record_tcnd> showEvaluateResult(@RequestParam int t_id1,@RequestParam int t_id2);

    /**
     * CourseController
     */
    //添加课程
    @RequestMapping("addCourse")
    String addCourse(@RequestParam String name);
    //查询所有课程
    @RequestMapping("courseList")
    List<Course> courseList();

    /**
     * GradeController
     */
    //添加班级
    @RequestMapping("addGrade")
    String insertGrade(@RequestParam String name);
    //查询所有班级
    @RequestMapping("gradeList")
    List<Grade> gradeList();
    /**
     * echarts data
     */
    //查询每个分数段对应的老师人数(学生)
    @RequestMapping("selectCountS")
    List selectCountS();

    //查询每个指标评选的人数(学生)
    @RequestMapping("selectAnswerS")
    List selectAnswerS();

    //查询每个分数段对应的老师人数(教师)
    @RequestMapping("selectCountT")
    List selectCountT();

    //查询每个指标评选的人数(教师)
    @RequestMapping("selectAnswerT")
    List selectAnswerT();





}
