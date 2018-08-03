package com.zthack.drip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LiChao on 2018/8/2.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"", "/index"})
    public String index () {
        return "themes/default/index";
    }
}
