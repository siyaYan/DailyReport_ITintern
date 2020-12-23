package com.example.dailyReport.Controller;

import com.example.dailyReport.Service.AsyncService;
import com.example.dailyReport.Service.DateTranferService;
import com.example.dailyReport.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 *
 * @Params: ADD get classId and PersonId test
 * @Author: Siya(Xiran) Yan
 * @Date: 11:15 15/12/20
 */
@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;
    @Autowired
    private PageService pageService;
    @Autowired
    private DateTranferService dateTranferService;
    /*@RequestMapping("/selectFromTarget/{id}/{date}")
    public List<Attend> selectRecentTargetAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        return asyncService.selectRecentTargetAttend(school_id,date);
    }*/
    //todo java heap space error
    /*@RequestMapping("/select/{id}")
    public List<Attend> selectAttendance(@PathVariable(value="id") int school_id) {
        return asyncService.selectAttendance(school_id);
    }*/
   /* @RequestMapping("/insert/{id}")
    public void insertAttend(@PathVariable(value="id") int school_id) {
        List<Attend> attends= asyncService.selectAttendance(school_id);
        asyncService.insertAttend(attends);
        attends=null;
    }*/
    /*@RequestMapping("/insert/{id}/{date}")
    public void insertRecentAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        List<Attend> attends= asyncService.selectRecentSourceAttend(school_id,date);
        asyncService.insertAttend(attends);
        attends=null;
    }*/

    //todo test date async (2020-12-16)
    @RequestMapping("/{id}/{date}")
    public String setAsync(@PathVariable(value="id") int school_id,@PathVariable(value="date") String date) throws InterruptedException, ParseException {
        return pageService.setAttendAsync(school_id,dateTranferService.dateStringTranferTimestamp(date));
    }
}
