package com.example.dailyReport.Bean;

/**
* 
* @Params: add table consume construction
* @Author: Siya(Xiran) Yan 
* @Date: 15:49 22/12/20
*/
public class Consume {
    private int person_id;
    private String person_name;
    private int card_number;
    private int account;
    private String position;
    private int type;
    private int amount;
    private int consume_time;

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setConsume_time(int consume_time) {
        this.consume_time = consume_time;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPerson_name() {
        return person_name;
    }

    public int getCard_number() {
        return card_number;
    }

    public int getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public String getPosition() {
        return position;
    }

    public int getConsume_time() {
        return consume_time;
    }

    public int getPerson_id() {
        return person_id;
    }

    public int getAccount() {
        return account;
    }
}
