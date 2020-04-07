package com.kk.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

/**
 * (BlogInfo)实体类
 *
 * @author makejava
 * @since 2020-04-07 12:30:43
 */
public class BlogInfo implements Serializable {
    private static final long serialVersionUID = -36270470474012211L;
    /**
    * 主键id
    */
    @TableId(type = IdType.AUTO)
    private Long blogId;
    /**
    * 博客标题
    */
    private String blogTitle;
    /**
    * 博客内容
    */
    private String blogContent;
    /**
    * 博客标签
    */
    private String blogTags;
    /**
    * 创建时间
    */
    @TableField(fill= FieldFill.INSERT)
    private Date gmtCreate;
    /**
    * 更新时间
    */
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;
    /**
    * 乐观锁
    */
    @Version
    private Integer version;
    /**
    * 逻辑删除
    */
    @TableLogic
    private Integer isDeleted;


    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(String blogTags) {
        this.blogTags = blogTags;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}