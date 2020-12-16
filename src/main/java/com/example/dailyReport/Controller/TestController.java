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
public class TestController {
    @Autowired
    private AttendService attendService;

    //todo java heap space error
    @RequestMapping("/select/{id}")
    public List<Attend> selectAttend(@PathVariable(value="id") int school_id) {
        return attendService.selectAttend(school_id);
    }
    /*@RequestMapping("/selectFromTarget/{id}/{date}")
    public List<Attend> selectRecentTargetAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        return attendService.selectRecentTargetAttend(school_id,date);
    }*/
    @RequestMapping("/selectFromSource/{id}/{date}")
    public List<Attend> selectRecentSourceAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        return attendService.selectRecentSourceAttend(school_id,date);
    }
    @RequestMapping("/insert/{id}/{date}")
    public void insertRecentAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        List<Attend> attends=attendService.selectRecentSourceAttend(school_id,date);
        attendService.insertAttend(attends);
        attends=null;
    }
    @RequestMapping("/insert/{id}")
    public void insertAttend(@PathVariable(value="id") int school_id) {
        List<Attend> attends=attendService.selectAttend(school_id);
        attendService.insertAttend(attends);
        attends=null;
    }
    @RequestMapping("/api/{id}/{date}")
    public AttendApi attendApi(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
      /*  List<Attend> attends=attendService.selectAttend(school_id);
        attendService.insertAttend(attends);
        attends=null;*/
        return attendService.getattendApi(school_id,date);
    }
    @RequestMapping("/selectClassIds")
    public List<Integer> selectClassIds() {
        List<String> test = new ArrayList<>();
        test.add("2020级初中6班");
        test.add("2019级初中2班");
        test.add("2019级初中2班");
        return attendService.selectClassIds(test);
    }
    @RequestMapping("/selectPersonIds")
    public List<Integer> selectPersonIds() {
        List<String> test = new ArrayList<>();
        test.add("C20170301");
        test.add("C20170320");
        test.add("C20170306");
        return attendService.selectPersonIds(test);
    }
}
