package com.linkedbear.spring.proxy.c_cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author heqin
 */
public class SuperA {
    public String str = new String("hello world");

    public static void main(String[] args) {
        SuperA superA = new SuperA();
        SuperA proxy = (SuperA) new MyProxyFactory(superA).getProxyInstance();
        System.out.println("proxy: {}" + proxy.str);  // 输出"hello world"
    }

    private static class MyProxyFactory implements MethodInterceptor {
        //维护目标对象
        private Object target;

        public MyProxyFactory(Object target) {
            this.target = target;
        }

        //给目标对象创建一个代理对象
        public Object getProxyInstance(){
            //1.工具类
            Enhancer en = new Enhancer();
            //2.设置父类
            en.setSuperclass(target.getClass());
            //3.设置回调函数
            en.setCallback(this);
            //4.创建子类(代理对象)
            return en.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            //执行目标对象的方法
            Object returnValue = method.invoke(target, objects);
            return returnValue;
        }
    }
}
