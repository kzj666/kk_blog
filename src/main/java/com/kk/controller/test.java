package com.kk.controller;

/*
@author kzj
@date 2020/4/5 - 14:33
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

    /**
     * 测试博客主页面
     * @return
     */
    @RequestMapping("test1")
    public String test(){
        return "blog/index";
    }

    /**
     * 测试后台页面
     * @return
     */
    @RequestMapping("test2")
    public String test2(){
        return "admin/index";
    }
}
