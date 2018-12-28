package com.wang.miao.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *    Company Entity
 * @author zhangzl
 * @create 2018-12-26 11:00 AM
 */
@Entity
@Table(name = "company")
public class CompanyEntity extends BaseEntity implements Serializable {

    private final static Long serialVersionUID = 1L;

    private String name;

    private List<SysUser> sysUsers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(targetEntity = SysUser.class, fetch = FetchType.LAZY, mappedBy = "company")
    @org.hibernate.annotations.ForeignKey(name = "none")
    public List<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }
}
