package com.linkedbear.spring.postprocessor.g_mergedefinition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MergeDefinitionPostProcessorApplication {
    
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "com.linkedbear.spring.postprocessor.g_mergedefinition");

//        BeanDefinition catDefinition = ctx.getBeanFactory().getBeanDefinition("cat");
//        System.out.println(catDefinition);
//
//        BeanDefinition mergedCatDefinition = ctx.getBeanFactory().getMergedBeanDefinition("cat");
//        System.out.println(mergedCatDefinition);

        ctx.close();
    }
}
