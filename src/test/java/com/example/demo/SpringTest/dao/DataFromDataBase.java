package com.example.demo.SpringTest.dao;

import com.example.demo.SpringTest.annotation.ExtTransactional;
import com.example.demo.SpringTest.transaction.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 16:08 2019/1/28/028
 * @Modify By:
 **/
@Repository
public class DataFromDataBase {

    @Autowired
    private LogDao logDao;

//    @Transactional
    public int insert(JdbcTemplate jdbcTemplate) {
        System.out.println("执行数据库插入操作");
        System.out.println("成功返回1");
        // 执行数据库插入操作
        // ...
        // 成功返回
        jdbcTemplate.execute("insert into student (name,age) values('zhangsan','13')");
        logDao.outInsert(jdbcTemplate);
        logDao.myTest();
        int i = 1 / 0;

        return 1;
    }
}
