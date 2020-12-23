package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.*;
import com.example.dailyReport.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
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
    private DateTranferService dateTranferService;
    @Autowired
    private PageService pageService;
    @Autowired
    private TestService testService;

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
        return asyncService.selectAttendance(school_id,dateTranferService.dateStringTranferTimestamp(date));
    }

    @RequestMapping("/selectAttends/{id}")
    public List<Attend> insertAttends(@PathVariable(value="id") int school_id) throws InterruptedException {
        List<Attend> attends= asyncService.selectAttends(school_id,null);
        return attends;
    }

    @RequestMapping("/page1/{id}")
    public List<Attendance> pageTest1(@PathVariable(value="id") int school_id) {
        return pageService.pageTest1(school_id);
    }

    @RequestMapping("/page2/{id}")
    public List<Attend> pageTest2(@PathVariable(value="id") int school_id) {
        return pageService.pageTest2(school_id);
    }

    @RequestMapping("/async/{id}")
    public String setAsync(@PathVariable(value="id") int school_id) throws InterruptedException {
        return pageService.setAttendAsync(school_id,null);
    }

    @RequestMapping("/attendapi/{id}/{date}")
    public List<Attend> attendApi(@PathVariable(value="id") int school_id,@PathVariable(value="date")int date) throws InterruptedException {
        return attendService.selectRecentTargetAttend(school_id,date);
    }
    ///test/tconsume/12/2020-12-22
    @RequestMapping("/tconsume/{id}/{date}")
    public List<Tconsume> getTconsume(@PathVariable(value="id") int school_id, @PathVariable(value="date")String date) throws InterruptedException, ParseException {
        return testService.getTconsume(school_id,dateTranferService.dateStringTranferTimestamp(date));
    }
    ///test/consume/12/2020-12-21
    @RequestMapping("/consume/{id}/{date}")
    public List<Consume> transConsume(@PathVariable(value="id") int school_id, @PathVariable(value="date")String date) throws InterruptedException, ParseException {
        return asyncService.transferConsumes(testService.getTconsume(school_id,dateTranferService.dateStringTranferTimestamp(date)));
    }
    ///test/insertconsume/12/2020-12-21
    @RequestMapping("/insertconsume/{id}/{date}")
    public Boolean insertConsumes(@PathVariable(value="id") int school_id, @PathVariable(value="date")String date) throws InterruptedException, ParseException {
        return asyncService.consumesService(school_id, dateTranferService.dateStringTranferTimestamp(date));
    }
}
