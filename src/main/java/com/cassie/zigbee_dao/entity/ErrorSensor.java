package com.cassie.zigbee_dao.entity;

public class ErrorSensor {

    private Integer id;
    private String error_time;
    private String error_temp;
    private String error_light;
    private String error_info;

    public ErrorSensor(){

    }

    public ErrorSensor(String error_time, String error_temp, String error_light, String error_info) {
        this.error_time = error_time;
        this.error_temp = error_temp;
        this.error_light = error_light;
        this.error_info = error_info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getError_time() {
        return error_time;
    }

    public void setError_time(String error_time) {
        this.error_time = error_time;
    }

    public String getError_temp() {
        return error_temp;
    }

    public void setError_temp(String error_temp) {
        this.error_temp = error_temp;
    }

    public String getError_light() {
        return error_light;
    }

    public void setError_light(String error_light) {
        this.error_light = error_light;
    }

    public String getError_info() {
        return error_info;
    }

    public void setError_info(String error_info) {
        this.error_info = error_info;
    }
}
