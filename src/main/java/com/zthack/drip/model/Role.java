package com.zthack.drip.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Data
@Entity
@Table(name = "drip_role")
public class Role{

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    //超级管理员标识
    public static final String ROLE_TYPE = "ROLE_ADMIN";

    /**
     * 角色名
     */
    @Column(name = "name")
    private String name;

    /**
     * 角色标识
     */
    @Column(name = "code")
    private String code;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
}
