package com.linkedbear.spring.lifecycle.a_initmethod;

import com.linkedbear.spring.lifecycle.a_initmethod.config.InitMethodConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitMethodAnnoApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(InitMethodConfiguration.class);
        System.out.println("IOC容器初始化完成。。。");
        Thread.sleep(3000);
        ctx.close();
    }
}
/**
 输出结果如下：
 Dog 构造方法执行了。。。
 setName方法执行了。。。
 wangwang被初始化了。。。
 IOC容器初始化完成。。。
 wangwang被销毁了。。。

 //由此可以得出结论：Bean 的生命周期中，是先对属性赋值，后执行 init-method 标记的方法。
 */
