package com.linkedbear.spring.annotation.c_scan;

import com.linkedbear.spring.annotation.c_scan.bean.DemoHandlerInterceptor;
import com.linkedbear.spring.annotation.c_scan.bean.Person;
import com.linkedbear.spring.annotation.c_scan.config.ComponentScanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author heqin
 * @Date 2022/2/24 15:22
 */
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
        DemoHandlerInterceptor demoHandlerInterceptor = ctx.getBean(DemoHandlerInterceptor.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        System.out.println(Arrays.asList(beanDefinitionNames));
        demoHandlerInterceptor.printCat();
    }
}
