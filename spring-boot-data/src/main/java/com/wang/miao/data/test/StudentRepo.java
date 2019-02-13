package com.wang.miao.data.test;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * Student Repo
 *
 * @author zhangzl
 * @create 2019-02-12 14:51
 */
public interface StudentRepo extends JpaRepository<Student, Long> {

}
