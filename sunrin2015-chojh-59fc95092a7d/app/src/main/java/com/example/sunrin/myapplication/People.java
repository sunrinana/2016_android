package com.example.sunrin.myapplication;

import com.orm.SugarRecord;

/**
 * Created by Sunrin on 2015-12-23.
 */
public class People extends SugarRecord {

    private String number;
    private String name;

    public People()
    {


    }
    public People(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
