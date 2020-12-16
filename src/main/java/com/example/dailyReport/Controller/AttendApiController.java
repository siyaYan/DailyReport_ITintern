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

    @RequestMapping("/api/{id}/{date}")
    public AttendApi attendApi(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
      /*  List<Attend> attends=attendService.selectAttend(school_id);
        attendService.insertAttend(attends);
        attends=null;*/
        return attendService.getattendApi(school_id,date);
    }

}
