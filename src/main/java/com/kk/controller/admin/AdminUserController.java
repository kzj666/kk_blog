package com.kk.controller.admin;

/*
@author kzj
@date 2020/4/5 - 23:50
*/

import com.kk.entity.AdminUser;
import com.kk.service.AdminUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("admin")
public class AdminUserController {

    @Resource
    AdminUserService adminUserService;

    @GetMapping({"login", "login.html"})
    public String login(){
        return "admin/login";
    }

    @PostMapping("login")
    public String login(String username, String password, Model model){
        
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            //登录成功则放入session中
            AdminUser user = (AdminUser)subject.getPrincipal();
            subject.getSession().setAttribute("user", user);
            return "redirect:/admin/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            return "admin/login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "admin/login";
        } catch (ExcessiveAttemptsException e) {
            model.addAttribute("msg", "登录失败次数过多");
            return "admin/login";
        } catch (LockedAccountException e) {
            model.addAttribute("msg", "帐号已被锁定");
            return "admin/login";
        } catch (DisabledAccountException e) {
            model.addAttribute("msg", "帐号已被禁用");
            return "admin/login";
        } catch (ExpiredCredentialsException e) {
            model.addAttribute("msg", "帐号已过期");
            return "admin/login";
        } catch (UnauthorizedException e) {
            model.addAttribute("msg", "您没有得到相应的授权！");
            return "admin/login";
        }
    }

    @GetMapping("index")
    public String index(){
        return "admin/index";
    }

}