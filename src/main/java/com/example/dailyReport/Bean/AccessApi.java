package com.example.dailyReport.Bean;

/**
*
* @Params: access data
* @Author: Siya(Xiran) Yan
* @Date: 10:31 21/12/20
*/
public class AccessApi {
    private String date;
    private Integer enter_sum;
    private Integer exit_sum;

    public void setDate(String date) {
        this.date = date;
    }

    public void setEnter_sum(Integer enter_sum) {
        this.enter_sum = enter_sum;
    }

    public void setExit_sum(Integer exit_sum) {
        this.exit_sum = exit_sum;
    }

    public String getDate() {
        return date;
    }

    public Integer getEnter_sum() {
        return enter_sum;
    }

    public Integer getExit_sum() {
        return exit_sum;
    }
}
