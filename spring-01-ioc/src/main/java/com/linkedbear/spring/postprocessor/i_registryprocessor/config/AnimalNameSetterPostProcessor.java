package com.linkedbear.spring.postprocessor.i_registryprocessor.config;

import com.linkedbear.spring.postprocessor.i_registryprocessor.bean.Animal;
import com.linkedbear.spring.postprocessor.i_registryprocessor.bean.Color;
import com.linkedbear.spring.postprocessor.i_registryprocessor.bean.Zoo;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.*;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class AnimalNameSetterPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("AnimalNameSetterPostProcessor postProcessBeanFactory run ......");
        String[] animalNames = beanFactory.getBeanNamesForType(Animal.class);
        Stream.of(animalNames).forEach(name -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            beanDefinition.getPropertyValues().add("name", name);
            if("cat".equals(name)){
                //TODO BeanReference 应用
                beanDefinition.getPropertyValues().add("zoo",new RuntimeBeanReference("zoo"));

                //TODO RootBeanDefinition
                RootBeanDefinition colorBeanDef = new RootBeanDefinition();
                colorBeanDef.setBeanClass(Color.class);
                colorBeanDef.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);//有什么用？
                colorBeanDef.getPropertyValues().add("desc","黑色");

                beanDefinition.getPropertyValues().add("color",colorBeanDef);
            }
        });
    }
}
