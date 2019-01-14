package com.cassie.zigbee_dao.entity;

public class Sensor {

    private Integer id;
    private String time;
    private String temp;
    private String humi;
    private String light;

    public Sensor() {

    }

    public Sensor(String time, String temp, String humi, String light) {
        this.time = time;
        this.temp = temp;
        this.humi = humi;
        this.light = light;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumi() {
        return humi;
    }

    public void setHumi(String humi) {
        this.humi = humi;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }
}
