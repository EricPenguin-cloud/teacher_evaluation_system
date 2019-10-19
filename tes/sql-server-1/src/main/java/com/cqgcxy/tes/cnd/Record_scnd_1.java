package com.cqgcxy.tes.cnd;

public class Record_scnd_1 {
    private String subject;

    private String answer;

    private String score;

    @Override
    public String toString() {
        return "Record_scnd_1{" +
                "subject='" + subject + '\'' +
                ", answer='" + answer + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
