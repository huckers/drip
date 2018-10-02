package com.zthack.drip.controller;

import com.zthack.drip.model.User;
import com.zthack.drip.model.constent.DripConst;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * Created by hucker on 2018/8/25.
 */
public class BaseController {

    @Autowired
    private HttpSession session;

    /**
     * 获取当前登录用户
     * @return
     */
    public User getContextUser() {
        return (User) session.getAttribute(DripConst.USER_SESSION_KEY);
    }

    /**
     * 判断是否admin登录
     * @return
     */
    public Boolean isLogin () {
        if (null == this.getContextUser()) {
            return false;
        } else {
            return true;
        }
    }
}
