package com.linkedbear.spring.lifecycle.a_initmethod.bean;

public class Dog {
    
    private String name;

    public Dog(){
        System.out.println("Dog 构造方法执行了。。。");
    }
    
    public void setName(String name) {
        System.out.println("setName方法执行了。。。");
        this.name = name;
    }
    
    public void init() {
        System.out.println(name + "被初始化了。。。");
    }
    
    public void destroy() {
        System.out.println(name + "被销毁了。。。");
    }
}
