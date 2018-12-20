package com.wang.miao.data.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 描述:
 *    User Entity
 * @author zhangzl
 * @create 2018-12-20 9:08 AM
 */
@Entity
public class User {

    private Long id;

    private String name;

    private String password;

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
}
