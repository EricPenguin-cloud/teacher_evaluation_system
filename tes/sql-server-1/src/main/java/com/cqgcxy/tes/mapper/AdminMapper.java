package com.cqgcxy.tes.mapper;

import com.cqgcxy.tes.cnd.Relationship_tcgcnd;
import com.cqgcxy.tes.pojo.Administrator;
import com.cqgcxy.tes.pojo.Grade;
import com.cqgcxy.tes.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    Administrator get(@Param("username") String username, @Param("password") String password);

    int insertTeacher(Teacher teacher);

    boolean adminPasswordUpdate(@Param("username") String username, @Param("password") String password);

    int insertRelationship(Relationship_tcgcnd relationship_tcgcnd);
    List <Integer> get_tcg_id();
}

