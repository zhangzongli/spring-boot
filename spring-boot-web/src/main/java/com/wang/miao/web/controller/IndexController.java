package com.wang.miao.web.controller;

import com.wang.miao.web.aop.LogAnnotation;
import com.wang.miao.web.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/random-recipe")
    @LogAnnotation
    public String randomRecipe() {
        return recipeService.getRandomRecipeName();
    }

    @GetMapping("/index/add")
    public String add() {
        return "add";
    }
}
