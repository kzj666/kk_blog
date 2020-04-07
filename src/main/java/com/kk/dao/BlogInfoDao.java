package com.kk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kk.entity.BlogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (BlogInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-07 12:30:43
 */
@Mapper
public interface BlogInfoDao extends BaseMapper<BlogInfo> {

}