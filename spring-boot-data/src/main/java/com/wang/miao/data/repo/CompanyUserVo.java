package com.wang.miao.data.repo;

/**
 * 描述:
 *    Company User Vo
 * @author zhangzl
 * @create 2018-12-28 10:09 AM
 */
public class CompanyUserVo {

    private Long id;

    private String salt;

    public CompanyUserVo(Long id, String salt) {
        this.id = id;
        this.salt = salt;
    }

    public CompanyUserVo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
