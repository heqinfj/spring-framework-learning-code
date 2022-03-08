package com.linkedbear.spring.basic_di.a_quickstart_set;

import com.linkedbear.spring.basic_di.a_quickstart_set.bean.Person;
import com.linkedbear.spring.basic_di.a_quickstart_set.bean.Cat;
import com.linkedbear.spring.basic_di.a_quickstart_set.config.QuickstartInjectBySetConfiguration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class QuickstartInjectBySetAnnoApplication {
    
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(QuickstartInjectBySetConfiguration.class);
        getBeanPostProcessors(beanFactory);
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    
        Cat cat = beanFactory.getBean(Cat.class);
        System.out.println(cat);
    }

    public static void getBeanPostProcessors(BeanFactory beanFactory){
        if(beanFactory instanceof AnnotationConfigApplicationContext){
            AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)beanFactory;
            DefaultListableBeanFactory defaultListableBeanFactory = ctx.getDefaultListableBeanFactory();
            List<BeanPostProcessor> beanPostProcessors = defaultListableBeanFactory.getBeanPostProcessors();
            System.out.println("beanPostProcessors: " + beanPostProcessors);
        }
    }
}
