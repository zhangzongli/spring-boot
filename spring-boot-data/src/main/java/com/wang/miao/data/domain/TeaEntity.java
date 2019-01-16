package com.wang.miao.data.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *    Tea
 * @author zhangzl
 * @create 2019-01-11 08:33
 */
@Entity
public class TeaEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4306842402224305140L;

    private String name;

    private List<ClassEntity> classEntitys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "tea_class_rel", joinColumns = @JoinColumn(name = "tea_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none")),
            inverseJoinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "none")))
    public List<ClassEntity> getClassEntitys() {
        return classEntitys;
    }

    public void setClassEntitys(List<ClassEntity> classEntitys) {
        this.classEntitys = classEntitys;
    }
}
