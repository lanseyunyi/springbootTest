package com.example.demo.Controller;

import com.example.demo.dao.user.TUserMapper;
import com.example.demo.pojo.user.TUser;
import com.example.demo.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:59 2019/1/15/015
 * @Modify By:
 **/
@RestController
public class TestController {

    @Resource
    private TUserMapper tUserMapper;

    @Autowired
    private ServiceTest serviceTest;

    @RequestMapping(value = "/testboot")
    public List<TUser> getUser(@Validated @RequestBody  List<TUser> year, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            System.out.println("error");
      List<TUser> tUserList= tUserMapper.findAllTUser();
      serviceTest.test();
//        session.setAttribute("tUserList",tUserList);
        return tUserMapper.findAllTUser();
    }

    // insert
    @RequestMapping(value = "/transaction")
    @Transactional
    public int insertUser(){
        TUser tUser=new TUser();
        tUser.setEmployee("zhangsan");
        tUser.setEmployee_id("123");
        tUser.setDept_id("123");
        tUser.setJob("123");


        int i=tUserMapper.insertUser(tUser);
        i=1/0;
        return i;
    }
}
