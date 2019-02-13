package com.wang.miao.web.test;

import com.wang.miao.data.domain.CompanyEntity;
import com.wang.miao.data.domain.SysUser;
import com.wang.miao.data.repo.CompanyRepo;
import com.wang.miao.data.repo.SysUserRepo;
import com.wang.miao.data.test.Person;
import com.wang.miao.data.test.PersonRepo;
import com.wang.miao.data.test.Student;
import com.wang.miao.data.test.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *    Test Controller
 * @author zhangzl
 * @create 2019-02-12 14:58
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private SysUserRepo sysUserRepo;

    @GetMapping("/savePerson")
    public void savePerson(String name) {
        Person person = new Person();
        person.setName(name);
        personRepo.save(person);
    }

    @GetMapping("/saveStudent")
    public void saveStudent(String code) {
        Student student = new Student();
        student.setCode(code);
        studentRepo.save(student);
    }

    @GetMapping("/saveCompany")
    public void saveCompany() {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName("test");
//        List<SysUser> sysUsers = new ArrayList<SysUser>();
//        SysUser sysUser = new SysUser();
//        sysUser.setName("test");
//        sysUsers.add(sysUser);
//        companyEntity.setSysUsers(sysUsers);
//        companyRepo.save(companyEntity);

        SysUser sysUser = new SysUser();
        sysUser.setName("test");
        sysUser.setCompany(companyEntity);
        sysUserRepo.save(sysUser);
    }

}
