package com.linkedbear.spring.annotation.c_scan.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author heqin
 * @Date 2022/2/24 15:19
 */
@Component
public class DemoHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private Cat cat;

    public void printCat(){
        System.out.println("cat:" + cat);
    }
}
