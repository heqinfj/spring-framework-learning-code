package com.linkedbear.spring.aop.t_demo_advice;

import com.linkedbear.spring.aop.t_demo_advice.config.AspectJAOPConfiguration;
import com.linkedbear.spring.aop.t_demo_advice.service.DemoService;
import com.linkedbear.spring.aop.t_demo_advice.vo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author heqin
 * @Date 2022/3/6 18:42
 */
public class DemoAspectJApplication {
    //public static void main(String[] args) throws Exception {
    //    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectJAOPConfiguration.class);
    //    DemoService demoService = ctx.getBean(DemoService.class);
    //    //String s = demoService.say("JoJo");
    //    //System.out.println("返回值：" + s);
    //    User user = demoService.print("JoJo");
    //    System.out.println("返回值："+ user);
    //}

    AnnotationConfigApplicationContext ctx = null;
    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(AspectJAOPConfiguration.class);
    }

    @Test
    public void testNormal(){
        DemoService demoService = ctx.getBean(DemoService.class);
        //String s = demoService.say("JoJo");
        //System.out.println("返回值：" + s);
        User user = demoService.print("JoJo");
        System.out.println("返回值："+ user);
    }

    @Test
    public void testException(){
        DemoService demoService = ctx.getBean(DemoService.class);
        User user = demoService.printEx("JoJo");
        System.out.println("返回值："+ user);
    }
}
