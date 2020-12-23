package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Mapper.one.source;
import com.example.dailyReport.Mapper.two.target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int num=sourceData.countAttendance(school_id,date);
        List<Attendance> attendances = new ArrayList<>();
        List<Attend> attends = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int page=(num/1000)+1;
        asyncService.selectRecentSourceAttendance(school_id, date,num,attendances,attends);
        // asyncService.transferAttend(num,attends,attendances);
        asyncService.pageInsertAttends(page,attends);
        return "正在定时异步更新attend数据库......返回上一页面" + format.format(new Date());
    }

    public List<Attendance> selectRecentSourceAttendance(int school_id, Timestamp date) {
        List<Attend> attends = new ArrayList<>();
        List<Attendance> attendances = new ArrayList<>();
        int page=(int)(sourceData.countAttendance(school_id,date)/1000)+1;
        for (int i = 0; i < page; i++) {
            attendances.addAll(sourceData.pageSelectAttendance(school_id,date,page*1000,1000));
        }
        return attendances;
    }

    public List<Attend> pageTest2(int school_id) {
        List<Attend> attends = new ArrayList<>();
        List<Attendance> attendances = new ArrayList<>();
        attendances.addAll(sourceData.pageSelectAttendance(school_id,null,0,1000));
        attends.addAll(asyncService.transferAttends(attendances));
        return attends;
    }

    public List<Attendance> pageTest1(int school_id) {
        List<Attendance> attendances = new ArrayList<>();
        attendances.addAll(sourceData.pageSelectAttendance(school_id,null,0,1000));
        return attendances;
    }

}
