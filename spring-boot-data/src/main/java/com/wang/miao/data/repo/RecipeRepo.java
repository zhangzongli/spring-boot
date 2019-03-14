package com.wang.miao.data.repo;

import com.wang.miao.data.domain.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Description:
 *      Recipe Repo
 * @author zhangzongli
 * @create 2019-03-14 15:55
 */
public interface RecipeRepo extends JpaRepository<RecipeEntity, Long> {

    @Query(value = "select recipe_name from  recipe ORDER BY  RAND() limit 1", nativeQuery = true)
    String getRanDomRecipeName();
}