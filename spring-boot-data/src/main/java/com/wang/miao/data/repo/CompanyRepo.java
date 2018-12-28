package com.wang.miao.data.repo;

import com.wang.miao.data.domain.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author zhangzl
 * @date 2018/12/26 1:51 PM
 */
public interface CompanyRepo extends JpaRepository<CompanyEntity, Long> {

    @Query("select c.creatTime from CompanyEntity c")
    List<CompanyEntity> getOneTime();

}
