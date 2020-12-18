package com.example.dailyReport.Mapper.one;

import com.example.dailyReport.Bean.Attendance;
import org.apache.ibatis.annotations.Param;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @Params: source SQL
 * @Author: Siya(Xiran) Yan
 * @Date: 11:14 14/12/20
 */
public interface source {
    List<Attendance> selectAttend ( @Param("school_id")int school_id, @Param("date") Timestamp date);
    List<Attendance> selectRecentAttend (@Param("school_id") int school_id, @Param("date") Timestamp date,@Param("startNum") int startNum,@Param("limit") int limit);
    Integer countRecentAttend(@Param("school_id") int school_id, @Param("date") Timestamp date);
}
