package com.example.dailyReport.Bean;

import java.util.List;

/**
 *
 * @Params: course data
 * @Author: Siya(Xiran) Yan
 * @Date: 10:31 18/12/20
 */
public class CourseApi {
    private int sum;
    private List<Teacher> list;
    public CourseApi(int sum,List<Teacher> list) {
        this.sum=sum;
        this.list=list;
    }

    public void setList(List<Teacher> list) {
        this.list = list;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public List<Teacher> getList() {
        return list;
    }
}
