package com.cqgcxy.tes.service.impl;

import com.cqgcxy.tes.mapper.GradeMapper;
import com.cqgcxy.tes.pojo.Grade;
import com.cqgcxy.tes.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServicelmpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public int insertGrade(String name) {
        return gradeMapper.insertGrade(name);
    }

    @Override
    public List<Grade> selectGradeList() {
        return gradeMapper.selectGradeList();
    }
}
