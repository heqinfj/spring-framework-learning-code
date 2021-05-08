package com.linkedbear.spring.annotation.d_importxml;

import com.linkedbear.spring.annotation.d_importxml.config.ImportXmlAnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.stream.Stream;

public class ImportXmlAnnoApplication {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/import-anno.xml");
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    
        System.out.println("----------------------");
        
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ImportXmlAnnotationConfiguration.class);
        Stream.of(ctx2.getBeanDefinitionNames()).forEach(System.out::println);

        //spring配置文件中<bean>的id和name属性区别，以及identifier和aliases
        //https://blog.csdn.net/aitangyong/article/details/50629525
        System.out.println("---------测试别名---------");
        String[] aliases = ctx2.getAliases("person");
        System.out.println(Arrays.toString(aliases));


        String[] alias = ctx2.getAliases("boyMan");
        System.out.println(Arrays.toString(alias));//[a1, a2]

    }
}
