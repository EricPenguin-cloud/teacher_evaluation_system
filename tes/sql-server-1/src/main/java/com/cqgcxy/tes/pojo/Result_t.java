package com.cqgcxy.tes.pojo;

public class Result_t {
    private Integer id;

    private Teacher teacher1;//评价老师

    private Teacher teacher2;//被评老师

    private String total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher1() { return teacher1; }

    public void setTeacher1(Teacher teacher1) { this.teacher1 = teacher1; }

    public Teacher getTeacher2() { return teacher2; }

    public void setTeacher2(Teacher teacher2) { this.teacher2 = teacher2; }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }
}