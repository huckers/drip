package com.zthack.drip.controller;

import com.zthack.drip.model.User;
import com.zthack.drip.model.constent.DripConst;
import com.zthack.drip.model.dto.JsonResponse;
import com.zthack.drip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 后台管理控制层
 * <p>
 * Created by LiChao on 2018/8/1.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @GetMapping(value = {"", "/login"})
    public String login(HttpSession session) {
        User user = (User) session.getAttribute(DripConst.USER_SESSION_KEY);
        //如果session存在，跳转到后台首页
        if (null != user) {
            return "/admin/admin_index";
        }
        return "admin/admin_login";
    }

    /**
     * 登录验证
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping(value = "/doLogin")
    @ResponseBody
    public JsonResponse doLogin(@ModelAttribute("username") String username,
                                @ModelAttribute("password") String password,
                                HttpSession session) {
        User user = userService.findByUsername(username, password);
        if (null != user) {
            //登录成功
            session.setAttribute(DripConst.USER_SESSION_KEY, user);
            return new JsonResponse(DripConst.RES_SUCCESS, "登录成功!");
        } else {
            //账号或密码错误
            return new JsonResponse(DripConst.RES_FAIL, "账号或密码错误!");
        }
    }

    /**
     * 后台管理首页
     *
     * @param session
     * @param model
     * @return
     */
    @GetMapping(value = "/index")
    public String index(HttpSession session, Model model) {
        User user = (User) session.getAttribute(DripConst.USER_SESSION_KEY);
        //如果session存在，跳转到后台首页
        if (null != user) {
            model.addAttribute("user", user);
            return "/admin/admin_index";
        }
        return "redirect:/admin";
    }

    /**
     * 登出
     *
     * @param session
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin";
    }

}
