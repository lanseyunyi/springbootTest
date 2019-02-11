package com.example.demo.SpringTest.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 16:01 2019/1/28/028
 * @Modify By:
 **/
@Configuration
@ComponentScan("com.example.demo.SpringTest")
@MapperScan("com.example.demo.SpringTest.dao.mybatis")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dbgdln?characterEncoding=utf-8&serverTimezone=UTC&useSSL=false&autoReconnect=true");
        dataSource.setUser("root");
        dataSource.setPassword("ok");
        dataSource.setMaxPoolSize(30);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(ComboPooledDataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(ComboPooledDataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(ComboPooledDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
