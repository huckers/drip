package com.zthack.drip.model.constent;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共常量
 *
 * Created by LiChao on 2018/8/3.
 */
public class DripConst {

    /**
     * user_session
     */
    public static String USER_SESSION_KEY = "userSession";

    /**
     * 系统配置项
     */
    public static Map<String, String> SETTINGS = new HashMap<>();

    /**
     * 默认前端主题
     */
    public static String THEME_DEFAULT = "default";

    /**
     * 首页文件名称
     */
    public static String INDEX = "index";

    /**
     * 文章模板名称
     */
    public static String POST = "post";

    /**
     * 关于模板名称
     */
    public static String ABOUT = "about";

    /**
     * 评论
     */
    public static String COMMENT = "comment";

    /**
     * 留言
     */
    public static String MESSAGE = "message";
}
