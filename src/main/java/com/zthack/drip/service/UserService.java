package com.zthack.drip.service;

import com.zthack.drip.model.User;

/**
 * Created by LiChao on 2018/8/2.
 */
public interface UserService {

    User findByUsername(String username, String password);

    User findByUsername(String username);
}
