package com.example.dailyReport.Bean;

/**
*
* @Params: attend table data(annotate position parameters)
* @Author: Siya(Xiran) Yan
* @Date: 11:14 15/12/20
*/

public class Attend {

    private int attend_id;
    private int school_id;
    private int class_id;
    private int person_id;
  /*  private String position;*/
    private String person_name;
    private int attend_status;
    private String attend_time;

    /*public Attend(int attend_id,int school_id,int class_id,int person_id,int attend_status,String person_name,String attend_time) {
        this.attend_id=attend_id;
        this.school_id=school_id;
        this.class_id=class_id;
        this.person_id=person_id;
        this.attend_status=attend_status;
        this.person_name=person_name;
        this.attend_time=attend_time;
    }*/

    public void setAttend_id(int attend_id) {
        this.attend_id = attend_id;
    }

    public void setAttend_status(int attend_status) {
        this.attend_status = attend_status;
    }

    public void setAttend_time(String attend_time) {
        this.attend_time = attend_time;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

/*    public void setPosition(String position) {
        this.position = position;
    }*/

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getAttend_id() {
        return attend_id;
    }

    public int getAttend_status() {
        return attend_status;
    }

    public String getAttend_time() {
        return attend_time;
    }

    public int getClass_id() {
        return class_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public int getSchool_id() {
        return school_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    /*public String getPosition() {
        return position;
    }*/
}
