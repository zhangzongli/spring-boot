package com.wang.miao.web.controller;

import com.wang.miao.data.domain.ClassEntity;
import com.wang.miao.data.domain.CompanyEntity;
import com.wang.miao.data.domain.TeaEntity;
import com.wang.miao.data.repo.ClassRepo;
import com.wang.miao.data.repo.CompanyRepo;
import com.wang.miao.data.repo.TeaRepo;
import com.wang.miao.web.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ClassRepo classRepo;

    @Autowired
    private TeaRepo teaRepo;

    @GetMapping("/test")
    public List<CompanyEntity> getCompanys(CompanyEntity companyEntity) {
        List<CompanyEntity> companyEntityList = companyRepo.getOneTime();
        List<CompanyEntity> companyEntities = companyRepo.findAll();
        return null;
    }

    @PostMapping("/test")
    public void addCompany(CompanyEntity company) throws Exception {
        companyRepo.save(company);
        companyService.saveCompany();

    }

    @PutMapping("/test")
    public void updateCompany() {
        CompanyEntity company = companyRepo.findOne(280679560398376960L);
        company.setName("update");
        companyRepo.save(company);
    }


    @GetMapping("/class")
    public List<ClassEntity> getClassEntity() {
        List<ClassEntity> classEntities = classRepo.findAll();
        return classEntities;
    }

    @GetMapping("/tea")
    public List<TeaEntity> getTeaEntity() {
        List<TeaEntity> teaEntities = teaRepo.findAll();
        return teaEntities;
    }

    @PostMapping("/tea")
    public void addTea() {
        List<ClassEntity> classEntities = classRepo.findAll();
        TeaEntity teaEntity = new TeaEntity();
        teaEntity.setName("Three Tea");
        teaEntity.setClassEntitys(classEntities);
        teaRepo.save(teaEntity);
    }

    @PostMapping("/class")
    public void addClass() {
        List<TeaEntity> teaEntities = teaRepo.findAll();
        ClassEntity classEntity = new ClassEntity();
        classEntity.setName("Three Class");
        classEntity.setTeaEntitys(teaEntities);
        classRepo.save(classEntity);
    }

    @DeleteMapping("/tea")
    public void delTea() {
        teaRepo.delete(281043412138987520L);
    }

    @DeleteMapping("/class")
    public void delClass() {
        classRepo.delete(2L);
    }
}
