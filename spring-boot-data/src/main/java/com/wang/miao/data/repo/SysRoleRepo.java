package com.wang.miao.data.repo;

import com.wang.miao.data.domain.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhangzl
 * @date 2018/12/20 3:05 PM
 */
public interface SysRoleRepo extends JpaRepository<SysRole, Long> {

    @Query(value = "select sr.* from sys_role sr left join sys_user_role sur on sr.id = sur.role_id and sur.user_id = :userId", nativeQuery = true)
    List<SysRole> getRolesByUserId(@Param("userId") Long userId);

}
