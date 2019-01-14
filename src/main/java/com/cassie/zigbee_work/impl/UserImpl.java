package com.cassie.zigbee_work.impl;

import com.cassie.zigbee_dao.dao.UserDao;
import com.cassie.zigbee_dao.entity.User;
import com.cassie.zigbee_work.work.UserWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userImpl")
public class UserImpl implements UserWork {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        user.setUserPassword("000");
        userDao.insert(user);

    }

    @Override
    public void edit(User user) {
        userDao.update(user);
    }

    @Override
    public void remove(Integer userNum) {
        userDao.delete(userNum);
    }

    @Override
    public User get(Integer userNum) {
        return userDao.select(userNum);
    }

    @Override
    public List<User> getAll() {
        return userDao.selectAll();
    }
}
