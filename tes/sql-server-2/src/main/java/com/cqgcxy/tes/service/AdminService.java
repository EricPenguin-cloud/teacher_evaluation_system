package com.cqgcxy.tes.service;


import com.cqgcxy.tes.cnd.Relationship_tcgcnd;
import com.cqgcxy.tes.pojo.Administrator;
import com.cqgcxy.tes.pojo.Grade;
import com.cqgcxy.tes.pojo.Teacher;

import java.util.List;

public interface AdminService {
    Administrator get(String username, String password);

    int insertTeacher(Teacher teacher);

    boolean adminPasswordUpdate(String username, String password);
    int insertRelationship(Relationship_tcgcnd relationship_tcgcnd);
}
