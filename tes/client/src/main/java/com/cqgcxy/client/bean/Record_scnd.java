package com.cqgcxy.client.bean;

public class Record_scnd {
    private Integer id;

    private int result_s_id;

    private String subject;

    private String answer;

    private String score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getResult_s_id() {
        return result_s_id;
    }

    public void setResult_s_id(int result_s_id) {
        this.result_s_id = result_s_id;
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