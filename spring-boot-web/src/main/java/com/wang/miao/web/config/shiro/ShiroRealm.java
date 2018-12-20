package com.wang.miao.web.config.shiro;

import com.wang.miao.data.domain.SysPermission;
import com.wang.miao.data.domain.SysRole;
import com.wang.miao.data.domain.SysUser;
import com.wang.miao.data.repo.SysPermissionRepo;
import com.wang.miao.data.repo.SysRoleRepo;
import com.wang.miao.data.repo.SysUserRepo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 描述:
 *    Shiro Realm
 * @author zhangzl
 * @create 2018-12-20 11:21 AM
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserRepo sysUserRepo;

    @Autowired
    private SysRoleRepo sysRoleRepo;

    @Autowired
    private SysPermissionRepo sysPermissionRepo;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
         * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
         * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
         * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
         * 缓存过期之后会再次执行。
         */
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取认证主体对应的用户实体
        SysUser sysUser = sysUserRepo.findByName((String) principals.getPrimaryPrincipal());

        List<SysRole> sysRoleList = sysRoleRepo.getRolesByUserId(sysUser.getId());
        for (SysRole sysRole : sysRoleList) {
            simpleAuthorizationInfo.addRole(sysRole.getRole());

            List<SysPermission> sysPermissions = sysPermissionRepo.getSysPermissionsByRoleId(sysRole.getId());
            for (SysPermission sysPermission : sysPermissions) {
                simpleAuthorizationInfo.addStringPermission(sysPermission.getPermission());
            }
        }

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String userName = (String) token.getPrincipal();

        SysUser sysUser = sysUserRepo.findByName(userName);

        if (sysUser != null) {

            return new SimpleAuthenticationInfo(
                    userName,
                    sysUser.getPassword(),
                    ByteSource.Util.bytes(sysUser.getCredentialsSalt()),
                    getName());
        } else {
            throw new UnknownAccountException("用户名或密码错误");
        }
    }
}
