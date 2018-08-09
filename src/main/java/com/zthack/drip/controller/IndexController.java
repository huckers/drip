package com.zthack.drip.controller;

import com.zthack.drip.model.constent.DripConst;
import com.zthack.drip.service.PostService;
import com.zthack.drip.utils.DripUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制层
 * <p>
 * Created by LiChao on 2018/8/2.
 */
@Controller
public class IndexController {

    @Autowired
    private PostService postService;

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "/index"})
    public String index(Model model) {

        //根据文章修改时间倒序排列
        Sort sort = new Sort(Sort.Direction.DESC, "modifyDate");

        Integer page = 1;
        //默认分页条数
        Integer pageSize = 5;
        //加载设置选项，用于设置分页条数
        if (!StringUtils.isEmpty(DripConst.SETTINGS.get("index.page.size"))) {
            pageSize = Integer.parseInt(DripConst.SETTINGS.get("index.page.size"));
        }
        Pageable pageable = PageRequest.of(page - 1, pageSize, sort);
        model.addAttribute("posts", postService.findByFlag(pageable));

        return DripUtil.themePath(DripConst.INDEX);
    }

    /**
     * 关于
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/about")
    public String about(Model model) {
        return DripUtil.themePath(DripConst.ABOUT);
    }

    /**
     * 留言
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/message")
    public String message(Model model) {
        return DripUtil.themePath(DripConst.MESSAGE);
    }

    /**
     * 评论
     *
     * @return
     */
    @GetMapping(value = "/comment")
    public String comment(Model model) {
        return DripUtil.themePath(DripConst.COMMENT);
    }
}
