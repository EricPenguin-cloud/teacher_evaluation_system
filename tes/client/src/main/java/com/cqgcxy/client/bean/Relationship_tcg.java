package com.cqgcxy.client.bean;

public class Relationship_tcg {
    private Integer id;

    private Teacher teacher;

    private Course course;

    private Grade grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public Course getCourse() { return course; }

    public void setCourse(Course course) { this.course = course; }

    public Grade getGrade() { return grade; }

    public void setGrade(Grade grade) { this.grade = grade; }
}