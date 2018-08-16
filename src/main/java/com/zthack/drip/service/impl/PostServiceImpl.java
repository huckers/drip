package com.zthack.drip.service.impl;

import com.zthack.drip.dao.CommentDao;
import com.zthack.drip.dao.PostDao;
import com.zthack.drip.model.Comment;
import com.zthack.drip.model.Post;
import com.zthack.drip.service.PostService;
import com.zthack.drip.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by LiChao on 2018/8/1.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;


    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    /**
     * 分页查询有效文章
     *
     * @param pageable
     * @return
     */
    @Override
    public List<Post> findByFlag(Pageable pageable) {
        return postDao.findByFlag(true, pageable);
    }

    /**
     * 根据id获取文章
     *
     * @param id
     * @return
     */
    @Override
    public Post findPostById(Long id) {
        Post one = postDao.getOne(id);
        //阅读量+1
        one.setViewCount(one.getViewCount()+1);
        Post post = postDao.save(one);
        return post;
    }

    /**
     * 文章点赞
     *
     * @param id
     */
    @Override
    public Post postLike(Long id) {

        Post post = postDao.getOne(id);
        post.setLikeCount(post.getLikeCount() == null ? 1 : post.getLikeCount()+1);

        postDao.save(post);
        return post;
    }

    /**
     * 保存评论
     *
     * @param comment
     * @return
     */
    @Override
    public Boolean save(Comment comment) {
        comment.setCreateDate(new Date());
        comment.setModifyDate(new Date());
        comment.setLikeCount(0);
        comment.setId(IDUtil.getId());
        try {
            commentDao.save(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
