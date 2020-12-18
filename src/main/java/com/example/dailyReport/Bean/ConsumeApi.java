package com.example.dailyReport.Bean;

import java.util.List;

/**
*
* @Params: consume api
* @Author: Siya(Xiran) Yan
* @Date: 10:21 18/12/20
*/
public class ConsumeApi {
    private String date;
    private Integer consume_sum;
    private Integer recharge_sum;
    private Integer consume_change;
    private Integer recharge_change;
    private List<Consume_ratio> consume_ratio;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public List<Consume_ratio> getConsume_ratio() {
        return consume_ratio;
    }

    public void setConsume_ratio(List<Consume_ratio> consume_ratio) {
        this.consume_ratio = consume_ratio;
    }

    public Integer getConsume_change() {
        return consume_change;
    }

    public Integer getConsume_sum() {
        return consume_sum;
    }

    public Integer getRecharge_change() {
        return recharge_change;
    }


    public Integer getRecharge_sum() {
        return recharge_sum;
    }

    public void setConsume_change(Integer consume_change) {
        this.consume_change = consume_change;
    }

    public void setConsume_sum(Integer consume_sum) {
        this.consume_sum = consume_sum;
    }


    public void setRecharge_change(Integer recharge_change) {
        this.recharge_change = recharge_change;
    }

    public void setRecharge_sum(Integer recharge_sum) {
        this.recharge_sum = recharge_sum;
    }


}


