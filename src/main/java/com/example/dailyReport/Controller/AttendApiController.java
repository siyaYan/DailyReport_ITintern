package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.AttendApi;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //todo test api int date(1608048000) 12/16/00
    @RequestMapping("/api/{id}/{date}")
    public AttendApi attendApi(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        return attendService.getAttendApi(school_id,date);
    }
    @RequestMapping("/api/{id}/{date}/{stage}")
    public AttendApi gradeApi(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        return attendService.getAttendApi(school_id,date);
    }
}
