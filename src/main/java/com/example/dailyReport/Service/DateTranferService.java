package com.example.dailyReport.Service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DateTranferService {
    // 获取到秒精度的时间戳，且在转换过程中不发生错误，不能直接转化成int类型相除，会发生数据溢出
    /* String.valueOf(date.getTime()/1000);
     * Integer.valueOf(timestamp);
     * */
    //String(yyyy-mm-dd) transferAttend to 10 int timestamp
    public String dateIntTranferString(int date) {
        long temp = (long) date * 1000;
        Timestamp ts = new Timestamp(temp);
        String tsStr = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(ts);
    }
    //10 int timestamp transferAttend to String(yyyy-mm-dd)
    public int dateStringTranferInt(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return Integer.valueOf(String.valueOf(simpleDateFormat.parse(date).getTime()/1000));
    }
    //String(yyyy-mm-dd) to 13 timestamp
    public Timestamp dateStringTranferTimestamp(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return new Timestamp(simpleDateFormat.parse(date).getTime());
    }
    //13 timestamp transferAttend to int 10
    public Integer dateTimestampTranferInt(Timestamp date)  {
        int time= (int) (date.getTime()/1000);
        return time;
    }
}
