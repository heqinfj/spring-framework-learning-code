package com.linkedbear.spring.definition.c_removedefinition;

import com.linkedbear.spring.definition.c_removedefinition.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RemoveBeanDefinitionApplication2 {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.linkedbear.spring.definition.c_removedefinition.config");
        Person aqiang = (Person) annotationConfigApplicationContext.getBean("aqiang");
        System.out.println(aqiang);
    }
}
