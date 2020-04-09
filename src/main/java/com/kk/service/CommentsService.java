package com.kk.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.entity.BlogComments;

import java.util.List;

/**
 * (BlogComments)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 12:44:04
 */
public interface CommentsService {

    int addComms(BlogComments blogComments);

    Page commsList(int pn, int size);

    int commDelete(int id);

    BlogComments see(int id);

}