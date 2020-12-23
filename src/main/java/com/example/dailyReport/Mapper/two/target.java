package com.example.dailyReport.Mapper.two;

import com.example.dailyReport.Bean.Attend;
import com.example.dailyReport.Bean.AttendAbnormal;
import com.example.dailyReport.Bean.Person;
import com.example.dailyReport.Bean.Teacher;
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

    Boolean insertAttends(@Param("list") List<Attend> list);

    Integer selectClassIdByName (String student_class,int stage);
    Integer selectClassIdByPerson (int person_id);

    Person selectPersonByThirdNo (String third_no);

    Integer personNum(@Param("school_id") int school_id,@Param("type") int type);

    Integer abnormalNum(@Param("school_id") int school_id, @Param("date") int date);


    List<Attend> selectDayAttend(@Param("school_id") int school_id, @Param("date") int date);
    /*consume*/
    List<Integer> selectDayConsume(@Param("school_id") int school_id, @Param("date") int date,@Param("type") int type);
    List<String> selectConsumePlaces(@Param("school_id") int school_id, @Param("date") int date);
    Integer countConsumePlace(@Param("school_id") int school_id, @Param("date") int date,@Param("position") String position);
    /*teacher*/
    List<Teacher> selectTeachers(@Param("school_id") int school_id,@Param("date") int date);
    Integer countTeacherCourse(@Param("school_id") int school_id,@Param("date") int date,@Param("teacher_id") int teacher_id);

    /*subject*/
    List<String> selectSubjects(@Param("school_id") int school_id,@Param("date") int date);

    List<String> selectSubjectTeachers(@Param("school_id") int school_id,@Param("date") int date,@Param("subject_name") String subject_name);

    Integer selectDayAccess(@Param("school_id") int school_id, @Param("date") int date,@Param("access_type") int access_type);

    Boolean insertWords(@Param("school_id") int school_id, @Param("keyword") String keyword,@Param("num") int num);
}
