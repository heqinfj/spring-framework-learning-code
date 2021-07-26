package com.linkedbear.spring.transaction.d_declarativeanno.service;

import com.linkedbear.spring.transaction.d_declarativeanno.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserService userService;

    public void transfer(Integer sourceId, Integer targetId, int money) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        //获取方法所处的当前事务名称  TransactionSynchronizationManager.getCurrentTransactionName()
        System.out.println(String.format("当前类：%s，当前方法：%s，当前事务的名称：%s",stackTraceElement.getClassName(),stackTraceElement.getMethodName(), TransactionSynchronizationManager.getCurrentTransactionName()));
        accountDao.subtractMoney(sourceId, money);

        //int i = 1 / 0;

        accountDao.addMoney(targetId, money);
        try {
            userService.saveAndQuery();
        } catch (Exception e) {
            e.printStackTrace();
            //当前示例事务传播行为为REQUIRED，当userService.saveAndQuery()发生异常时，并用try catch捕获时，则会抛出如下异常信息：
            //解决事务嵌套捕获异常时发生的问题：org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
