package com.heqin;

import com.linkedbear.spring.boot.BootQuickstartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BootQuickstartApplication.class)
public class BootQuickstartApplicationTest {

    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void testAutoConfigurationPackages(){
        //Object bean = beanFactory.getBean("org.springframework.boot.autoconfigure.AutoConfigurationPackages");
        //Return the auto-configuration base packages for the given bean factory. 返回给定bean factory的自动配置基础包
        List<String> list = AutoConfigurationPackages.get(beanFactory);
        list.forEach(p -> System.out.println(p));

        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory)beanFactory;
        String[] beanDefinitionNames = defaultListableBeanFactory.getBeanDefinitionNames();
        System.out.println("beanDefinitionNames的大小：" + beanDefinitionNames.length);
        Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName -> System.out.println(beanDefinitionName));
    }
}
