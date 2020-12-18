package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Mapper.one.source;
import com.example.dailyReport.Mapper.two.target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Params: async date from remote
 * @Author: Siya(Xiran) Yan
 * @Date: 11:17 15/12/20
 */
@Service
public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AttendService.class);
    @Autowired(required=false)
    private source sourceData;
    @Autowired(required=false)
    private target targetData;

/*    List<Attendance> attendances = new ArrayList<>();
    List<Attend> attends = new ArrayList<>();*/
    //必须要这样写start end
    @Async
    public void selectRecentSourceAttendance(int school_id, Timestamp date, int num, List<Attendance> attendances, List<Attend> attends) {
        int page=(num/1000)+1;
        int start=0;
        int limit=1000;
        for (int i = 0; i < page; i++) {
            logger.info("start:"+i*1000+"end:"+(int)(i*1000+1000));
            start=i*1000;
            //todo maybe need
           /* if (i == page - 1) {
                limit=num;
            }*/
            attends.addAll(transfers(sourceData.pageSelectAttend(school_id,date,start,limit)));
            logger.info("transferNow:"+attends.size());
        }
    }
    @Async
    public void pageInsertAttends(int page, List<Attend> attends) throws InterruptedException {
        while (attends.size()==0) {
            logger.info("sleep2");
            Thread.sleep(1000);
        }
        for (int i = 0; i < page; i++) {
            while (attends.size() < (i + 1) * 1000) {
                Thread.sleep(500);
            }
            if (i == page - 1) {
                targetData.insertAttends(attends.subList(i * 1000, attends.size() - 1));
            } else {
                targetData.insertAttends(attends.subList(i*1000,((i+1)*1000)-1));
            }
            logger.info("insertNow:");
        }
    }

    public List<Attend> transfers(List<Attendance> attendances) {
        List<Attend> attends = new ArrayList<>();
        for (Attendance attendance : attendances) {
            attends.add(transfer(attendance));
        }
        return  attends;
    }

    public Integer selectPersonId (String student_no)
    {
        return targetData.selectPersonId(student_no);
    }

    public List<Integer> selectPersonIds (List<String> persons) {
        List<Integer> personIds = new ArrayList<>();
        for (String personId : persons) {
            personIds.add(selectPersonId(personId));
        }
        return personIds;
    }

    public Attend transfer(Attendance attendance) {
        Attend attend = new Attend();
        //System.out.println(attendance.getStudent_no());
        attend.setPerson_id(selectPersonId(attendance.getStudent_no())==null ? -1:selectPersonId(attendance.getStudent_no()));
        if (attendance.getClass_name().length() < 8) {
            attend.setClass_id(selectClassIdByPerson(attend.getPerson_id())==null ? -1:selectClassIdByPerson(attend.getPerson_id()));
        } else {
            attend.setClass_id(selectClassIdByName(attendance.getClass_name()));
        }
        if(attendance.getAttend_status()==2||attendance.getAttend_status()==6||attendance.getAttend_status()==8)
            attend.setAttend_status(1);
        else if(attendance.getAttend_status()==3)
            attend.setAttend_status(2);
        else if(attendance.getAttend_status()==7)
            attend.setAttend_status(3);
        else attend.setAttend_status(0);

        attend.setAttend_time((String.valueOf(attendance.getAttend_time().getTime()/1000)));
//        logger.info("timestrapt"+attend.getAttend_time());
        attend.setSchool_id(1);
        attend.setPerson_name(attendance.getStudent_name());
        attend.setAttend_id(attendance.getAttend_id());
        return attend;

        /* 考勤状态：0.正常 1请假 2迟到 3缺勤*/
        /*出勤情况：1：正常2：事假3：迟到6：病假7：缺卡8：请假*/
    }

    public Integer selectClassIdByPerson (Integer person_id) {
        return targetData.selectClassIdByPerson(person_id);
    }

    public Integer selectClassIdByName (String student_class) {
        //todo write into xml
        String type = student_class.substring(5, 7);
        int stage=0;
        String class_name=student_class;
        if (type.equals("初中")) {
            class_name=student_class.replace("初中","");
            stage=2;
        } else if (type.equals("高中")) {
            class_name=student_class.replace("高中","");
            stage=3;
        }
        return targetData.selectClassIdByName(class_name, stage);
        //logger.info(""+class_name+stage);

        /*List<Student> students*/
    }

    public List<Integer> selectClassIds (List<String> studentClasses) {
        List<Integer> classIds = new ArrayList<>();
        for (String classId : studentClasses) {
            classIds.add(selectClassIdByName(classId));
        }
        return classIds;
    }

    public List<Attendance> selectAttendance(int school_id,Timestamp date) {
        return sourceData.selectAttend(school_id,date);
    }
    public List<Attend> selectAttends(int school_id,Timestamp date) {
        return transfers(sourceData.selectAttend(school_id,date));
    }
    /*
    @Async
    public void transferAttend(int num,List<Attend> attends ,List<Attendance> attendances) throws InterruptedException {
        logger.info("intrans");
        //Thread.sleep(100);
        for (int i = 0; i < num; i++) {
            while (attendances.get(i)==null) {
                logger.info("sleep1"+attendances.size()+"i："+i);
                Thread.sleep(500);
            }
            logger.info("transferALL"+attends.size());
            attends.add(transfer(attendances.get(i)));
        }
        */
/*for (Attendance attendance : attendances) {
            attends.add(transfer(attendance));
        }*//*

    }
*/
}
