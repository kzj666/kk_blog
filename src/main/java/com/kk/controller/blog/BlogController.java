package com.kk.controller.blog;

/*
@author kzj
@date 2020/4/5 - 23:57
*/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.entity.BlogInfo;
import com.kk.service.BlogInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("blog")
@Controller
public class BlogController {

    @Resource
    BlogInfoService blogInfoService;

    @GetMapping("edit")
    public String edit(){
        return "/blog/edit";
    }

    @PostMapping("addBlog")
    public String addBlog(BlogInfo blogInfo){
        blogInfoService.addBlog(blogInfo);
        return "redirect:/blog";
    }

    @GetMapping("blogList")
    public String blogList(Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size){
        Page page = blogInfoService.blogList(pn, size, null);
        model.addAttribute("page", page);
        return "/admin/blogs";
    }

    @DeleteMapping("blogDelete")
    public String blogdelete(@RequestParam("id") long id){
        blogInfoService.blogDelete(id);
        return "/admin/blogs";
    }

    @GetMapping("/toSearchList/{title}")
    public String toSearchList(@PathVariable("title") String title, Model model, @RequestParam(value = "pn", defaultValue = "1") int pn, @RequestParam(value = "size", defaultValue = "10") int size){
        String tl = StringUtils.deleteWhitespace(title);
        System.out.println("-----------------------------------"+tl);
        QueryWrapper<BlogInfo> wrapper = new QueryWrapper<>();
        wrapper.like("blog_title", tl);
        Page page = blogInfoService.blogList(pn, size,wrapper);
        model.addAttribute("page", page);
        return "/admin/blogs";
    }


}
