package com.cassie.zigbee_work.work;

import com.cassie.zigbee_dao.entity.User;

import java.util.List;

public interface UserWork {

    void add(User user);
    void edit(User user);
    void remove(Integer userNum);
    User get(Integer userNum);
    List<User> getAll();

}
