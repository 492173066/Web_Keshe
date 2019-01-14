package com.cassie.zigbee_dao.entity;

import java.util.Random;

public class User {

    private Integer userNum;
    private String userName;
    private String userPassword;
    private String userPhone;

    public User(){
        super();
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    /**
     * 数据库补丁措施
     * @param flag

    public User(boolean flag){
        super();
        Random random = new Random(10000000);
        userNum = ""+random.nextInt();
    }
     */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
