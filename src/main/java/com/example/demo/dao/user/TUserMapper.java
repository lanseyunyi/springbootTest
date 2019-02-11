package com.example.demo.dao.user;

import com.example.demo.pojo.user.PartTUser;
import com.example.demo.pojo.user.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TUserMapper {

    // find all users
    List<TUser> findAllTUser();

    // find part users
    List<PartTUser> findPartTUser(@Param("dept_id") String dept_id);

    // 模糊查询用户名称
    List<PartTUser> findSomeTUser(@Param("employee") String employee);

    // 通过用户名和密码查询
    public TUser checkTUserByUP(@Param("username") String username, @Param("password") String password);

    // 更新密码
    public int updatePassword(@Param("username") String username, @Param("password") String password);

    // insert
    public int insertUser(TUser tUser);

    // delete
    int deleteByEID(@Param("username") String username);
}