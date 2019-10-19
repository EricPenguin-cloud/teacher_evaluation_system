package com.cqgcxy.tes.mapper;

import com.cqgcxy.tes.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GradeMapper {

    int insertGrade(String name);

    List<Grade> selectGradeList();
}
