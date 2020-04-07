package com.kk.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.entity.BlogInfo;
import java.util.List;

/**
 * (BlogInfo)表服务接口
 *
 * @author makejava
 * @since 2020-04-07 12:30:43
 */
public interface BlogInfoService {

    int addBlog (BlogInfo blogInfo);

    Page blogList(int num, int size, QueryWrapper wrapper);

    int blogDelete(long id);

    public List<BlogInfo> show();

}