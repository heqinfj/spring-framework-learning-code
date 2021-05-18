package com.linkedbear.spring.basic_di.h_aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class AwaredTestBean implements ApplicationContextAware, BeanNameAware, ResourceLoaderAware {
    
    private String beanName;
    private ApplicationContext ctx;
    
    public String getName() {
        return beanName;
    }
    
    public void printBeanNames() {
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
    
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
    
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    //TODO 1. 通过Autowired注解在属性上 自动装配
    @Autowired(required=true)
    private ResourceLoader resourceLoader;

    //TODO 2.通过ResourceLoaderAware回调注入
    private ResourceLoader resourceLoaderFromAware;

    private ResourceLoader resourceLoaderFromSet;

    public ResourceLoader getResLoader(){
        return resourceLoader;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoaderFromAware = resourceLoader;
    }

    public ResourceLoader getResourceLoaderFromAware() {
        return resourceLoaderFromAware;
    }

    public ResourceLoader getResourceLoaderFromSet() {
        return resourceLoaderFromSet;
    }

    //TODO 3. 通过Autowired注解在方法上 自动装配
    @Autowired
    public void setResourceLoaderFromSet(ResourceLoader resourceLoaderFromSet) {
        this.resourceLoaderFromSet = resourceLoaderFromSet;
    }
}