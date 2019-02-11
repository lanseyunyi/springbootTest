package com.example.demo.SpringTest;

import com.example.demo.SpringTest.config.SpringConfig;
import com.example.demo.SpringTest.dao.DataFromDataBase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 16:00 2019/1/28/028
 * @Modify By:
 **/
public class SpringTest {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbgdln?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false&autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("ok");
        jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.execute("insert into student (name,age) values('zhangsan','13111')");
    }

    private void sayHello(){
        System.out.println("Hello");
    }

    @Test
    @SuppressWarnings("all")
    public void initTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataFromDataBase dataFromDataBase = (DataFromDataBase) ctx.getBean("dataFromDataBase");
        JdbcTemplate jdbcTemplate1 = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//        jdbcTemplate1.execute("insert into student (name,age) values('zhangsan','13111')");
        System.out.println(dataFromDataBase.insert(jdbcTemplate1));
        this.getClass().getClassLoader().getResourceAsStream("");
    }
}
