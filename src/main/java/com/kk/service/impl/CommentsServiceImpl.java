package com.kk.service.impl;

import com.kk.dao.CommentsDao;
import com.kk.entity.BlogComments;
import com.kk.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}