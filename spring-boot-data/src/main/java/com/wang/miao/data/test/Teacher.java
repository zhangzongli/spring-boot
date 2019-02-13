package com.wang.miao.data.test;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Description:
 *    Teacher
 * @author zhangzl
 * @create 2019-02-12 10:48
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Teacher extends Person {

    private String specialty;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
