package com.cqgcxy.tes.pojo;

public class Record_s {
    private Integer id;

    private Result_s result_s;//学生的评价结果

    private String subject;

    private String answer;

    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Result_s getResult_s() { return result_s; }

    public void setResult_s_id(Result_s result_s) {
        this.result_s = result_s;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }
}