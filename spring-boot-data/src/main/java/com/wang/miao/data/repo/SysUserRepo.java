package com.wang.miao.data.repo;

import com.wang.miao.data.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangzl
 * @date 2018/12/20 9:28 AM
 */
public interface SysUserRepo extends JpaRepository<SysUser, Long> {

    /**
     * 通过name 查询 user
     * @param name
     * @return
     */
    SysUser findByName(String name);

}
