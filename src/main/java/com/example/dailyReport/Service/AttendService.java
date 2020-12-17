package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.AttendApi;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Mapper.one.source;
import com.example.dailyReport.Mapper.two.target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
*
* @Params: add lots of methods need to be refactor
* @Author: Siya(Xiran) Yan
* @Date: 11:17 15/12/20
*/
@Service
public class AttendService {
    private static final Logger logger = LoggerFactory.getLogger(AttendService.class);
    @Autowired(required=false)
    private source sourceData;
    @Autowired(required=false)
    private target targetData;

    @Autowired
    AsyncService asyncService;

    public List<Attend> selectRecentTargetAttend(int school_id,int timestapt) {
        return targetData.selectRecentAttend(school_id,timestapt);
    }


    public AttendApi getAttendApi(int school_id,int date) {
        AttendApi api = new AttendApi();
        api.setDate(date);
        api.setSchool_id(school_id);
        api.setStudent_num(studentNum(school_id));
        api.setTeacher_num(teacherNum(school_id));
        api.setAttend_abnormal_sum(abnormalNum(school_id,date));
        api.setAttend_abnormal_rate(abnormalRate(school_id,date));
        api.setAttend_change(attendChange(school_id,date));
//        logger.info(api.getStudent_num()+"");
        return api;
    }
    public Integer studentNum(int school_id) {
        return targetData.personNum(school_id,1);
    }
    public Integer teacherNum(int school_id ) {
        return targetData.personNum(school_id,2);
    }
    public Integer abnormalNum(int school_id,int date) {
        return targetData.abnormalNum(school_id, date);
    }
    public String abnormalRate(int school_id,int date) {
        String abnormalRate="0";
        if (targetData.abnormalNum(school_id, date) > 0) {
            float rate=(float) targetData.abnormalNum(school_id, date)/studentNum(school_id);
            abnormalRate=String.valueOf(rate);
        }
         return abnormalRate;
    }
    public Integer attendChange(int school_id,int date) {
        int today=targetData.abnormalNum(school_id, date);
        int yesterday=targetData.abnormalNum(school_id, date-86400);
        int change=today-yesterday;
        return change;
        /*logger.info(new Date(date*1000L)+"");
        logger.info(new Date((date+86400)*1000L)+"");*/
    }
}
