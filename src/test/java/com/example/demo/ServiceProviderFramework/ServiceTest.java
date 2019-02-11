package com.example.demo.ServiceProviderFramework;

import java.io.Serializable;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 14:13 2019/1/25/025
 * @Modify By:
 **/
public class ServiceTest implements Service,Serializable {
    enum abc{

    }
    private String name="zhang";
    private int age=18;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
