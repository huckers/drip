package com.zthack.drip.service;

import java.util.Map;

/**
 * Created by LiChao on 2018/8/3.
 */
public interface SettingService {

    /**
     * 获取所有系统配置项
     *
     * @return
     */
    Map<String,String> findAllSettings();
}
