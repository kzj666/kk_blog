package com.kk.service;

import com.kk.entity.AdminUser;
import java.util.List;

/**
 * (AdminUser)表服务接口
 *
 * @author makejava
 * @since 2020-04-05 17:51:28
 */
public interface AdminUserService {


    AdminUser queryByNamePass(AdminUser adminUser);

    /**
     * 根据用户名查询，用于shiro认证
     * @param userName
     * @return
     */
    AdminUser queryByName(String userName);

}