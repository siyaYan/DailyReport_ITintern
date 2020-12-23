package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.Tconsume;
import com.example.dailyReport.Mapper.one.source;
import com.example.dailyReport.Mapper.two.target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TestService {
    private static final Logger logger = LoggerFactory.getLogger(AttendService.class);
    @Autowired(required=false)
    private source sourceData;
    @Autowired(required=false)
    private target targetData;
    public List<Tconsume> getTconsume(int school_id, Timestamp consume_time){
        return sourceData.selectConsume(school_id, consume_time);
    }

}
