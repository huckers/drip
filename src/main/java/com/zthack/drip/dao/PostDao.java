package com.zthack.drip.dao;

import com.zthack.drip.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by LiChao on 2018/7/30.
 */
public interface PostDao extends JpaRepository<Post, Long> {

    /**
     * 分页查询有效文章
     *
     * @param b
     * @param pageable
     * @return
     */
    List<Post> findByFlag(boolean b, Pageable pageable);
}
