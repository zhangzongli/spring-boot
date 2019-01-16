package com.wang.miao.data.repo;

import com.wang.miao.data.domain.TeaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * Tea Repo
 *
 * @author zhangzl
 * @create 2019-01-11 08:53
 */
public interface TeaRepo extends JpaRepository<TeaEntity, Long> {
}
