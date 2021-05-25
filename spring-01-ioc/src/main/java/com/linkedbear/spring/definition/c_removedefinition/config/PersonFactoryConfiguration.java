package com.linkedbear.spring.definition.c_removedefinition.config;

import com.linkedbear.spring.definition.c_removedefinition.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heqin
 */
@Configuration
public class PersonFactoryConfiguration {

    @Bean
    Person aqiang(){
        Person person = new Person();
        person.setName("阿强");
        person.setSex("male");
        return person;
    }

    @Bean
    Person azhen(){
        Person person = new Person();
        person.setName("阿珍");
        person.setSex("female");
        return person;
    }

    /**
     * https://juejin.cn/book/6857911863016390663/section/6859986122496278532
     * 2.2.2 声明配置类
     * 由上一章 BeanDefinition 的注册方式与实现类型，可知如果此处使用注解配置类的方式注册 Bean ( @Bean ) ，
     * 生成的 BeanDefinition 将无法取到 beanClassName （也无法取到 PropertyValues ），故此处选用 xml 方式注册 Bean 。
     */
}
