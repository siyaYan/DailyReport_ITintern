package com.example.dailyReport.Mapper.one;

import com.example.dailyReport.Bean.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface source {
    List<Attendance> selectAttend (int school_id);
    List<Attendance> selectRecentAttend (@Param("school_id") int school_id, @Param("date") Date date);
}
