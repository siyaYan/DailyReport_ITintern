package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Service.AsyncService;
import com.example.dailyReport.Service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

public class TestController {
    @Autowired
    private AsyncService attendService;
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

    @RequestMapping("/selectFromSource/{id}/{date}")
    public List<Attend> selectRecentSourceAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        return attendService.selectRecentSourceAttend(school_id,date);
    }

    @RequestMapping("/insert/{id}")
    public void insertAttend(@PathVariable(value="id") int school_id) {
        List<Attend> attends=attendService.selectAttend(school_id);
        attendService.insertAttend(attends);
        attends=null;
    }
}
