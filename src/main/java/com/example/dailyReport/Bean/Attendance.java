package com.example.dailyReport.Bean;

import java.util.Date;

public class Attendance {
    private int school_id;
    private String student_grade;
    private String student_class;
    private String status;
    private String student_type;
    private Date date;

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public void setStudent_grade(String student_grade) {
        this.student_grade = student_grade;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStudent_type(String student_type) {
        this.student_type=student_type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSchool_id() {
        return school_id;
    }

    public Date getDate() {
        return date;
    }

    public String getStudent_class() {
        return student_class;
    }

    public String getStudent_grade() {
        return student_grade;
    }

    public String getStatus() {
        return status;
    }

    public String getStudent_type() {
        return student_type;
    }

}
