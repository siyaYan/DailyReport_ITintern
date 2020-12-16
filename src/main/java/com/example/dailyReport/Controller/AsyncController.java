package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Service.AsyncService;
import com.example.dailyReport.Service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class AsyncController {
    @Autowired
    private AsyncService attendService;
    /*@RequestMapping("/selectFromTarget/{id}/{date}")
    public List<Attend> selectRecentTargetAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        return attendService.selectRecentTargetAttend(school_id,date);
    }*/
    //todo java heap space error
    @RequestMapping("/select/{id}")
    public List<Attend> selectAttend(@PathVariable(value="id") int school_id) {
        return attendService.selectAttend(school_id);
    }
    @RequestMapping("/insert/{id}")
    public void insertAttend(@PathVariable(value="id") int school_id) {
        List<Attend> attends=attendService.selectAttend(school_id);
        attendService.insertAttend(attends);
        attends=null;
    }
    @RequestMapping("/insert/{id}/{date}")
    public void insertRecentAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        List<Attend> attends=attendService.selectRecentSourceAttend(school_id,date);
        attendService.insertAttend(attends);
        attends=null;
    }
}
