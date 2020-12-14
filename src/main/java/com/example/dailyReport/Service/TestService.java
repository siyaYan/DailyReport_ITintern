package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.Attendance;
import com.example.dailyReport.Mapper.one.source;
import com.example.dailyReport.Mapper.two.target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    private static final Logger logger = LoggerFactory.getLogger(TestService.class);
    @Autowired(required=false)
    private source sourceData;
    @Autowired(required=false)
    private target targetData;

    public boolean insert(Attendance attendance) {
        return targetData.insert(attendance);
    }
    public List<Attendance> select(int school_id) {
        logger.info(""+school_id);
        logger.info(""+sourceData.select(school_id).get(0).getStatus());
        return sourceData.select(school_id);
    }

}
