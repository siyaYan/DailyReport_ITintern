package com.example.dailyReport.Bean;

/**
*
* @Params: consume api
* @Author: Siya(Xiran) Yan
* @Date: 10:21 18/12/20
*/
public class ConsumeApi {
    private Integer consume_sum;
    private Integer recharge_sum;
    private Integer consume_change;
    private Integer recharge_change;
    private Integer consume_ratio;
    private Integer frequency;
    private String position;
    private String rate;

    public Integer getConsume_change() {
        return consume_change;
    }

    public Integer getConsume_sum() {
        return consume_sum;
    }

    public Integer getRecharge_change() {
        return recharge_change;
    }

    public String getPosition() {
        return position;
    }

    public Integer getConsume_ratio() {
        return consume_ratio;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public Integer getRecharge_sum() {
        return recharge_sum;
    }

    public String getRate() {
        return rate;
    }

    public void setConsume_change(Integer consume_change) {
        this.consume_change = consume_change;
    }

    public void setConsume_sum(Integer consume_sum) {
        this.consume_sum = consume_sum;
    }

    public void setConsume_ratio(Integer consume_ratio) {
        this.consume_ratio = consume_ratio;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public void setRecharge_change(Integer recharge_change) {
        this.recharge_change = recharge_change;
    }

    public void setRecharge_sum(Integer recharge_sum) {
        this.recharge_sum = recharge_sum;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}


