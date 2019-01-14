package com.cassie.zigbee_work.impl;

import com.cassie.zigbee_dao.dao.UserDao;
import com.cassie.zigbee_dao.entity.User;
import com.cassie.zigbee_work.work.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("globalImpl")
public class GlobalImpl implements Global {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(Integer userNum, String userPassword) {
        User user = userDao.select(userNum);
        if (user != null && user.getUserPassword().equals(userPassword)){
            return user;
        }
        return null;
    }

    @Override
    public void changePassword(User user) {
        userDao.update(user);
    }
}
