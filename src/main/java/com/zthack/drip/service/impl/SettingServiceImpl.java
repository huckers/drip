package com.zthack.drip.service.impl;

import com.zthack.drip.dao.SettingsDao;
import com.zthack.drip.model.Settings;
import com.zthack.drip.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiChao on 2018/8/3.
 */
@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingsDao settingsDao;

    /**
     * 获取所有系统配置项
     *
     * @return
     */
    @Override
    public Map<String, String> findAllSettings() {
        List<Settings> list =  settingsDao.findAll();
        Map<String, String> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(setting -> map.put(setting.getSetName(), setting.getSetValue()));
        }
        return map;
    }
}
