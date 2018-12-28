package com.wang.miao.test;

import com.wang.miao.data.repo.CompanyRepo;
import com.wang.miao.data.repo.SysUserRepo;
import com.wang.miao.web.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 *    Get Company Test
 * @author zhangzl
 * @create 2018-12-26 1:54 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GetCompanyTest {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private SysUserRepo sysUserRepo;

    @Test
    public void getCompany() {
        companyRepo.findAll();
        sysUserRepo.findAll();
    }
}
