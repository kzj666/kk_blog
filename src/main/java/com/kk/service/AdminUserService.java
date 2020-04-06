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

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    AdminUser queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdminUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    AdminUser insert(AdminUser adminUser);

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    AdminUser update(AdminUser adminUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}