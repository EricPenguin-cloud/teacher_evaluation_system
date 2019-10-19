package com.cqgcxy.client.bean;

import java.util.List;

public class Grade {
    private Integer id;

    private String name;

    //非数据库字段
    private List<Student> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}