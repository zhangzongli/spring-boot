package com.wang.miao.test;

import com.wang.miao.web.Application;
import com.wang.miao.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 *    Save User Test
 * @author zhangzl
 * @create 2018-12-20 10:09 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SaveUserTest {


    @Autowired
    private UserService userService;

    @Test
    public void saveUser() {
        userService.saveUser();
    }

}
