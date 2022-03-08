package com.linkedbear.spring.lifecycle.c_initializingbean;

import com.linkedbear.spring.lifecycle.c_initializingbean.config.InitializingDisposableConfiguration;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class InitializingDisposableAnnoApplication {
    
    public static void main(String[] args) throws Exception {
        System.out.println("准备初始化IOC容器。。。");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                InitializingDisposableConfiguration.class);
        DefaultListableBeanFactory defaultListableBeanFactory = ctx.getDefaultListableBeanFactory();
        List<BeanPostProcessor> beanPostProcessors = defaultListableBeanFactory.getBeanPostProcessors();
        System.out.println("beanPostProcessors: " + beanPostProcessors);
        System.out.println("IOC容器初始化完成。。。");
        System.out.println();
        System.out.println("准备销毁IOC容器。。。");
        ctx.close();
        System.out.println("IOC容器销毁完成。。。");
    }
}
