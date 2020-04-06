package com.kk.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kk.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * (AdminUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-05 17:51:28
 */
@Mapper
public interface AdminUserDao extends BaseMapper<AdminUser> {



    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    AdminUser queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdminUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adminUser 实例对象
     * @return 对象列表
     */
    List<AdminUser> queryAll(AdminUser adminUser);

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 影响行数
     */
    int insert(AdminUser adminUser);

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 影响行数
     */
    int update(AdminUser adminUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

}