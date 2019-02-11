package com.example.demo;

import com.example.demo.SpringTest.config.SpringConfig;
import com.example.demo.SpringTest.dao.DataFromDataBase;
import com.example.demo.SpringTest.dao.mybatis.TUserMapper;
import com.example.demo.SpringTest.user.TUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringConfig.class})
public class DemoApplicationTests {

	@Autowired
	private DataFromDataBase dataFromDataBase;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
		dataFromDataBase.insert(jdbcTemplate);
		System.out.println();
	}

}

