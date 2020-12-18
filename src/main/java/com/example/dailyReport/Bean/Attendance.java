package com.example.dailyReport.Bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @Params: annotate position parameters
 * @Author: Siya(Xiran) Yan
 * @Date: 11:14 15/12/20
 */
public class Attendance {

    private int attend_id;
    private int school_id;
    private String class_name;
    private String student_no;
    private String student_name;
    private int attend_status;
    private Timestamp attend_time;

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setAttend_id(int attend_id) {
        this.attend_id = attend_id;
    }

    public void setAttend_status(int attend_status) {
        this.attend_status = attend_status;
    }

    public void setAttend_time(Timestamp attend_time) {
        this.attend_time = attend_time;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_no() {
        return student_no;
    }

    public int getAttend_id() {
        return attend_id;
    }

    public int getAttend_status() {
        return attend_status;
    }

    public Date getAttend_time() {
        return attend_time;
    }

    public int getSchool_id() {
        return school_id;
    }

}
