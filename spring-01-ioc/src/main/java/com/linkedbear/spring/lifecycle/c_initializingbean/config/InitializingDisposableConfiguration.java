package com.linkedbear.spring.lifecycle.c_initializingbean.config;

import com.linkedbear.spring.lifecycle.c_initializingbean.bean.Pen3;
import com.linkedbear.spring.lifecycle.c_initializingbean.bean.Pen4;
import com.linkedbear.spring.lifecycle.c_initializingbean.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializingDisposableConfiguration {
    
    @Bean(initMethod = "open", destroyMethod = "close")
    public Pen4 pen() {
        Pen4 pen4 = new Pen4();
        pen4.setInk(1);
        return pen4;
    }

    @Bean
    public User user() {
        User user = new User();
        user.setUserName("xiaomi");
        return user;
    }
    
}
