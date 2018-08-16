package com.zthack.drip.service;

import com.zthack.drip.model.Comment;
import com.zthack.drip.model.Post;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by LiChao on 2018/8/1.
 */
public interface PostService {

    List<Post> findAll();

    /**
     * 分页查询有效文章
     *
     * @param pageable
     * @return
     */
    List<Post> findByFlag(Pageable pageable);

    /**
     * 根据id获取文章
     *
     * @param id
     * @return
     */
    Post findPostById(Long id);

    /**
     * 文章点赞
     *
     * @param id
     */
    Post postLike(Long id);

    /**
     * 保存评论
     *
     * @param comment
     * @return
     */
    Boolean save(Comment comment);
}
