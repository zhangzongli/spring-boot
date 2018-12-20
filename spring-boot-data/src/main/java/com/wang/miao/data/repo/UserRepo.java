package com.wang.miao.data.repo;

import com.wang.miao.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangzl
 * @date 2018/12/20 9:28 AM
 */
public interface UserRepo extends JpaRepository<User, Long> {

}
