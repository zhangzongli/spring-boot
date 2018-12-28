package com.wang.miao.data.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 描述:
 *    SysUser Entity
 * @author zhangzl
 * @create 2018-12-20 9:08 AM
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class SysUser {

    private Long id;

    private String name;

    private String showName;

    private String password;

    private String salt;

    private Integer state;

    private CompanyEntity company;

    @Id
    @GeneratedValue(generator = "SnowFlake")
    @GenericGenerator(name = "SnowFlake", strategy = "com.wang.miao.data.SnowFlake")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @ManyToOne()
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "none"))
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    /**
     * 获取 name + salt
     * @return
     */
    @Transient
    public String getCredentialsSalt() {
        return this.name + this.salt;
    }
}
