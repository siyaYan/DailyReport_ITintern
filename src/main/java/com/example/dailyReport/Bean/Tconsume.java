package com.example.dailyReport.Bean;

import java.sql.Timestamp;

/**
*
* @Params: add table t_consume construction
* @Author: Siya(Xiran) Yan 
* @Date: 15:49 22/12/20
*/
public class Tconsume {
    private String student_no;
    private int bag_no;
    private String site;
    private int category;
    private int consume_money;
    private Timestamp consume_time;

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public void setBag_no(int bag_no) {
        this.bag_no = bag_no;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setConsume_money(int consume_money) {
        this.consume_money = consume_money;
    }

    public void setConsume_time(Timestamp consume_time) {
        this.consume_time = consume_time;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStudent_no() {
        return student_no;
    }

    public int getBag_no() {
        return bag_no;
    }

    public int getCategory() {
        return category;
    }

    public int getConsume_money() {
        return consume_money;
    }

    public String getSite() {
        return site;
    }

    public Timestamp getConsume_time() {
        return consume_time;
    }
}
