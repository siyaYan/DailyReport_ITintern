package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Service.AsyncService;
import com.example.dailyReport.Service.AttendService;
import com.example.dailyReport.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @Params: ADD get classId and PersonId test
 * @Author: Siya(Xiran) Yan
 * @Date: 11:15 15/12/20
 */
@RestController
@RequestMapping("/test")

public class TestController {
    @Autowired
    private AsyncService asyncService;
    @Autowired
    private AttendService attendService;
    @Autowired
    private PageService pageService;
    @RequestMapping("/selectClassIds")
    public List<Integer> selectClassIds() {
        List<String> test = new ArrayList<>();
        test.add("2020级初中6班");
        test.add("2019级初中2班");
        test.add("2019级初中2班");
        return asyncService.selectClassIds(test);
    }
    @RequestMapping("/selectPersonIds")
    public List<Integer> selectPersonIds() {
        List<String> test = new ArrayList<>();
        test.add("C20170301");
        test.add("C20170320");
        test.add("C20170306");
        return asyncService.selectPersonIds(test);
    }

    @RequestMapping("/select/{id}/{date}")
    public List<Attendance> select(@PathVariable(value="id") int school_id, @PathVariable(value="date") String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.parse(date));
        return asyncService.selectAttendance(school_id,new Timestamp(simpleDateFormat.parse(date).getTime()));
    }

   /* @RequestMapping("/insert/{id}")
    public void insertAttend(@PathVariable(value="id") int school_id) {
        List<Attend> attends= asyncService.selectAttend(school_id);
        asyncService.insertAttend(attends);
        attends=null;
    }*/
    //@RequestMapping("/insertAttends/{id}")
    //10 test
   /* public List<Attend> insertAttends(@PathVariable(value="id") int school_id) throws InterruptedException {
        //List<Attend> attends= asyncService.selectAttend(school_id);
        List<Attend> attends = new ArrayList<>();
        for (int i=0;i<10;i++) {
            Attend attend = new Attend();
            attend.setAttend_id(i);
            attends.add(attend);
        }
        asyncService.insertAttends(attends);
        return attends;
    }*/
    @RequestMapping("/page1/{id}")
    //10 test
    public List<Attendance> pageTest1(@PathVariable(value="id") int school_id) {
        return pageService.pageTest1(school_id);
    }
    @RequestMapping("/page2/{id}")
    //10 test
    public List<Attend> pageTest2(@PathVariable(value="id") int school_id) {
        return pageService.pageTest2(school_id);
    }
    @RequestMapping("/async/{id}")
    //10 test
    public String setAsync(@PathVariable(value="id") int school_id) throws InterruptedException {

        return pageService.setAsync(school_id,null);
    }
    @RequestMapping("/attendapi/{id}/{date}")
    //10 test
    public List<Attend> attendApi(@PathVariable(value="id") int school_id,@PathVariable(value="date")int date) throws InterruptedException {
        return attendService.selectRecentTargetAttend(school_id,date);
    }


}
