package com.wang.miao.data.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *    Company Entity
 * @author zhangzl
 * @create 2018-12-26 11:00 AM
 */
@Entity
@Table(name = "company")
public class CompanyEntity extends BaseEntity{

    private static final long serialVersionUID = -7185317673610826231L;

    private String name;

    private List<SysUser> sysUsers;

    private Date time;


    public CompanyEntity(){

    }

    public CompanyEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
    @org.hibernate.annotations.ForeignKey(name = "none")
    public List<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
