package com.example.dailyReport.Mapper.two;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.AttendAbnormal;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *
 * @Params: target SQL
 * @Author: Siya(Xiran) Yan
 * @Date: 11:14 14/12/20
 */
public interface target {
    /* * note target 里的时间戳是10位 * */
    Integer selectTypeSum(@Param("school_id") int school_id,@Param("date")int date,@Param("class_id") int class_id,@Param("type") int type);
    List<Integer> selectAbnormalClassId(@Param("school_id") int school_id, @Param("date")int date) ;
    AttendAbnormal selectAbnormalClass(@Param("school_id") int school_id,@Param("class_id") int class_id);
    Boolean insertAttends (@Param("list") List<Attend> list);
    Integer selectClassIdByName (String student_class,int stage);
    Integer selectClassIdByPerson (int person_id);
    Integer selectPersonId (String student_no);
    Integer personNum(@Param("school_id") int school_id,@Param("type") int type);
    Integer abnormalNum(@Param("school_id") int school_id,@Param("date") int date);
    List<Attend> selectDayAttend(@Param("school_id") int school_id, @Param("date") int date);
    List<Integer> selectDayConsume(@Param("school_id") int school_id, @Param("date") int date,@Param("type") int type);
    List<String> selectConsumePlaces(@Param("school_id") int school_id, @Param("date") int date);
    Integer countConsumePlace(@Param("school_id") int school_id, @Param("date") int date,@Param("position") String position);
}
