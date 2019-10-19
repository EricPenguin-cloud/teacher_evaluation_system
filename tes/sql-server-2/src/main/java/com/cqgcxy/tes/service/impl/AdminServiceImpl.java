package com.cqgcxy.tes.service.impl;


import com.cqgcxy.tes.cnd.Relationship_tcgcnd;
import com.cqgcxy.tes.mapper.AdminMapper;
import com.cqgcxy.tes.pojo.Administrator;
import com.cqgcxy.tes.pojo.Grade;
import com.cqgcxy.tes.pojo.Teacher;
import com.cqgcxy.tes.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Administrator get(String username, String password) {
        Administrator admin = adminMapper.get(username,password);
        if(admin!=null)
            return admin;
        return null;
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        return adminMapper.insertTeacher(teacher);
    }

    @Override
    public boolean adminPasswordUpdate(String username, String password) {
        return adminMapper.adminPasswordUpdate(username,password);
    }

    @Override
    public int insertRelationship(Relationship_tcgcnd relationship_tcgcnd) {
        return adminMapper.insertRelationship(relationship_tcgcnd);
    }
}
