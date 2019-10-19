package com.cqgcxy.tes.web;

import com.cqgcxy.tes.mapper.GradeMapper;
import com.cqgcxy.tes.pojo.Grade;
import com.cqgcxy.tes.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class GradeController {

    @Autowired
    GradeService gradeService;

    //添加班级
    @RequestMapping("addGrade")
    public String insertGrade(String name){
        int result = gradeService.insertGrade(name);
        if (result>0){
            return "添加成功";
        }
        return "添加失败";
    }
    //查询所有班级
    @RequestMapping("gradeList")
    public List<Grade> gradeList(){
        List<Grade> gradeList = gradeService.selectGradeList();

        return gradeList;
    }
}
