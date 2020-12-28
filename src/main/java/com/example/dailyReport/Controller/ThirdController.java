package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Access;
import com.example.dailyReport.Bean.Word;
import com.example.dailyReport.Service.DateTranferService;
import com.example.dailyReport.Service.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
@RestController
@RequestMapping("/third")
public class ThirdController {
    @Autowired
    private ThirdPartyService thirdPartyService;
    @Autowired
    private DateTranferService dateTranferService;
    @RequestMapping("/word/{id}/{days}/{size}")
    public List<Word> wordApi(@PathVariable(value="id") int school_id, @PathVariable(value="days")int days, @PathVariable(value="size")int size) throws IOException {
        return thirdPartyService.getWordsData(school_id,days,size);
    }
    //http://localhost:8080/third/access/2020-2-18/2020-3-18
    @RequestMapping("/access/{start}/{end}")
    public List<Access> accessApi(@PathVariable(value="start") String start, @PathVariable(value="end") String end) throws ParseException {
        return thirdPartyService.getAccessData(dateTranferService.dateStringTranferInt(start),dateTranferService.dateStringTranferInt(end));
    }
    @RequestMapping("/access/insert/{start}/{end}")
    public boolean insertAccess(@PathVariable(value="start") String start,@PathVariable(value="end") String end) throws ParseException {
        return thirdPartyService.accessesService(dateTranferService.dateStringTranferInt(start), dateTranferService.dateStringTranferInt(end));
    }

}
