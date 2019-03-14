package com.wang.miao.data.repo;

import com.wang.miao.data.domain.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhangzl
 * @date 2018/12/20 3:37 PM
 */
public interface SysPermissionRepo extends JpaRepository<SysPermission, Long> {

    /**
     * 根据角色id获取权限信息
     * @param roleId
     * @return
     */
    @Query(value = "select sp.* from sys_permission sp left join sys_role_permission srp on sp.id = srp.permission_id and srp.role_id = :roleId", nativeQuery = true)
    List<SysPermission> getSysPermissionsByRoleId(@Param("roleId") Long roleId);

    /**
     * 获取全部配置信息
     * @return
     */
    @Query("select s from SysPermission s order by s.sort")
    List<SysPermission> getAllPermission();
}
