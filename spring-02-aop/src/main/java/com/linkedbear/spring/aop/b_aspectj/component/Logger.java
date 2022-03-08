package com.linkedbear.spring.aop.b_aspectj.component;

import com.linkedbear.spring.aop.b_aspectj.service.FinanceService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 首先，在 Logger 上标注 @Component 注解，将其注册到 IOC 容器中。然后还得标注一个 @Aspect 注解，代表该类是一个切面类：
 */
@Aspect
@Component
public class Logger {
    
    @Before("execution(public * com.linkedbear.spring.aop.b_aspectj.service.FinanceService.*(..))")
    public void beforePrint() {
        System.out.println("Logger beforePrint run ......");
    }
    
//    @After("execution(* com.linkedbear.spring.aop.b_aspectj.service.*.*(String)))")
    @After("@annotation(com.linkedbear.spring.aop.b_aspectj.component.Log)")
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }
    
    @AfterReturning("execution(* com.linkedbear.spring.aop.b_aspectj.service.*.*(String)))")
    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......");
    }
    
    @AfterThrowing("defaultPointcut()")
    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......");
    }
    
    @Around("execution(public * com.linkedbear.spring.aop.b_aspectj.service.FinanceService.addMoney(..))")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logger aroundPrint before run ......");
        try {
            Object retVal = joinPoint.proceed();
            System.out.println("Logger aroundPrint afterReturning run ......");
            return retVal;
        } catch (Throwable e) {
            System.out.println("Logger aroundPrint afterThrowing run ......");
            throw e;
        } finally {
            System.out.println("Logger aroundPrint after run ......");
        }
    }
    
    @Pointcut("execution(* com.linkedbear.spring.aop.b_aspectj.service.*.*(String)))")
    public void defaultPointcut() {
    
    }

    @Around("execution(public * com.linkedbear.spring.aop.b_aspectj.service.FinanceService.findMoney(..))")
    public Object aroundHandle(ProceedingJoinPoint joinPoint) throws Throwable {
        Object retVal = joinPoint.proceed();
        if(retVal instanceof FinanceService.Money){
            FinanceService.Money money = (FinanceService.Money)retVal;
            System.out.printf("money的value值为：%s",money.getValue());
            System.out.println();
            return money;
        }
        return retVal;
    }
}
