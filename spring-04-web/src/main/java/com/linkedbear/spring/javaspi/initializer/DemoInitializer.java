package com.linkedbear.spring.javaspi.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author heqin
 */
public interface DemoInitializer {
    void onStartup(ServletContext servletContext) throws ServletException;
}
