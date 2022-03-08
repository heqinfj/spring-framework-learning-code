package com.linkedbear.spring.aop.b_aspectj;

import com.linkedbear.spring.aop.b_aspectj.config.AspectJAOPConfiguration;
import com.linkedbear.spring.aop.b_aspectj.service.FinanceService;
//junit5
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//junit4
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Nested Proxy using cglib in spring
 * 在spring中使用cglib嵌套代理
 * https://stackoverflow.com/questions/60690702/nested-proxy-using-cglib-in-spring
 * @Author heqin
 * @Date 2021/9/16 1:36
 */
public class TwoCglibProxyExample {

    private AnnotationConfigApplicationContext ctx;

    private FinanceService financeService;

//    public static void main(String[] args) {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\proxy\\cglib"); // Class 文件保存路径
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectJAOPConfiguration.class);
//        FinanceService financeService = ctx.getBean(FinanceService.class);
//    }

    //@BeforeEach
    @Before
    public void initialize(){
        ctx = new AnnotationConfigApplicationContext(AspectJAOPConfiguration.class);
        financeService = ctx.getBean(FinanceService.class);
    }

    @Test
    public void findMoney(){
        //下面的设置只能是在main启动时有用，junit测试需要在 idea中配置 -Dcglib.debugLocation=E:\\proxy\\cglib
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\proxy\\cglib"); // Class 文件保存路径
        financeService = createSecondProxy(financeService);
        FinanceService.Money money = financeService.findMoney();
        System.out.println(money);
    }

    private FinanceService createSecondProxy(FinanceService firstProxy){
        //抛出异常
        //org.springframework.cglib.core.CodeGenerationException: java.lang.ClassFormatError-->Duplicate method name "newInstance" with signature
        // "([Lorg.springframework.cglib.proxy.Callback;)Ljava.lang.Object;" in class file com/linkedbear/spring/aop/b_aspectj/service/FinanceService$$EnhancerBySpringCGLIB$$2f83dc88$$EnhancerByCGLIB$$b4460b56
//        FinanceService secondProxy = (FinanceService) Enhancer.create(firstProxy.getClass(), (MethodInterceptor) (obj, method, args, proxy) -> {
//            System.out.println("这里进行再次cglib代理");
//            Object o = proxy.invokeSuper(obj, args);
//            return o;
//        });


        //调整如下：
        // firstProxy.getClass() -> firstProxy.getClass().getSuperclass()
        // proxy.invokeSuper(obj, args) -> proxy.invoke(firstProxy, args)
        FinanceService secondProxy = (FinanceService) Enhancer.create(firstProxy.getClass().getSuperclass(), (MethodInterceptor) (obj, method, args, proxy) -> {
            System.out.println("这里进行再次cglib代理-before");
            Object o = proxy.invoke(firstProxy, args);
            if(o instanceof FinanceService.Money){
                FinanceService.Money money = (FinanceService.Money)o;
                ((FinanceService.Money) o).setValue(50);
            }
            System.out.println("这里进行再次cglib代理-after");
            return o;
        });

        return secondProxy;
    }
}
