package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.ConsumeApi;
import com.example.dailyReport.Bean.Consume_ratio;
import com.example.dailyReport.Mapper.two.target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
*
* @Params: intial consume
* @Author: Siya(Xiran) Yan
* @Date: 10:21 18/12/20
*/
@Service
public class ConsumeService {
    @Autowired(required=false)
    private target targetData;
    @Autowired
    private DateTranferService dateTranferService;
    /*public List<ConsumeApi> getConsumes(int school_id,int date) {

    }*/
    public ConsumeApi getSumAndChange(int school_id,int date) {
        ConsumeApi consumeApi=new ConsumeApi();
        consumeApi.setConsume_sum(getConsumeSum(school_id,date));
        consumeApi.setRecharge_sum(getRechargeSum(school_id,date));
        consumeApi.setConsume_change(getConsumeChange(school_id,date));
        consumeApi.setRecharge_change(getRechargeChange(school_id,date));
        consumeApi.setConsume_ratio(getConsumeRatio(school_id,date));
        consumeApi.setDate(dateTranferService.dateIntTranferString(date));
        return consumeApi;
    }
    public Integer getConsumeSum(int school_id,int date) {
        int consumeSum=0;
        List<Integer> lists = new ArrayList<>();
        lists=targetData.selectDayConsume(school_id,date,1);
        for (Integer consume:lists) {
            consumeSum+=(-consume);
        }
        return consumeSum;
    }
    public Integer getRechargeSum(int school_id,int date) {
        int rechargeSum=0;
        List<Integer> lists = new ArrayList<>();
        lists=targetData.selectDayConsume(school_id,date,0);
        for (Integer recharge:lists) {
            rechargeSum+=recharge;
        }
        return rechargeSum;
    }
    public Integer getConsumeChange(int school_id,int date) {
        int change=0;
        change=getConsumeSum(school_id,date)-getConsumeSum(school_id,date-86400);
        return change;
    }
    public Integer getRechargeChange(int school_id,int date) {
        int change=0;
        change=getRechargeSum(school_id,date)-getRechargeSum(school_id,date-86400);
        return change;
    }
    public List<String> getConsumePlaces(int school_id,int date) {
        return targetData.selectConsumePlaces(school_id, date);
    }
    public List<Integer> getPlacesCount(int school_id,int date,List<String> places) {
        List<Integer> counts = new ArrayList<>();
        for (String place : places) {
            counts.add(targetData.countConsumePlace(school_id, date,place));
        }
        return counts;
    }
    public String getConsumeRate(int school_id,int date,List<Integer> places,int position) {
        List<Integer> counts = new ArrayList<>();
        int sum=0;
        for (Integer place : places) {
            sum+=place;
        }
      /*  System.out.println(sum);
        System.out.println(position);*/
        String rate=String.valueOf((float)position/(float)sum);
        return rate;
    }
    public List<Consume_ratio> getConsumeRatio(int school_id,int date) {
        List<Consume_ratio> consume_ratios=new ArrayList<>();
        List<String> places = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        places=getConsumePlaces(school_id,date);
        counts=getPlacesCount(school_id,date,places);
        for (int i=0;i<places.size();i++) {
            Consume_ratio consume_ratio = new Consume_ratio();
            consume_ratio.setPosition(places.get(i));
            consume_ratio.setFrequency(counts.get(i));
            consume_ratio.setRate(getConsumeRate(school_id,date,counts,counts.get(i)));
            consume_ratios.add(consume_ratio);
        }
        return consume_ratios;
    }
}
