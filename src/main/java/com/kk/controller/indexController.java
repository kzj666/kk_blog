package com.kk.controller;

/*
@author kzj
@date 2020/4/7 - 19:06
*/

import com.kk.entity.BlogInfo;
import com.kk.service.BlogInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class indexController {

    @Resource
    BlogInfoService blogInfoService;

    @GetMapping({"/", "blog"})
    public String toIndex(Model model){
        List<BlogInfo> blogs = blogInfoService.show();
        for (int i = 1; i <= blogs.size(); i++) {
            model.addAttribute("blog"+i, blogs.get(i-1));
        }
        return "blog/index";
    }

}
