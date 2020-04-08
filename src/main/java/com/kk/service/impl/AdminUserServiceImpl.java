package com.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kk.entity.AdminUser;
import com.kk.dao.AdminUserDao;
import com.kk.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdminUser)表服务实现类
 *
 * @author makejava
 * @since 2020-04-05 17:51:28
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserDao adminUserDao;


    @Override
    public AdminUser queryByNamePass(AdminUser adminUser) {
        QueryWrapper<AdminUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", adminUser.getUserName())
                .eq("user_password", adminUser.getUserPassword());
        return adminUserDao.selectOne(wrapper);
    }

    /**
     * 根据用户名查询，用于shiro认证
     * @param userName
     * @return
     */
    @Override
    public AdminUser queryByName(String userName) {
        QueryWrapper<AdminUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        return adminUserDao.selectOne(wrapper);
    }


}