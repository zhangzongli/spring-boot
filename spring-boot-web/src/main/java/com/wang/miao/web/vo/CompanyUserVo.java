package com.wang.miao.web.vo;

/**
 * 描述:
 *    Company User Vo
 * @author zhangzl
 * @create 2018-12-28 10:09 AM
 */
public class CompanyUserVo {

    private String name;

    private String salt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
