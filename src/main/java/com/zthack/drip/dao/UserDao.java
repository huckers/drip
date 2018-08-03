package com.zthack.drip.dao;

import com.zthack.drip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LiChao on 2018/7/30.
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
