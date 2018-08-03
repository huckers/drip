package com.zthack.drip.service.impl;

import com.zthack.drip.dao.PostDao;
import com.zthack.drip.model.Post;
import com.zthack.drip.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiChao on 2018/8/1.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;


    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }
}
