package com.kk.controller.blog;

/*
@author kzj
@date 2020/4/5 - 23:57
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping({"/", "index", "index.html"})
    public String index(){
        return "/blog/index";
    }

}
