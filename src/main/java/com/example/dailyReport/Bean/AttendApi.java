package com.example.dailyReport.Bean;

/**
 *
 * @Params: Todo refactor the return params
 * @Author: Siya(Xiran) Yan
 * @Date: 11:14 15/12/20
 */
public class AttendApi {
    private int school_id;
    private int student_num;
    private int teacher_num;
    private int attend_abnormal_sum;
    private String attend_abnormal_rate;
    private int attend_change;
    private int date;

    public void setAttend_change(int attend_change) {
        this.attend_change = attend_change;
    }

    public int getAttend_change() {
        return attend_change;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getAttend_abnormal_sum() {
        return attend_abnormal_sum;
    }

    public void setAttend_abnormal_rate(String attend_abnormal_rate) {
        this.attend_abnormal_rate = attend_abnormal_rate;
    }

    public int getDate() {
        return date;
    }

    public void setAttend_abnormal_sum(int attend_abnormal_sum) {
        this.attend_abnormal_sum = attend_abnormal_sum;
    }

    public int getStudent_num() {
        return student_num;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTeacher_num() {
        return teacher_num;
    }

    public void setStudent_num(int student_num) {
        this.student_num = student_num;
    }

    public String getAttend_abnormal_rate() {
        return attend_abnormal_rate;
    }

    public void setTeacher_num(int teacher_num) {
        this.teacher_num = teacher_num;
    }
}
