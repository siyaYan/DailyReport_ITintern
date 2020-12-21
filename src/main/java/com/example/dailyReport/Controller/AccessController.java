package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.Access;
import com.example.dailyReport.Service.AccessService;
import com.example.dailyReport.Service.DateTranferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @Params: access controller
 * @Author: Siya(Xiran) Yan
 * @Date: 10:29 21/12/20
 */
@RestController
@RequestMapping("/access")
public class AccessController {
    @Autowired
    private AccessService accessService;
    @Autowired
    private DateTranferService dateTranferService;
    @RequestMapping("/api/{id}/{start}/{end}")
    public List<Access> getAccess(@PathVariable(value = "id") int school_id,@PathVariable(value = "start")String start,@PathVariable(value = "end")String end) throws ParseException {
        return accessService.getAccess(school_id, dateTranferService.dateStringTranferInt(start), dateTranferService.dateStringTranferInt(end));
    }
}
