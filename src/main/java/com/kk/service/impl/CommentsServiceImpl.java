package com.kk.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.dao.CommentsDao;
import com.kk.entity.BlogComments;
import com.kk.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BlogComments)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 12:44:04
 */
@Service("blogCommentsService")
public class CommentsServiceImpl implements CommentsService {
    @Resource
    private CommentsDao commentsDao;

    @Override
    public int addComms(BlogComments blogComments){
        return commentsDao.insert(blogComments);
    }

    @Override
    public Page commsList(int pn, int size) {
        Page<BlogComments> page = new Page<>();
        commentsDao.selectPage(page, null);
        return page;
    }

    @Override
    public int commDelete(int id) {
        return commentsDao.deleteById(id);
    }

    @Override
    public BlogComments see(int id) {
        return commentsDao.selectById(id);
    }

}