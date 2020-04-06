package com.kk.controller.admin;

import com.kk.entity.AdminUser;
import com.kk.service.AdminUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AdminUser)表控制层
 *
 * @author makejava
 * @since 2020-04-05 17:51:28
 */
@RestController
@RequestMapping("adminUser")
public class AdminUserController {
    /**
     * 服务对象
     */
    @Resource
    private AdminUserService adminUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AdminUser selectOne(Integer id) {
        AdminUser adminUser = adminUserService.queryById(1);
        System.out.println(adminUser);
        return adminUser;
    }




}