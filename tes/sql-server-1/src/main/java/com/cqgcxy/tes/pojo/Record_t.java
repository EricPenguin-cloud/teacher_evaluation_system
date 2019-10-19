package com.cqgcxy.tes.pojo;

public class Record_t {
    private Integer id;

    private Result_t result_t;//教师的评价结果

    private String subject;

    private String answer;

    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Result_t getResult_t() { return result_t; }

    public void setResult_t(Result_t result_t) { this.result_t = result_t; }

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