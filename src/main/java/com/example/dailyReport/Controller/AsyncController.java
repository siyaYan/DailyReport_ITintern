package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Service.AsyncService;
import com.example.dailyReport.Service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
    /*@RequestMapping("/selectFromTarget/{id}/{date}")
    public List<Attend> selectRecentTargetAttend(@PathVariable(value="id") int school_id, @PathVariable(value="date") int date) {
        return asyncService.selectRecentTargetAttend(school_id,date);
    }*/
    //todo java heap space error
    /*@RequestMapping("/select/{id}")
    public List<Attend> selectAttend(@PathVariable(value="id") int school_id) {
        return asyncService.selectAttend(school_id);
    }*/
   /* @RequestMapping("/insert/{id}")
    public void insertAttend(@PathVariable(value="id") int school_id) {
        List<Attend> attends= asyncService.selectAttend(school_id);
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return pageService.setAsync(school_id,new Timestamp(simpleDateFormat.parse(date).getTime()));
    }
}
