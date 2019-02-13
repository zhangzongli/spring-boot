package com.wang.miao.data.test;

import com.wang.miao.data.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Description:
 *    Person
 * @author zhangzl
 * @create 2019-02-12 10:40
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
