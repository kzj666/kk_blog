package com.kk.config.shiro;

/*
@author kzj
@date 2020/3/18 - 17:43
*/

import com.kk.entity.AdminUser;
import com.kk.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Autowired
    AdminUserService adminUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("------------------------------->执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //获取当前登录的对象
//        AdminUser adminUser = (AdminUser)principals.getPrimaryPrincipal();
//        //拿到登录对象的权限，用-分离出每一个权限,放入数组
//        String[] perm = adminUserService.getPerm().split("-");
//        //输出来看一下
////        for (String s : perm) {
////            System.out.println(s);
////        }
//        //将整个perm数组转成集合放入HashSet中
//        HashSet<String> set = new HashSet<>(Arrays.asList(perm));
//
//        info.setStringPermissions(set);
//        //添加权限
//        return info;
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("------------------------------->执行了认证");
        //userToken：是一个简单的用户名/密码身份验证令牌，以支持使用最广泛的身份验证机制。
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();
        //验证用户名是否在数据库中存在
        AdminUser adminUser = adminUserService.queryByName(username);
        if (adminUser == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(adminUser, adminUser.getUserPassword(), getName());
    }
}
