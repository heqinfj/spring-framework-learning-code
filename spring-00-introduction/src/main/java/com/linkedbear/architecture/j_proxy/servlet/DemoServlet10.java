package com.linkedbear.architecture.j_proxy.servlet;

import com.linkedbear.architecture.j_proxy.factory.BeanFactory;
import com.linkedbear.architecture.j_proxy.service.DemoService;
import com.linkedbear.architecture.j_proxy.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Proxy;

@WebServlet(urlPatterns = "/demo10")
public class DemoServlet10 extends HttpServlet {
    
    DemoService demoService;
    
    @Override
    public void init() throws ServletException {
        //目标对象
        DemoService demoService = (DemoService) BeanFactory.getBean("demoService");
        Class<? extends DemoService> clazz = demoService.getClass();
        //创建目标对象的代理对象
        this.demoService = (DemoService) Proxy
                .newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), (proxy, method, args) -> {
                    LogUtils.printLog("DemoService", method.getName(), args);
                    return method.invoke(demoService, args);
                });
        //代理对象和目标对象并不是同一个对象，但是它们的hashCode()方法和toString()方法的结果均相同
        System.out.println("目标对象 toString(): " + demoService);
        System.out.println("代理对象 toString(): " + this.demoService);
        //getClass()方法返回的是对象的运行时类型信息，可以看到，代理对象的类型是class com.sun.proxy.$Proxy6，而目标对象的类型是class com.linkedbear.architecture.j_proxy.service.impl.DemoServiceImpl
        System.out.println("目标对象 getClass(): " + demoService.getClass());
        System.out.println("代理对象 getClass(): " + this.demoService.getClass());
        //https://blog.csdn.net/qq_41231926/article/details/105518717
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(demoService.findAll().toString());
        demoService.add("bearbear", 666);
        demoService.subtract("bearbear", 666);
    }
}
