package com.wang.miao.data.test;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *    Person Repo
 * @author zhangzl
 * @create 2019-02-12 14:50
 */
public interface PersonRepo extends JpaRepository<Person, Long> {

}
