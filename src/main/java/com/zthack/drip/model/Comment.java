package com.zthack.drip.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by LiChao on 2018/7/24.
 */
@Data
@Entity
@Table(name = "drip_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 293794705413345028L;

    /**
     * id
     */
    @Id
    @Column(name = "comment_id")
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
     * 评论文章
     */
    @ManyToOne(targetEntity = Post.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    /**
     * 评论内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 评论人昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 点赞数量
     */
    @Column(name = "like_count")
    private Integer likeCount;
}
