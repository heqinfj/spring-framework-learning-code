package com.linkedbear.spring.javaspi;

import com.linkedbear.spring.javaspi.initializer.DemoInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author heqin
 */
@HandlesTypes(DemoInitializer.class)
public class DemoContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> demoInitializerClasses, ServletContext servletContext) throws ServletException {
        System.out.println("call DemoContainerInitializer's  onStartup");
        System.out.println(demoInitializerClasses);
    }
}
