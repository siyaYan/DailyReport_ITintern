package com.example.dailyReport.Service;

import com.example.dailyReport.Bean.CourseApi;
import com.example.dailyReport.Bean.Subject;
import com.example.dailyReport.Bean.Teacher;
import com.example.dailyReport.Mapper.two.target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired(required = false)
    private target targetData;
    public CourseApi courseTimeApi(int school_id, int date) {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList=targetData.selectTeachers(school_id,date);
        int sum=0;
        int courseTime=0;
        for (Teacher teacher : teacherList) {
            courseTime=targetData.countTeacherCourse(school_id,date,teacher.getTeacher_id());
            teacher.setCourse_sum(courseTime);
            sum+=courseTime;
        }

        return new CourseApi(sum,teacherList);
    }
    public List<Subject> subjectRateApi(int school_id, int date) {
        List<Subject> subjectList = new ArrayList<>();
        List<String> subjects = new ArrayList<>();
        subjects=targetData.selectSubjects(school_id,date);
        for (String subject : subjects) {
            Subject subject1 = new Subject();
            subject1.setTeacher_sum(targetData.selectSubjectTeachers(school_id,date,subject).size());
            subject1.setSubject(subject);
            subject1.setRate(String.valueOf((float)subject1.getTeacher_sum()/(float)(targetData.selectTeachers(school_id,date).size())));
            subjectList.add(subject1);
        }
        return subjectList;
    }
}
