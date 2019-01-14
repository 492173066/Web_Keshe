package com.cassie.zigbee_work.work;

import com.cassie.zigbee_dao.entity.User;

public interface Global {

    User login(Integer userNum,String userPassword);
    void changePassword(User user);

}
