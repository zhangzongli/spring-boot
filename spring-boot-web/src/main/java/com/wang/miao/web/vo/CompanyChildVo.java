package com.wang.miao.web.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wang.miao.data.domain.CompanyEntity;
import com.wang.miao.data.domain.SysUser;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * 描述:
 *    Company Child Vop
 * @author zhangzl
 * @create 2018-12-27 5:23 PM
 */
public class CompanyChildVo {

    private List<SysUser> sysUsers;

    @JsonIgnore
    public List<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }
}
