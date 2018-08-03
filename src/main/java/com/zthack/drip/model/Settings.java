package com.zthack.drip.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 系统配置
 *
 * Created by LiChao on 2018/8/3.
 */
@Data
@Entity
@Table(name = "drip_settings")
public class Settings implements Serializable {

    private static final long serialVersionUID = -7953099428954638076L;
    /**
     * 配置名称
     */
    @Id
    @Column(name = "set_name")
    private String setName;

    /**
     * 配置值
     */
    @Column(name = "set_value")
    private String setValue;
}
