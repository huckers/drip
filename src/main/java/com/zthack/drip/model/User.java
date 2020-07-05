package com.zthack.drip.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by LiChao on 2018/7/24.
 */
@Data
@Entity
@Table(name = "drip_user")
public class User implements Serializable {

    private static final long serialVersionUID = 8256686143060845235L;

    @Id
    @Column(name = "user_id")
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
     * 用户名
     */
    @Column(name = "user_name")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 盐
     */
    @Column(name = "salt")
    private String salt;


    @Column(name = "available")
    private Integer available;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 文章数
     */
    @Column(name = "post_count")
    private Integer postCount;

}
