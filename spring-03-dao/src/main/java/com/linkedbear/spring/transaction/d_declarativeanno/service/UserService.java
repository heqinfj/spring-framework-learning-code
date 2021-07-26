package com.linkedbear.spring.transaction.d_declarativeanno.service;

import com.linkedbear.spring.jdbc.b_crud.bean.User;
import com.linkedbear.spring.transaction.d_declarativeanno.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    UserDao userDao;
    
    @Transactional
    public void saveAndQuery() {
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        System.out.println(String.format("当前类：%s，当前方法：%s，当前事务的名称：%s",stackTraceElement.getClassName(),stackTraceElement.getMethodName(), TransactionSynchronizationManager.getCurrentTransactionName()));
        User user = new User();
        user.setName("阿巴阿巴");
        user.setTel("123654789");
    
        userDao.save(user);

        int i = 1 / 0;

        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }
}
