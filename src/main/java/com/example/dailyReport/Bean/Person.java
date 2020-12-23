package com.example.dailyReport.Bean;

//todo need to be refactor
public class Person {
    private int person_id;
    private int person_type;
    private String third_no;
    private String real_name;
    private int school_id;

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setPerson_type(int person_type) {
        this.person_type = person_type;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public void setThird_no(String third_no) {
        this.third_no = third_no;
    }

    public int getSchool_id() {
        return school_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public int getPerson_type() {
        return person_type;
    }

    public String getThird_no() {
        return third_no;
    }

    public String getReal_name() {
        return real_name;
    }
}
