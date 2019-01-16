package com.wang.miao.data.repo;

import com.wang.miao.data.domain.ClassEntity;
import com.wang.miao.data.domain.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *    Class Repo
 * @author zhangzl
 * @create 2019-01-11 08:40
 */
public interface ClassRepo extends JpaRepository<ClassEntity, Long> {
}
