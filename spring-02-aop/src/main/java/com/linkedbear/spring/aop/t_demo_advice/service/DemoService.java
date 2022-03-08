package com.linkedbear.spring.aop.t_demo_advice.service;

import com.linkedbear.spring.aop.t_demo_advice.vo.User;

/**
 * @Author heqin
 * @Date 2022/3/6 18:26
 */
public interface DemoService {

    String say(String name);

    User print(String name);

    User printEx(String name);
}
