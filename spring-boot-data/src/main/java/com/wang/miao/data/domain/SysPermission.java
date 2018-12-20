package com.wang.miao.data.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 描述:
 *    Sys Permission
 * @author zhangzl
 * @create 2018-12-20 2:23 PM
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class SysPermission {

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 资源类型，[menu|button]
     */
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 排序
     */
    private Integer sort;

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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
