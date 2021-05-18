package com.linkedbear.spring.lifecycle.e_source.config;

import com.linkedbear.spring.lifecycle.e_source.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.linkedbear.spring.lifecycle.e_source.bean")
@Import(ExtConfiguration.class)
public class LifecycleSourceConfiguration {

    @Bean(name={"master","xxxxx"},initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Person person() {
        Person person = new Person();
        person.setName("lisi");
        return person;
    }

}
