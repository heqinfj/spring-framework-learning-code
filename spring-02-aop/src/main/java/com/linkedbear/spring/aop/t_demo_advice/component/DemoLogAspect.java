package com.linkedbear.spring.aop.t_demo_advice.component;

import com.linkedbear.spring.aop.t_demo_advice.vo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author heqin
 * @Date 2022/3/6 18:24
 */
@Aspect
@Component
public class DemoLogAspect {

    /**
     * 通过Thread获取类文件名、类名、当前执行方法，以及行号信息等
     * <p>
     * https://my.oschina.net/u/435726/blog/261595
     */
    private void printCallInfo() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        String classFile = stackTraceElement.getFileName();
        String methodName = stackTraceElement.getMethodName();
        int methodNameLine = stackTraceElement.getLineNumber();
        String className = stackTraceElement.getClassName();
        System.out.println("类文件名是:" + classFile);
        System.out.println("当前方法是:" + methodName);
        System.out.println("当前行号:" + methodNameLine);
        System.out.println("类名是:" + className);
    }

    private String getMethodAnnotationName() {
        String methodAnnotationName = "";
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        String methodName = stackTraceElement.getMethodName();
        String className = stackTraceElement.getClassName();
        try {
            Class<?> aClass = Class.forName(className);
            Method[] declaredMethods = aClass.getDeclaredMethods();
            Method method = Arrays.stream(declaredMethods)
                    .filter(declaredMethod -> declaredMethod.getName().equals(methodName))
                    .findFirst()
                    .orElse(null);
            if (method != null) {
                Annotation[] methodAnnotations = method.getAnnotations();
                if (methodAnnotations != null && methodAnnotations.length > 0) {
                    Annotation methodAnnotation = methodAnnotations[0];
                    Class<? extends Annotation> annotationType = methodAnnotation.annotationType();
                    methodAnnotationName = annotationType.getSimpleName();
                    methodAnnotationName = "@" + methodAnnotationName;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return methodAnnotationName;
    }

    @Pointcut("execution(* com.linkedbear.spring.aop.t_demo_advice.service.DemoService.*(..))")
    public void defaultPointcut() {
    }

    @Before("defaultPointcut()")
    public void beforePrint() {
        System.out.println("Logger beforePrint run..." + getMethodAnnotationName());
    }

    @After("defaultPointcut()")
    public void afterPrint() {
        System.out.println("Logger afterPrint run..." + getMethodAnnotationName());
    }

    @Around("defaultPointcut()")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logger aroundPrint before run ......" + getMethodAnnotationName());
        Object retVal = null;
        try {
            retVal = joinPoint.proceed();
            System.out.println("Logger aroundPrint afterReturning run ......" + getMethodAnnotationName());
            return retVal;
        } catch (Throwable e) {
            System.out.println("Logger aroundPrint afterThrowing run ......" + getMethodAnnotationName());
            throw e;
        } finally {
            if (retVal instanceof User) {
                User user = (User) retVal;
                user.setUserName("YoYo");
            }
            System.out.println("Logger aroundPrint after run ......" + getMethodAnnotationName());
        }
    }

    @AfterReturning("defaultPointcut()")
    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......" + getMethodAnnotationName());
    }

    @AfterThrowing("defaultPointcut()")
    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......" + getMethodAnnotationName());
    }
}
