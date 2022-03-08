package com.linkedbear.spring.javaspi.initializer.impl;

import com.linkedbear.spring.javaspi.initializer.DemoInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author heqin
 */
public class DemoInitializerImpl implements DemoInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("call DemoInitializerImpl's onStartup ...");
    }
}
