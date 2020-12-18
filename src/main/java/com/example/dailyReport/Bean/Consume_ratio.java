package com.example.dailyReport.Bean;

public class Consume_ratio {
    private Integer frequency;
    private String position;
    private String rate;

    public String getRate() {
        return rate;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public String getPosition() {
        return position;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
