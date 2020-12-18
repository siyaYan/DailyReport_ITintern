package com.example.dailyReport.Bean;

public class Teacher {
    private int teacher_id;
    private String teacher_name;
    private int course_sum;

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setCourse_sum(int course_sum) {
        this.course_sum = course_sum;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getCourse_sum() {
        return course_sum;
    }

    public String getTeacher_name() {
        return teacher_name;
    }
}
