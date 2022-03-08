package com.linkedbear.spring.lifecycle.b_jsr250.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Pen2 {
    
    private Integer ink;

    private boolean isChecked;

    @Autowired
    private void checkPen(){
        this.isChecked = true;
        System.out.println("完成检查钢笔是否可用，属性isChecked为true。。。");
    }

    public Pen2() {
        System.out.println("执行Pen2构造函数，开始实例化一个钢笔。。。");
    }

    public void setInk(Integer ink) {
        this.ink = ink;
    }
    
    public void open() {
        System.out.println("init-method - 打开钢笔。。。");
    }
    
    public void close() {
        System.out.println("destory-method - 合上钢笔。。。");
    }
    
    @PostConstruct
    public void addInk() {
        System.out.println("@PostConstruct - 钢笔中已加满墨水。。。");
        this.ink = 100;
    }
    
    @PreDestroy
    public void outwellInk() {
        System.out.println("@PreDestroy - 钢笔中的墨水都放干净了。。。");
        this.ink = 0;
    }
    
    @Override
    public String toString() {
        return "Pen{" + "ink=" + ink + '}';
    }
}
