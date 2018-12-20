package com.wang.miao.web.service;

import com.wang.miao.data.domain.User;
import com.wang.miao.data.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *    User Service
 * @author zhangzl
 * @create 2018-12-20 9:29 AM
 */
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    /**
     * 保存user
     */
    public void saveUser() {
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("123456");
        userRepo.save(user);
    }

}
