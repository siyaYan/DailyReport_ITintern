package com.example.dailyReport.Mapper.one;

import com.example.dailyReport.Bean.Attendance;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface source {
    List<Attendance> select (int school_id);
}
