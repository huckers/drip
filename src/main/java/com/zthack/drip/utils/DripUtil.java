package com.zthack.drip.utils;

import com.zthack.drip.model.constent.DripConst;
import org.springframework.util.StringUtils;

/**
 * Created by LiChao on 2018/8/6.
 */
public class DripUtil {

    /**
     * 根据模板获取路径
     *
     * @param fileName
     * @return
     */
    public static String themePath (String fileName) {

        if (StringUtils.isEmpty(DripConst.SETTINGS.get("theme_path"))) {
            return "themes/" + DripConst.THEME_DEFAULT + "/" + fileName;
        } else {
            return "themes/" + DripConst.SETTINGS.get("theme_path") + "/" + fileName;
        }
    }
}
