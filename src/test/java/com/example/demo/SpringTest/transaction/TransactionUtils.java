package com.example.demo.SpringTest.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @Author: zhangzhirong
 * @Description:编程事务（需手动begin，rollback，commit）
 * @Date:Created in 15:11 2019/1/29/029
 * @Modify By:
 **/
@Component
@Scope("prototype")
public class TransactionUtils {
    // 类状态，线程共享（具有线程安全问题）
    private TransactionStatus transactionStatus;
    // 获取事务
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    // 开启事务
    public TransactionStatus begin(){
        this.transactionStatus=dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return this.transactionStatus;
    }

    // 提交事务
    public void commit(TransactionStatus transactionStatus){
        dataSourceTransactionManager.commit(transactionStatus);
    }

    // 回滚事务
    public void rollback(){
        if(this.transactionStatus!=null)
            dataSourceTransactionManager.rollback(this.transactionStatus);
    }
}
