package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Mapper.one.source;
import com.example.dailyReport.Mapper.two.target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @Params: select by page(large data)
 * @Author: Siya(Xiran) Yan
 * @Date: 11:17 17/12/20
 */
@Service
public class PageService {
    @Autowired(required=false)
    private source sourceData;
    @Autowired(required=false)
    private target targetData;

    @Autowired
    AsyncService asyncService;

    public String setAsync(int school_id, Timestamp date) throws InterruptedException {
        int num=sourceData.countRecentAttend(school_id,date);
        List<Attendance> attendances = new ArrayList<>();
        List<Attend> attends = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int page=(num/1000)+1;
        asyncService.selectRecentSourceAttendance(school_id, date,num,attendances,attends);
        // asyncService.transferAttend(num,attends,attendances);
        asyncService.insertAttends(page,attends);
        return "正在定时异步更新attend数据库......返回上一页面" + format.format(new Date());
    }
/*
    public List<Attendance> selectRecentSourceAttendance(int school_id, Date date) {
        List<Attend> attends = new ArrayList<>();
        List<Attendance> attendances = new ArrayList<>();
        int page=(int)(sourceData.countRecentAttend(school_id,date)/1000)+1;
        for (int i = 0; i < page; i++) {
            attendances.addAll(sourceData.selectRecentAttend(school_id,date,page*1000,1000));
        }
        return attendances;
    }
*/

    public List<Attend> pageTest2(int school_id) {
        List<Attend> attends = new ArrayList<>();
        List<Attendance> attendances = new ArrayList<>();
        attendances.addAll(sourceData.selectRecentAttend(school_id,null,0,1000));
//       System.out.println(attendances.size());
       /* for (Attendance attendance : attendances) {
            attends.add(asyncService.transfer(attendance));
        }*/
        attends.addAll(asyncService.transfers(attendances));
        return attends;
    }

    public List<Attendance> pageTest1(int school_id) {
        List<Attendance> attendances = new ArrayList<>();
        attendances.addAll(sourceData.selectRecentAttend(school_id,null,0,1000));
        return attendances;
    }

}
