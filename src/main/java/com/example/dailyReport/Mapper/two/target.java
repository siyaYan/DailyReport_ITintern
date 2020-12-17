package com.example.dailyReport.Mapper.two;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface target {
    //todo target 里的时间戳是10位
    Boolean insertAttend (Attend attend);
    Boolean insertAttends (@Param("list") List<Attend> list);
    Integer selectClassIdByName (String student_class,int stage);
    Integer selectClassIdByPerson (int person_id);
    Integer selectPersonId (String student_no);
    Integer personNum(@Param("school_id") int school_id,@Param("type") int type);
    Integer abnormalNum(@Param("school_id") int school_id,@Param("date") int date);
    List<Attend> selectRecentAttend (@Param("school_id") int school_id, @Param("date") int date);
}
