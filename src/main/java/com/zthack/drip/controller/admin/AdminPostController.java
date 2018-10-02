package com.zthack.drip.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zthack.drip.controller.BaseController;
import com.zthack.drip.model.Post;
import com.zthack.drip.service.CategoryService;
import com.zthack.drip.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by hucker on 2018/8/25.
 */
@Controller
@RequestMapping(value = "/admin/post")
public class AdminPostController extends BaseController {

    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/list")
    public String posts(Model model) {
        if (!isLogin()) {
            return "redirect:/admin";
        }

        List<Post> list = postService.findAll();

        ObjectMapper mapper = new ObjectMapper();
        String posts = null;
        try {
            posts = mapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(posts);
        //文章分类
        model.addAttribute("cates", categoryService.findAll());
        model.addAttribute("posts", posts);
        return "admin/post/post_list";
    }
}
