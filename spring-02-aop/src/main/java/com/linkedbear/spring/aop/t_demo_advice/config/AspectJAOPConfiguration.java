package com.linkedbear.spring.aop.t_demo_advice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.linkedbear.spring.aop.t_demo_advice")
@EnableAspectJAutoProxy
public class AspectJAOPConfiguration {
    
}
