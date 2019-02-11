package com.example.demo.SpringTest.dao;

import com.example.demo.SpringTest.dao.mybatis.TUserMapper;
import com.example.demo.SpringTest.user.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 17:59 2019/1/30/030
 * @Modify By:
 **/
@Repository
public class LogDao {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void outInsert(JdbcTemplate jdbcTemplate){
        jdbcTemplate.execute("insert into student (name,age) values('lisi','14')");
    }

    @Autowired
    private TUserMapper tUserMapper;

    @Transactional
    public void myTest(){
        TUser tUser=new TUser();
        tUser.setEmployee("zhangsan");
        tUser.setEmployee_id("123");
        tUser.setDept_id("123");
        tUser.setJob("123");


        int i=tUserMapper.insertUser(tUser);
        i=1/0;
    }
}
