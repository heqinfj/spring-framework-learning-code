package com.linkedbear.spring.withdao.service;

import com.linkedbear.spring.withdao.controller.UserController76;
import com.linkedbear.spring.withdao.dao.UserDao;
import com.linkedbear.spring.withdao.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService implements ApplicationContextAware {
    
    @Autowired
    UserDao userDao;

    //TODO TEST
//    @Autowired
//    UserController76 userController76;
    
    public void update(User user) {
        userDao.update(user);
    }
    
    public List<User> findAllUsers() {
        //TODO TEST
//        System.out.println(userController76);
        return userDao.findAllUsers();
    }
    
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("UserService applicationContext: " + applicationContext);
    }
}
