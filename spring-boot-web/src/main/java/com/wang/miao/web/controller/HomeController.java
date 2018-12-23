package com.wang.miao.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 *    Home Controller
 * @author zhangzl
 * @create 2018-12-20 5:00 PM
 */
@Controller
@RequestMapping("/api")
public class HomeController {

//    @GetMapping(value = {"/", "/login"})
//    public String getLoginView() {
//        return "/login";
//    }


    @GetMapping("/login")
    public String login(String userName, String passWord) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "/login";
        }
        return "/index";
    }

    @GetMapping("/index/add")
    @ResponseBody
    public String add() {
        return "add";
    }
}
