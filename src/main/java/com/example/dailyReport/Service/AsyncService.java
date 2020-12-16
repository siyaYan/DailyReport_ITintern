package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Mapper.one.source;
import com.example.dailyReport.Mapper.two.target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AttendService.class);
    @Autowired(required=false)
    private source sourceData;
    @Autowired(required=false)
    private target targetData;

    public boolean insert(Attend attend) {
        return targetData.insertAttend(attend);
    }
    public void insertAttend (List<Attend> attends) {
        for (Attend attend : attends) {
            insert(attend);
        }
    }

    public List<Attend> selectAttend(int school_id)
    {
        List<Attendance> attendances= selectAttendance(school_id);
        List<Attend> attends = new ArrayList<>();
        for (Attendance attendance : attendances) {
            attends.add(transfer(attendance));
        }
        attendances=null;
        return attends;
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
        attend.setPerson_id(selectPersonId(attendance.getStudent_no()));
        if (attendance.getClass_name().length() < 8) {
            attend.setClass_id(selectClassIdByPerson(attend.getPerson_id()));
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
        /*logger.info("timestrapt"+attend.getAttend_time());*/
        attend.setSchool_id(attendance.getSchool_id());
        attend.setPerson_name(attendance.getStudent_name());
        attend.setAttend_id(attendance.getAttend_id());
        return attend;

        /* 考勤状态：0.正常 1请假 2迟到 3缺勤*/
        /*出勤情况：1：正常2：事假3：迟到6：病假7：缺卡8：请假*/
    }

    public Integer selectClassIdByPerson (Integer person_id) {
        //todo write into xml
        return targetData.selectClassIdByPerson(person_id);
        //logger.info(""+class_name+stage);

        /*List<Student> students*/
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
    public List<Attend> selectRecentSourceAttend(int school_id,int timestapt) {
        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date((long)timestapt * 1000L));
        System.out.println(timestapt+"10位数的时间戳（秒）--->Date:" + result1);
        Date date = new Date((long)timestapt*1000);
        List<Attendance> attendances= selectRecentSourceAttendance(school_id,date);
        logger.info("??"+date);
        System.out.println(new Date(timestapt));
        List<Attend> attends = new ArrayList<>();
        for (Attendance attendance : attendances) {
            attends.add(transfer(attendance));
        }
        //attendances=null;
        return attends;
    }

    public List<Attendance> selectRecentSourceAttendance(int school_id,Date date) {
        return sourceData.selectRecentAttend(school_id,date);
    }
    public List<Attendance> selectAttendance(int school_id) {
        /*logger.info(""+school_id);
        logger.info(""+sourceData.selectAttend(school_id).get(0).getAttend_status());*/
        return sourceData.selectAttend(school_id);
    }
}
