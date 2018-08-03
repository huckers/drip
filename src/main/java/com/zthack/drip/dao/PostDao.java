package com.zthack.drip.dao;

import com.zthack.drip.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LiChao on 2018/7/30.
 */
public interface PostDao extends JpaRepository<Post, Long> {
}
