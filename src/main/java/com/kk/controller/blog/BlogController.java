package com.kk.controller.blog;

/*
@author kzj
@date 2020/4/5 - 23:57
*/

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kk.entity.BlogInfo;
import com.kk.service.BlogInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

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
        page.getRecords().forEach(System.out::println);
        model.addAttribute("page", page);
        return "/admin/blogs";
    }

    @GetMapping("/seeBlog")
    public String seeBlog(@RequestParam("id") int id, Model model){
        BlogInfo article = blogInfoService.seeBlog(id);
        model.addAttribute("article", article);
        return "/blog/article";
    }


    /**
     * 处理图片上传
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    //博客图片上传问题
    @RequestMapping("/file/upload")
    @ResponseBody
    public JSONObject fileUpload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request) throws IOException {
        //上传路径保存设置

        //获得SpringBoot当前项目的路径：System.getProperty("user.dir")
        String path = System.getProperty("user.dir") + "/upload/";

        //按照月份进行分类：
        Calendar instance = Calendar.getInstance();
        String month = (instance.get(Calendar.MONTH) + 1) + "月";
        path = path + month;

        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdirs();
        }

        //上传文件地址
        System.out.println("上传文件保存地址：" + realPath);

        //解决文件名字问题：我们使用uuid;
        String filename = "pg-" + UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
        File newfile = new File(realPath, filename);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newfile);

        //给editormd进行回调
        JSONObject res = new JSONObject();
        res.put("url", "/upload/" + month + "/" + filename);
        res.put("success", 1);
        res.put("message", "upload success!");

        return res;
    }

}
