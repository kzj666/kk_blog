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

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public AdminUser queryById(Integer userId) {
        return this.adminUserDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AdminUser> queryAllByLimit(int offset, int limit) {
        return this.adminUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    @Override
    public AdminUser insert(AdminUser adminUser) {
        this.adminUserDao.insert(adminUser);
        return adminUser;
    }

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    @Override
    public AdminUser update(AdminUser adminUser) {
        this.adminUserDao.update(adminUser);
        return this.queryById(adminUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.adminUserDao.deleteById(userId) > 0;
    }
}