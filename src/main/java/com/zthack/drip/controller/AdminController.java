package com.zthack.drip.controller;

import com.zthack.drip.model.User;
import com.zthack.drip.model.dto.JsonResponse;
import com.zthack.drip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by LiChao on 2018/8/1.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"", "/login"})
    public String login() {
        return "admin/admin_login";
    }

    @PostMapping(value = "/doLogin")
    @ResponseBody
    public JsonResponse doLogin(@ModelAttribute("username") String username,
                                 @ModelAttribute("password") String password,
                                 HttpSession session) {
        User user = userService.findByUsername(username, password);
        if (null != user) {
            //登录成功
            session.setAttribute("user_session", user);
            return new JsonResponse(1, "登录成功!");
        } else {
            //账号或密码错误
            return new JsonResponse(1, "账号或密码错误!");
        }
    }

    @GetMapping(value = "/index")
    public String index (HttpSession session, Model model) {
        User user = (User) session.getAttribute("user_session");
        //如果session存在，跳转到后台首页
        if (null != user) {
            model.addAttribute("user", user);
            return "/admin/admin_index";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/logout")
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/admin";
    }

}
