package com.wang.miao.data.domain;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 描述:
 *    SysRole
 * @author zhangzl
 * @create 2018-12-20 2:02 PM
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "role"))
public class SysRole {

    /**
     * id
     */
    private Long id;

    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
    private String role;

    /**
     * 角色描述,UI界面显示使用
     */
    private String description;

    @Id
    @GeneratedValue(generator = "SnowFlake")
    @GenericGenerator(name = "SnowFlake", strategy = "com.wang.miao.data.SnowFlake")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
