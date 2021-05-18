package com.linkedbear.spring.lifecycle.e_source.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.linkedbear.spring.lifecycle.e_source.bean.Person;
import org.springframework.context.annotation.Primary;

/**
 * @author heqin
 */
//通过@Import方式被导入
@Configuration
public class ExtConfiguration {

    @Bean("secondMaster")
    public Person person(){
        Person person = new Person();
        person.setName("第二个主人。。。");
        return person;
    }

    @Bean
    @Primary
    public Person person2Primary(){
        Person person = new Person();
        person.setName("指示当多个候选者有资格自动装配单值依赖项时，应优先考虑Person");
        return person;
    }
}
