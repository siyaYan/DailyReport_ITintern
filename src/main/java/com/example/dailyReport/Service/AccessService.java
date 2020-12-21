package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.Access;
import com.example.dailyReport.Bean.ConsumeApi;
import com.example.dailyReport.Mapper.two.target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Params: access service
 * @Author: Siya(Xiran) Yan
 * @Date: 10:29 21/12/20
 */
@Service
public class AccessService {
    @Autowired(required = false)
    private target targetData;
    @Autowired
    private DateTranferService dateTranferService;
    public List<Access> getAccess(int school_id, int start, int end) {
        int day = ((end - start) % 86400 == 0) ? (end - start) / 86400 : (end - start) / 86400 + 1;
        System.out.println(day);
        List<Access> accessList = new ArrayList<>();
        for (int i = 0; i < day; i++) {
            Access access = new Access();
            access.setEnter_sum(targetData.selectDayAccess(school_id,start+(i*86400),1));
            access.setExit_sum(targetData.selectDayAccess(school_id,start+(i*86400),0));
            access.setDate(dateTranferService.dateIntTranferString(start+(i*86400)));
            accessList.add(access);
        }
        return accessList;
    }
}
