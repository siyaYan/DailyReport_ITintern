package com.example.dailyReport.Bean;

/**
 *
 * @Params: subject data
 * @Author: Siya(Xiran) Yan
 * @Date: 10:31 18/12/20
 */
public class Subject {
    private String subject;
    private int teacher_sum;
    private String rate;


    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTeacher_sum(int teacher_sum) {
        this.teacher_sum = teacher_sum;
    }

    public String getRate() {
        return rate;
    }

    public int getTeacher_sum() {
        return teacher_sum;
    }

    public String getSubject() {
        return subject;
    }
}
