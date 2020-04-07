package com.kk.controller.blog;

/*
@author kzj
@date 2020/4/5 - 23:57
*/

import com.kk.entity.BlogInfo;
import com.kk.service.BlogInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("blog")
@Controller
public class BlogController {

    @Resource
    BlogInfoService blogInfoService;

    @GetMapping({"", "index", "index.html"})
    public String index(){
        return "/blog/index";
    }

    @GetMapping("edit")
    public String edit(){
        return "/blog/edit";
    }

    @PostMapping("addBlog")
    public String addBlog(BlogInfo blogInfo){
        blogInfoService.addBlog(blogInfo);
        return "/blog/index";
    }

}
