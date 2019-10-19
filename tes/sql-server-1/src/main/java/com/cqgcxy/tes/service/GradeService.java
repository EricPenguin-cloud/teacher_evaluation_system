package com.cqgcxy.tes.service;

import com.cqgcxy.tes.pojo.Grade;

import java.util.List;

public interface GradeService {

    int insertGrade(String name);

    List<Grade> selectGradeList();
}
