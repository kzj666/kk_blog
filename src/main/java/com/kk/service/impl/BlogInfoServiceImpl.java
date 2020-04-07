package com.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public Page blogList(int num, int size, QueryWrapper wrapper) {
        Page<BlogInfo> page = new Page<>(num,size);
        blogInfoDao.selectPage(page, wrapper);
        return page;
    }

    @Override
    public int blogDelete(long id) {
        return blogInfoDao.deleteById(id);
    }

    @Override
    public List<BlogInfo> show(){
        QueryWrapper<BlogInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("blog_id");
        Page<BlogInfo> page = new Page<>(1,6);
        blogInfoDao.selectPage(page, wrapper);
        return page.getRecords();
    }


}