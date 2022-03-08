package com.linkedbear.spring.aop.t_demo_advice.service.impl;

import com.linkedbear.spring.aop.t_demo_advice.service.DemoService;
import com.linkedbear.spring.aop.t_demo_advice.vo.User;
import org.springframework.stereotype.Component;

/**
 * @Author heqin
 * @Date 2022/3/6 18:28
 */
@Component
public class DemoServiceImpl implements DemoService {
    @Override
    public String say(String name) {
        String helloContent = "Hello," + name + "!";
        return helloContent;
    }

    @Override
    public User print(String name) {
        return new User(name,2);
    }

    @Override
    public User printEx(String name) {
        int a = 1/0;
        return new User(name,2);
    }
}
