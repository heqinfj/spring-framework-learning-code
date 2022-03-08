package com.linkedbear.spring.bean.a_type.config;

import com.linkedbear.spring.bean.a_type.bean.Ball;
import com.linkedbear.spring.bean.a_type.bean.Child;
import com.linkedbear.spring.bean.a_type.bean.Toy;
import com.linkedbear.spring.bean.a_type.bean.ToyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanTypeConfiguration {
    
    @Bean
    public Child child() {
        return new Child();
    }
    
//    @Bean
//    @Primary
//    public Toy ball() {
//        return new Ball("ball2");
//    }
    
    @Bean
    public ToyFactoryBean toyFactory() {
        ToyFactoryBean toyFactory = new ToyFactoryBean();
        toyFactory.setChild(child());
        return toyFactory;
    }
}
