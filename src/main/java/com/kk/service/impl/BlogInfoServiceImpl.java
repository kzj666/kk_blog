package com.kk.service.impl;

import com.kk.entity.BlogInfo;
import com.kk.dao.BlogInfoDao;
import com.kk.service.BlogInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BlogInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-04-07 12:30:43
 */
@Service("blogInfoService")
public class BlogInfoServiceImpl implements BlogInfoService {
    @Resource
    private BlogInfoDao blogInfoDao;

    @Override
    public int addBlog(BlogInfo blogInfo) {
        return blogInfoDao.insert(blogInfo);
    }
}