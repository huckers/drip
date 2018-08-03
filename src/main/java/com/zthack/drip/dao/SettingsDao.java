package com.zthack.drip.dao;

import com.zthack.drip.model.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LiChao on 2018/8/3.
 */
public interface SettingsDao extends JpaRepository<Settings, String> {
}
