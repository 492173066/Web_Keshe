package com.cassie.zigbee_dao.dao;

import com.cassie.zigbee_dao.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {

    void insert(User user);
    void update(User user);
    void delete(Integer userNum);
    User select(Integer userNum);
    List<User> selectAll();

}
