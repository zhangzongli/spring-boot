package com.wang.miao.web.vo;

import com.wang.miao.data.domain.CompanyEntity;
import com.wang.miao.data.domain.SysUser;

import java.util.List;

/**
 * 描述:
 *    Company Vo
 * @author zhangzl
 * @create 2018-12-27 8:38 AM
 */
public class CompanyVo {

    private String name;

    private List<SysUser> sysUsers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }
}
