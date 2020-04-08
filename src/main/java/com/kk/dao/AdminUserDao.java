package com.kk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kk.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * (AdminUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-05 17:51:28
 */
@Mapper
public interface AdminUserDao extends BaseMapper<AdminUser> {


}