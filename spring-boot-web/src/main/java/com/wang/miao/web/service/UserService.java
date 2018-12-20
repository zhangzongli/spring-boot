package com.wang.miao.web.service;

import com.wang.miao.data.domain.SysUser;
import com.wang.miao.data.repo.SysUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *    SysUser Service
 * @author zhangzl
 * @create 2018-12-20 9:29 AM
 */
@Service
public class UserService {

    @Autowired
    private SysUserRepo sysUserRepo;

    /**
     * 保存user
     */
    public void saveUser() {
        SysUser sysUser = new SysUser();
        sysUser.setName("zhangsan");
        sysUser.setPassword("123456");
        sysUserRepo.save(sysUser);
    }

}
