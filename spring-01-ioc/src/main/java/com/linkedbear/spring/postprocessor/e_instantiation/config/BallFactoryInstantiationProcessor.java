package com.linkedbear.spring.postprocessor.e_instantiation.config;

import com.linkedbear.spring.postprocessor.e_instantiation.bean.Ball;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class BallFactoryInstantiationProcessor implements InstantiationAwareBeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("ball".equals(beanName)) {
            Ball ball = new Ball();
            ball.setId("工厂球~");
            return ball;
        }
        return null;
    }
    
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
        //TODO 如果为false则下面的postProcessProperties方法不会执行
        //TODO 可以直接断点跟踪查看逻辑  AbstractAutowireCapableBeanFactory.java的if (!ibp.postProcessAfterInstantiation(bw.getWrappedInstance(), beanName))
    }
    
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        if ("ball2".equals(beanName)) {
            MutablePropertyValues values = new MutablePropertyValues(pvs);
            values.addPropertyValue("id", "拦截球~");
            return values;
        }
        return null;
    }
}
