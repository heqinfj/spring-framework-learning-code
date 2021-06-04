package com.linkedbear.spring.environment.b_api.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EnvironmentHolder {
    
    @Autowired
    Environment environment;
    
    public void printEnvironment() {
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        //测试再次调用 AbstractEnvironment类的getDefaultProfiles
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        //测试再次调用 AbstractEnvironment类的getActiveProfiles
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(environment.getProperty("jdbc.url"));
    }
}
