package com.kk.controller.blog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.entity.BlogComments;
import com.kk.service.CommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("commsList")
    public String commsList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size){
        Page page = commentsService.commsList(pn, size);
        model.addAttribute("page", page);
        return "admin/comments";
    }

    @DeleteMapping("commDelete")
    public String commDelete(@RequestParam("id") int id){
        commentsService.commDelete(id);
        return "redirect:/comments/commsList";
    }

    @GetMapping("see/{id}")
    public String see(@PathVariable("id") int id, Model model){
        BlogComments comm = commentsService.see(id);
        model.addAttribute("comm",comm);
        return "admin/commview";
    }

}