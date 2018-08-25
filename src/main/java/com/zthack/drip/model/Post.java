package com.zthack.drip.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章
 * Created by LiChao on 2018/7/24.
 */
@Data
@Entity
@Table(name = "drip_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 6257755504661558420L;

    /**
     * id
     */
    @Id
    @Column(name = "post_id")
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
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 作者
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User author;

    /**
     * 简介
     */
    @Column(name = "introduction")
    private String introduction;

    /**
     * 正文
     */
    @Column(name = "content")
    private String content;

    /**
     * 浏览次数
     */
    @Column(name = "view_count")
    private Integer viewCount;

    /**
     * 评论
     */
    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    /**
     * 评论数量
     */
    @Column(name = "comment_count")
    private Integer commentCount;

    /**
     * 点赞数量
     */
    @Column(name = "like_count")
    private Integer likeCount;

    /**
     * 所属分类
     */
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cate_id")
    @JsonIgnore
    private Category cate;

}
