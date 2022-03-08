package com.linkedbear.spring.postprocessor.c_executetime.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class Dog implements InitializingBean {

    @Autowired
    private Person person;

    private String name;

    public Dog() {
        System.out.println("Dog constructor run...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public void printPerson(Person px){
        System.out.println("主人是: " + px);
    }

    public void initMethod() {
        System.out.println("initMethod ...");
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("PostConstruct ...");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean ...");
    }
}
