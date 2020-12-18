package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.AttendAbnormal;
import com.example.dailyReport.Bean.AttendApi;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

/**
* 
* @Params: ADD get classId and PersonId test
* @Author: Siya(Xiran) Yan 
* @Date: 11:15 15/12/20
*/

@RestController
@RequestMapping("/attend")
public class AttendApiController {
    @Autowired
    private AttendService attendService;
    //todo test api int date(1608048000) 2020-12-16
    @RequestMapping("/api/{id}/{date}")
    public AttendApi attendApi(@PathVariable(value="id") int school_id, @PathVariable(value="date") String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int datetime=Integer.valueOf(String.valueOf(simpleDateFormat.parse(date).getTime()/1000));
        return attendService.getAttendApi(school_id,datetime);
    }
    @RequestMapping("/api/{id}/{date}/{stage}")
    public List<AttendAbnormal> gradeApi(@PathVariable(value="id") int school_id, @PathVariable(value="stage") int stage, @PathVariable(value="date") String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int datetime=Integer.valueOf(String.valueOf(simpleDateFormat.parse(date).getTime()/1000));
        return attendService.getAbnormal(school_id,datetime,stage);
    }
    //todo 获取到秒精度的时间戳，且在转换过程中不发生错误，不能直接转化成int类型相除，会发生数据溢出
    /* String.valueOf(date.getTime()/1000);
     * Integer.valueOf(timestamp);
     * */
}
