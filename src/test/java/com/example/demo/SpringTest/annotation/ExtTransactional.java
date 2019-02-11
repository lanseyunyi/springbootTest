package com.example.demo.SpringTest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 15:58 2019/1/30/030
 * @Modify By:
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtTransactional {

}
