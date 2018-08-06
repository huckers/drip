package com.zthack.drip.controller;

import com.zthack.drip.model.Post;
import com.zthack.drip.model.constent.DripConst;
import com.zthack.drip.service.PostService;
import com.zthack.drip.utils.DripUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章控制层
 *
 * Created by LiChao on 2018/8/3.
 */
@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 文章详情页
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(value = "/{id}")
    public String postById (@PathVariable(value = "id") Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        return DripUtil.themePath(DripConst.POST);
    }
}
