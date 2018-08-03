package com.zthack.drip.dao;

import com.zthack.drip.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LiChao on 2018/7/30.
 */
public interface CommentDao extends JpaRepository<Comment, Long> {
}
