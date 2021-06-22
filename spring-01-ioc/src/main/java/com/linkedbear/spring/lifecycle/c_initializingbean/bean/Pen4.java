package com.linkedbear.spring.lifecycle.c_initializingbean.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;

public class Pen4 implements InitializingBean, DisposableBean {
    
    private Integer ink;

    private User belongUser;

    public Pen4(){
        System.out.println("Pen4 constructor run 。。。");
    }

    public void setInk(Integer ink) {
        System.out.println("Pen4 setInk方法执行了。。。");
        this.ink = ink;
    }

    //@Inject
    //@Resource
    @Autowired
    public void setBelongUser(User user){
        System.out.println("Pen4 setBelongUser run 。。。" + user);
        this.belongUser = user;
    }
    
    public void open() {
        System.out.println("init-method - 打开钢笔。。。");
    }
    
    public void close() {
        System.out.println("destroy-method - 合上钢笔。。。");
    }
    
    @PostConstruct
    public void addInk() {
        //TODO 结论：@PostConstruct 标记的方法发生在 bean 的实例化之后，在属性赋值、组件自动注入之后，在InitializingBean、init-method之前
        //TODO @PostConstruct > InitializingBean > init-method
        //TODO https://juejin.cn/book/6857911863016390663/section/6859985742043709453
        System.out.println("@PostConstruct - 钢笔中已加满墨水。。。");
        this.ink = 100;
    }
    
    @PreDestroy
    public void outwellInk() {
        System.out.println("@PreDestroy - 钢笔中的墨水都放干净了。。。");
        this.ink = 0;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean - 准备写字。。。");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean - 写完字了。。。");
    }
    
    @Override
    public String toString() {
        return "Pen{" + "ink=" + ink + '}';
    }
}
