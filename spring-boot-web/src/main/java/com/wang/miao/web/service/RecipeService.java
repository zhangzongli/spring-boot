package com.wang.miao.web.service;

import com.wang.miao.data.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *      Recipe Service
 * @author zhangzongli
 * @create 2019-03-14 16:00
 */
@Service
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;

    /**
     * 随机获取菜品名称
     * @return
     */
    public String getRandomRecipeName() {
        return recipeRepo.getRanDomRecipeName();
    }

}