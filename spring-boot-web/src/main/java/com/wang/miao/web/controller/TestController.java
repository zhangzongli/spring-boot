package com.wang.miao.web.controller;

import com.wang.miao.data.domain.CompanyEntity;
import com.wang.miao.data.repo.CompanyRepo;
import com.wang.miao.data.repo.CompanyUserVo;
import com.wang.miao.web.vo.CompanyChildVo;
import com.wang.miao.web.vo.CompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *    Test Contreller
 * @author zhangzl
 * @create 2018-12-26 3:25 PM
 */
@RestController
public class TestController {

    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping("/test")
    public List<CompanyEntity> getCompanys() {
        List<CompanyEntity> companyEntityList = companyRepo.getOneTime();
        List<CompanyEntity> companyEntities = companyRepo.findAll();
        return null;
    }

    @PostMapping("/test")
    public void setCompany(CompanyEntity company) {
        companyRepo.save(company);
    }

    /**
     * 使用get set 手动转换
     * 无法避免无限递归问题
     * @return
     */
    @GetMapping("/vo")
    public List<CompanyChildVo> getCompanyVo() {
        List<CompanyEntity> companyEntities = companyRepo.findAll();
        List<CompanyChildVo> result = new ArrayList<CompanyChildVo>();
        for (CompanyEntity companyEntity : companyEntities) {
            CompanyChildVo companyVo = new CompanyChildVo();
            companyVo.setName(companyEntity.getName());
            companyVo.setSysUsers(companyEntity.getSysUsers());
            result.add(companyVo);
        }
        return result;
    }

    /**
     * 使用mapStruct
     * @return
     */
    @GetMapping("/mapstruct")
    public CompanyVo getCompanyMapStruct() {
        List<CompanyEntity> companyEntities = companyRepo.findAll();
//        CompanyVo result = CompanyMapStruct.MAPPER.from(companyEntities.get(0));
        return null;
    }
}
