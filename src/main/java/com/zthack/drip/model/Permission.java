package com.zthack.drip.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Data
@Entity
@Table(name = "drip_permission")
public class Permission{

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * 资源名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 资源类型：0,1,2(目录,菜单,按钮)
     */
    @Column(name = "type")
    private String type;
    /**
     * 访问url地址
     */
    @Column(name = "url")
    private String url;
    /**
     * 权限代码,多个用逗号分隔
     * menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    @Column(name = "perms")
    private String perms;
    /**
     * 父节点id,一级节点为0
     */
    @Column(name = "parent_id")
    private Long parentId;
    /**
     * 父节点名称
     */
    @Column(name = "parent_name")
    private String parentName;
    /**
     * 父节点id列表串，用,分割
     */
    @Column(name = "tree_path")
    private String treePath;
    /**
     * 排序号
     */
    @Column(name = "sort")
    private Long sort;
    /**
     * 是否禁用  true禁用  false 启用
     */
    @Column(name = "locked_flag")
    private Boolean isLock;

    /**
     * 菜单图标
     */
    @Column(name = "icon")
    private String icon;
}
