package com.kk.controller.blog;

import com.kk.entity.BlogComments;
import com.kk.service.CommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BlogComments)表控制层
 *
 * @author makejava
 * @since 2020-04-08 12:44:04
 */
@Controller
@RequestMapping("comments")
public class CommentsController {
    @Resource
    private CommentsService commentsService;

    @PostMapping("add")
    public String addComms(BlogComments blogComments){
        commentsService.addComms(blogComments);
        return "redirect:/blog";
    }

}