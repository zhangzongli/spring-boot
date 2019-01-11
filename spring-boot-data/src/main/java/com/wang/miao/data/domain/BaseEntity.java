package com.wang.miao.data.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 描述:
 *    Base Entity
 * @author zhangzl
 * @create 2018-12-28 16:49
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1103005637461574778L;

    private Long id;

    private Date creatTime;

    private Date updateTime;

    @Version
    private Long version;

    @Id
    @GeneratedValue(generator = "SnowFlake")
    @GenericGenerator(name = "SnowFlake", strategy = "com.wang.miao.data.SnowFlake")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
