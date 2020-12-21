package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.AttendAbnormal;
import com.example.dailyReport.Bean.AttendApi;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Service.AttendService;
import com.example.dailyReport.Service.DateTranferService;
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
public class AttendController {
    @Autowired
    private AttendService attendService;
    @Autowired
    private DateTranferService dateTranferService;
    //todo test api int date(1608048000) 2020-12-16
    @RequestMapping("/api/{id}/{date}")
    public AttendApi attendApi(@PathVariable(value="id") int school_id, @PathVariable(value="date") String date) throws ParseException {
        return attendService.getAttendApi(school_id,dateTranferService.dateStringTranferInt(date));
    }
    @RequestMapping("/api/{id}/{date}/{stage}")
    public List<AttendAbnormal> gradeApi(@PathVariable(value="id") int school_id, @PathVariable(value="stage") int stage, @PathVariable(value="date") String date) throws ParseException {
        return attendService.getAbnormal(school_id,dateTranferService.dateStringTranferInt(date),stage);
    }
}
