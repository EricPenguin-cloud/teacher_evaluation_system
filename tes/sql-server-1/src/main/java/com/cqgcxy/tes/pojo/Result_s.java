package com.cqgcxy.tes.pojo;

public class Result_s {
    private Integer id;

    private Student student;

    private Teacher teacher;//被评教师

    private String total;//总分

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() { return student; }

    public void setStudent(Student student) { this.student = student; }

    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }
}