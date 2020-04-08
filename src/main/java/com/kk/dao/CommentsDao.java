package com.kk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kk.entity.BlogComments;
import org.apache.ibatis.annotations.Mapper;

/**
 * (BlogComments)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-08 12:44:04
 */
@Mapper
public interface CommentsDao extends BaseMapper<BlogComments> {


}