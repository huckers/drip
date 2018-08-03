package com.zthack.drip.controller;

import com.zthack.drip.model.Post;
import com.zthack.drip.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LiChao on 2018/7/30.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private PostService postService;

    @RequestMapping(name = "/list")
    public String list () {
        List<Post> list = postService.findAll();

        String name = "admin";
        return name + list.size() + "，欢迎您！";
    }
}
