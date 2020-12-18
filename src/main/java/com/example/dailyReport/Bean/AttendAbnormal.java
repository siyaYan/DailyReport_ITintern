package com.example.dailyReport.Bean;

import java.util.List;

public class AttendAbnormal {
    private String class_name;
    private Integer stage;
    private Integer leave_sum;
    private Integer late_sum;
    private Integer absent_sum;
    private Integer leave_change;
    private Integer late_change;
    private Integer absent_change;

    public void setLeave_change(Integer leave_change) {
        this.leave_change = leave_change;
    }

    public void setAbsent_change(Integer absent_change) {
        this.absent_change = absent_change;
    }

    public void setLate_change(Integer late_change) {
        this.late_change = late_change;
    }

    public Integer getAbsent_change() {
        return absent_change;
    }

    public Integer getLate_change() {
        return late_change;
    }

    public Integer getLeave_change() {
        return leave_change;
    }

    public void setLeave_sum(Integer leave_sum) {
        this.leave_sum = leave_sum;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public void setLate_sum(Integer late_sum) {
        this.late_sum = late_sum;
    }

    public void setAbsent_sum(Integer absent_sum) {
        this.absent_sum = absent_sum;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }


    public Integer getAbsent_sum() {
        return absent_sum;
    }

    public Integer getLate_sum() {
        return late_sum;
    }


    public String getClass_name() {
        return class_name;
    }

    public int getLeave_sum() {
        return leave_sum;
    }

    public int getStage() {
        return stage;
    }
}
