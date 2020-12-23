package com.example.dailyReport.Bean;
/**
* 
* @Params: access
* @Author: Siya(Xiran) Yan 
* @Date: 17:13 23/12/20
*/
public class Access {
    private int access_id;
    private int person_id;
    private  String person_name;
    private  String card_number;
    private  String position;
    private  int access_type;
    private  int access_time;
    private  int school_id;

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setAccess_id(int access_id) {
        this.access_id = access_id;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public void setAccess_time(int access_time) {
        this.access_time = access_time;
    }

    public void setAccess_type(int access_type) {
        this.access_type = access_type;
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getPosition() {
        return position;
    }

    public int getSchool_id() {
        return school_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public int getAccess_id() {
        return access_id;
    }

    public int getAccess_type() {
        return access_type;
    }

    public int getAccess_time() {
        return access_time;
    }

    public String getCard_number() {
        return card_number;
    }
}
