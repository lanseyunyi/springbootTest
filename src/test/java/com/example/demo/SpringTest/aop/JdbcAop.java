package com.example.demo.SpringTest.aop;

import com.example.demo.SpringTest.annotation.ExtTransactional;
import com.example.demo.SpringTest.transaction.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.Method;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 16:35 2019/1/28/028
 * @Modify By:
 **/
//@Aspect
//@Component
public class JdbcAop {

    /**
     * 申明切点，同时配置将要被aop过滤的业务类
     */
    @Pointcut("execution (* com.example.demo.SpringTest.dao.DataFromDataBase.insert(..))")
    public void pointcut() {
    }

//    @Before("pointcut()")
//    public void doBefore() {
//        System.out.println("事务开启");
//    }

//    @AfterReturning("pointcut()")
//    public void doAfterReturning() {
//        System.out.println("检查错误，回退操作");
//    }

//    @After("pointcut()")
//    public void doAfter() {
//        System.out.println("事务结束");
//    }
    @Autowired
    private TransactionUtils transactionUtils;

    @AfterThrowing("pointcut()")
    public void doAfterThrowing() {
        // 获取当前事务 直接回滚
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        rollbackTransaction();
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        // 注解信息获取
        ExtTransactional transactional=getExtTransactional(pjp);
        if (transactional==null){
            System.out.println("AOP transaction==null");
            return pjp.proceed();
        }

        // 开启事务
        TransactionStatus transactionStatus=beginTransaction();
        Object result = pjp.proceed();
        // 提交事务
        commitTransaction(transactionStatus);

        return result;
    }

    // 反射获取注解信息
    private ExtTransactional getExtTransactional(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        // 1.获取切点方法名（注：对任意切点）
        String methodName=pjp.getSignature().getName();
        // 2.获取切点所处类
        Class<?> classTarget=pjp.getTarget().getClass();
        // 3.获取切点对象类型
        Class<?>[] classType=((MethodSignature)pjp.getSignature()).getParameterTypes();
        // 4.获取切点的方法Method实例
        Method method=classTarget.getMethod(methodName,classType);
        // 5.获取切点方法上注解
        return method.getAnnotation(ExtTransactional.class);
    }

    // 开启事务
    private TransactionStatus beginTransaction(){
        System.out.println("事务开启");
        return transactionUtils.begin();
    }

    // 提交事务
    private void commitTransaction(TransactionStatus transactionStatus){
        System.out.println("提交事务");
        transactionUtils.commit(transactionStatus);
    }

    // 回滚事务
    private void rollbackTransaction(){
        System.out.println("回滚事务");
        transactionUtils.rollback();
    }
}
