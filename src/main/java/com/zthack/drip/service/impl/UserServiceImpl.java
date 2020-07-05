package com.zthack.drip.service.impl;

import com.zthack.drip.dao.UserDao;
import com.zthack.drip.model.User;
import com.zthack.drip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiChao on 2018/8/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
