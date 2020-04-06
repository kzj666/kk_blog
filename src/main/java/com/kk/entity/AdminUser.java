package com.kk.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.lang.reflect.Field;
import java.util.Date;
import java.io.Serializable;

/**
 * (AdminUser)实体类
 *
 * @author makejava
 * @since 2020-04-05 17:51:23
 */
public class AdminUser implements Serializable {
    private static final long serialVersionUID = 616369731526515225L;
    /**
    * 用户主键id
    */
    @TableId(type=IdType.AUTO)
    private Integer userId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户密码
    */
    private String userPassword;
    /**
    * 乐观锁
    */
    private Integer version;
    /**
    * 用户昵称
    */
    private String userNickname;
    /**
    * 逻辑删除
    */
    private Integer idDeleted;
    /**
    * 创建时间
    */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    /**
    * 更新时间
    */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Integer getIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(Integer idDeleted) {
        this.idDeleted = idDeleted;
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

}