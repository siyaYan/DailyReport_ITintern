package com.example.dailyReport.Bean;

/**
 *
 * @Params: word
 * @Author: Siya(Xiran) Yan
 * @Date: 15:49 21/12/20
 */
public class Word {
    private int school_id;
    private String keyword;
    private int num;

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSchool_id() {
        return school_id;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getNum() {
        return num;
    }
}
