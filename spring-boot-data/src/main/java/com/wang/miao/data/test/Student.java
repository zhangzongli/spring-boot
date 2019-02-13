package com.wang.miao.data.test;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Description:
 *    Student
 * @author zhangzl
 * @create 2019-02-12 10:47
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student extends Person {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
