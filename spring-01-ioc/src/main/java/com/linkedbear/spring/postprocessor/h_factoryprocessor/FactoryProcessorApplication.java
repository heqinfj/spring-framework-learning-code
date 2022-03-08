package com.linkedbear.spring.postprocessor.h_factoryprocessor;

import com.linkedbear.spring.postprocessor.h_factoryprocessor.bean.Red;
import com.linkedbear.spring.postprocessor.h_factoryprocessor.config.ColorNameSetterFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryProcessorApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.postprocessor.h_factoryprocessor");
        Red red = ctx.getBean(Red.class);
        System.out.println(red);
        ColorNameSetterFactoryPostProcessor cns = ctx.getBean(ColorNameSetterFactoryPostProcessor.class);
        System.out.println(cns);
    }
}
