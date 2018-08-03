package com.zthack.drip.init;

import com.zthack.drip.model.constent.DripConst;
import com.zthack.drip.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 系统初始化操作
 *
 * Created by LiChao on 2018/8/3.
 */
@Configuration
public class DripInit implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private SettingService settingService;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        //加载系统配置项
        initSettings();
    }

    /**
     * 加载系统配置
     */
    private void initSettings() {
        Map<String, String> settings = settingService.findAllSettings();
        if (settings != null && settings.size() > 0) {
            DripConst.SETTINGS = settings;
        }
    }
}
