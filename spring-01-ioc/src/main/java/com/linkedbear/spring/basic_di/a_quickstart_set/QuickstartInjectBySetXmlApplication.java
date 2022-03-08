package com.linkedbear.spring.basic_di.a_quickstart_set;

import com.linkedbear.spring.basic_di.a_quickstart_set.bean.Cat;
import com.linkedbear.spring.basic_di.a_quickstart_set.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class QuickstartInjectBySetXmlApplication {
    
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("basic_di/inject-set.xml");
        getBeanPostProcessors(beanFactory);
        Person person = beanFactory.getBean(Person.class);
        System.out.println(person);
        Cat cat = beanFactory.getBean(Cat.class);
        System.out.println(cat);
    }


    public static void getBeanPostProcessors(BeanFactory beanFactory){
        if(beanFactory instanceof ClassPathXmlApplicationContext){
            ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext)beanFactory;
            ConfigurableListableBeanFactory bf = ctx.getBeanFactory();
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory)bf;
            System.out.println("beanPostProcessors: " + defaultListableBeanFactory.getBeanPostProcessors());
        }
    }
}
