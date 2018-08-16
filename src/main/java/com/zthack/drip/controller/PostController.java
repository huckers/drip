package com.zthack.drip.controller;

import com.zthack.drip.model.Comment;
import com.zthack.drip.model.Post;
import com.zthack.drip.model.constent.DripConst;
import com.zthack.drip.model.dto.JsonResponse;
import com.zthack.drip.service.PostService;
import com.zthack.drip.utils.DripUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 文章控制层
 * <p>
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
    public String postById(@PathVariable(value = "id") Long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        return DripUtil.themePath(DripConst.POST);
    }

    /**
     * 文章点赞
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/postLike/{id}")
    @ResponseBody
    public JsonResponse postLike(@PathVariable(value = "id") Long id) {
        Post post = postService.postLike(id);
        return new JsonResponse(DripConst.RES_SUCCESS, post.getLikeCount());
    }

    /**
     * 文章评论
     *
     * @param postId
     * @param nickName
     * @param content
     * @return
     */
    @PostMapping(value = "/comment")
    @ResponseBody
    public JsonResponse comment(Long postId, String nickName, String content) {
        Comment comment = new Comment();
        comment.setNickName(nickName);
        comment.setContent(content);
        Post post = new Post();
        post.setId(postId);
        comment.setPost(post);
        Boolean b = postService.save(comment);
        if (b) {
            return new JsonResponse(DripConst.RES_SUCCESS, "发表成功！", comment);
        } else {
            return new JsonResponse(DripConst.RES_FAIL, "发表失败！");
        }

    }

}
