package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
  /*  @RequestMapping("/insert")
    public Boolean insert() {
        testService.insert()
    }*/
    //todo @PathVariable(value="id")
    @RequestMapping("/select/{id}")
    public List<Attendance> select(@PathVariable(value="id") int school_id) {
        return testService.select(school_id);
    }
}
