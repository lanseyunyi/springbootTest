package com.example.demo.SpringTest;

import org.springframework.transaction.annotation.Propagation;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 11:25 2019/1/31/031
 * @Modify By:
 **/
public class PropagationTest {

    public static void main(String[] args) {
        System.out.println(Propagation.REQUIRED.value());
    }
}
