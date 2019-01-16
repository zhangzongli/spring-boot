package com.wang.miao.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *    One
 * @author zhangzl
 * @create 2019-01-11 08:32
 */
@Entity
public class ClassEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8183184914305236001L;

    private String name;

    private List<TeaEntity> teaEntitys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "classEntitys")
    @org.hibernate.annotations.ForeignKey(name = "none")
    public List<TeaEntity> getTeaEntitys() {
        return teaEntitys;
    }

    public void setTeaEntitys(List<TeaEntity> teaEntitys) {
        this.teaEntitys = teaEntitys;
    }
}
