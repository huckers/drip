package com.zthack.drip.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 分类
 * Created by hucker on 2018/8/25.
 */
@Data
@Entity
@Table(name = "drip_category")
public class Category implements Serializable {

    private static final long serialVersionUID = -1363150950763750173L;

    /**
     * id
     */
    @Id
    @Column(name = "cate_id")
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * 有效标识
     */
    @Column(name = "flag")
    private Boolean flag = true;

    /**
     * 分类名称
     */
    @Column(name = "cate_name")
    private String cateName;

    /**
     * 分类别名
     */
    @Column(name = "alias")
    private String alias;

    /**
     * 是否显示在导航
     */
    @Column(name = "is_nav")
    private Boolean isNav;

}
