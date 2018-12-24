package com.wang.miao.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *    Index Controller
 * @author zhangzl
 * @create 2018-12-23 8:13 PM
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping("/index/add")
    public String add() {
        return "add";
    }
}
