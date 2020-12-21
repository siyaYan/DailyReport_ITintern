package com.example.dailyReport.Controller;

import com.example.dailyReport.Bean.CourseApi;
import com.example.dailyReport.Bean.Subject;
import com.example.dailyReport.Service.CourseService;
import com.example.dailyReport.Service.DateTranferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @Params: course
 * @Author: Siya(Xiran) Yan
 * @Date: 10:19 18/12/20
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private DateTranferService dateTranferService;
    @RequestMapping("/time/{id}/{date}")
    public CourseApi getCourseTime(@PathVariable(value = "id")int school_id, @PathVariable(value = "date")String date) throws ParseException {
        return courseService.courseTimeApi(school_id, dateTranferService.dateStringTranferInt(date));
    }
    @RequestMapping("/subject/{id}/{date}")
    public List<Subject> getSubjectRate(@PathVariable(value = "id")int school_id, @PathVariable(value = "date")String date) throws ParseException {
        return courseService.subjectRateApi(school_id, dateTranferService.dateStringTranferInt(date));
    }
}
