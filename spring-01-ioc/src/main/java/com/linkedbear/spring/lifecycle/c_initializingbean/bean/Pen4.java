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
        System.out.println("Pen4 构造函数开始执行，准备实例化Pen4 。。。");
    }

    public void setInk(Integer ink) {
        System.out.println("Pen4 setInk方法执行了。。。");
        this.ink = ink;
    }

    //@Inject
    //@Resource
    @Autowired
    public void setBelongUser(User user){
        System.out.println("执行setBelongUser方法，设置Pen4的属性belongUser为：" + user);
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
        //TODO 构造函数 > 属性组件自动注入 > @PostConstruct > InitializingBean > init-method
        //TODO https://juejin.cn/book/6857911863016390663/section/6859985742043709453
        System.out.println("@PostConstruct - 钢笔中已加满墨水。。。");
        this.ink = 100;

        /**
         * java对象实例化顺序
         * https://blog.csdn.net/m0_38110132/article/details/78842873
         * 静态成员变量|静态代码块 （这2个加载时按代码的先后顺序执行） —>  成员变量 | 方法块 （这2个加载时按代码的先后顺序执行） —> 构造函数的加载顺序
         * 1，父类的静态成员变量和静态代码块加载
         * 2，子类的静态成员变量和静态代码块加载
         * 3，父类成员变量和方法块加载
         * 4，父类的构造函数加载
         * 5，子类成员变量和方法块加载
         * 6，子类的构造函数加载
         */
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
