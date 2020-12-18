package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.ConsumeApi;
import com.example.dailyReport.Service.AttendService;
import com.example.dailyReport.Service.ConsumeService;
import com.example.dailyReport.Service.DateTranferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
*
* @Params: intial consume
* @Author: Siya(Xiran) Yan
* @Date: 10:19 18/12/20
*/
@RestController
@RequestMapping("/consume")
public class ConsumeApiController {
    @Autowired
    private ConsumeService consumeService;
    @Autowired
    private DateTranferService dateTranferService;
    @RequestMapping("/api/{id}/{date}")
    public ConsumeApi getDayConsume(@PathVariable(value="id") int school_id, @PathVariable(value="date") String date) throws ParseException {
        return consumeService.getSumAndChange(school_id,dateTranferService.dateStringTranferInt(date));
    }
    @RequestMapping("/api/{id}/{start}/{end}")
    public List<ConsumeApi> getConsumes(@PathVariable(value="id") int school_id, @PathVariable(value="start") String start, @PathVariable(value="end") String end) throws ParseException {
        return consumeService.getConsumes(school_id,dateTranferService.dateStringTranferInt(start),dateTranferService.dateStringTranferInt(end));
    }
}
