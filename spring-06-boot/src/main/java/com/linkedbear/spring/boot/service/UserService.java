package com.linkedbear.spring.boot.service;

import com.linkedbear.spring.boot.bean.User;
import com.linkedbear.spring.boot.controller.DemoController;
import com.linkedbear.spring.boot.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

@Service("userService")
public class UserService implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    UserDao userDao;

    @Autowired
    DemoController demoController;
    
    @Transactional
    public void saveAndQuery() {
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        System.out.println(String.format("当前类：%s，当前方法：%s，当前事务的名称：%s，线程名：%s",stackTraceElement.getClassName(),stackTraceElement.getMethodName(), TransactionSynchronizationManager.getCurrentTransactionName(),Thread.currentThread().getName()));
        User user = new User();
        user.setName(Thread.currentThread().getName());
        user.setTel("999999999");
        userDao.save(user);
        //int i = 1 / 0;
        //List<User> userList = userDao.findAll();
        //System.out.println(userList);
    }

    public void testDependController(){
        logger.info(demoController.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("UserService: " + applicationContext);
    }
}
