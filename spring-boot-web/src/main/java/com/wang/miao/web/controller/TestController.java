package com.wang.miao.web.controller;

import com.wang.miao.data.domain.CompanyEntity;
import com.wang.miao.data.repo.CompanyRepo;
import com.wang.miao.web.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 描述:
 *    Test Contreller
 * @author zhangzl
 * @create 2018-12-26 3:25 PM
 */
@RestController
@Validated
public class TestController {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/test")
    public List<CompanyEntity> getCompanys(CompanyEntity companyEntity) {
        List<CompanyEntity> companyEntityList = companyRepo.getOneTime();
        List<CompanyEntity> companyEntities = companyRepo.findAll();
        return null;
    }

    @PostMapping("/test")
    public void addCompany(CompanyEntity company) throws Exception {
//        companyRepo.save(company);
        companyService.saveCompany();

    }

    @PutMapping("/test")
    public void updateCompany() {
        CompanyEntity company = companyRepo.findOne(280679560398376960L);
        company.setName("update");
        companyRepo.save(company);
    }


}
