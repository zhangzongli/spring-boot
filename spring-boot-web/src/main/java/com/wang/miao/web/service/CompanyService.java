package com.wang.miao.web.service;

import com.wang.miao.data.domain.CompanyEntity;
import com.wang.miao.data.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 *    Company Service
 * @author zhangzl
 * @create 2019-01-09 23:52
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Transactional(rollbackFor = Exception.class)
    public void saveCompany() throws Exception {
        this.saveCompanyTwo();
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveCompanyTwo() {
        companyRepo.save(new CompanyEntity("aaaa"));
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveCompanyThree() {
        companyRepo.save(new CompanyEntity("AAAAAAA"));
    }
}
