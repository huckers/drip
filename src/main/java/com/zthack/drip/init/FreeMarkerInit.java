package com.zthack.drip.init;

import com.zthack.drip.service.SettingService;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 加载系统配置
 * <p>
 * Created by LiChao on 2018/8/14.
 */
@Configuration
public class FreeMarkerInit {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private SettingService settingService;

    /**
     * @PostConstruct 注解
     * 在服务器加载Servlet的时候运行
     * 只会被服务器调用一次，在构造函数之后，init()方法之前运行
     */
    @PostConstruct
    public void setSharedVariable() {
        try {
            configuration.setSharedVariable("settings", settingService.findAllSettings());
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
    }
}
