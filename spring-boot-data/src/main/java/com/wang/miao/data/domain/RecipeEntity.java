package com.wang.miao.data.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Description:
 *      菜单 Entity
 * @author zhangzongli
 * @create 2019-03-14 15:49
 */
@Entity
@Table(name = "recipe")
public class RecipeEntity extends BaseEntity {

    /** 菜谱名称 */
    private String recipeName;

    /** 素材 */
    private String recipeMaterial;

    /** 做法 */
    private String recipePractice;

    /** 类型 1：主食 2：菜 */
    private String type;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeMaterial() {
        return recipeMaterial;
    }

    public void setRecipeMaterial(String recipeMaterial) {
        this.recipeMaterial = recipeMaterial;
    }

    public String getRecipePractice() {
        return recipePractice;
    }

    public void setRecipePractice(String recipePractice) {
        this.recipePractice = recipePractice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}