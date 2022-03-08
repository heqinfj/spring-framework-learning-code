package com.linkedbear.spring.postprocessor.i_registryprocessor.bean;

import org.springframework.stereotype.Component;

@Component
public class Zoo {

    private String name = "福州动物园";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                '}';
    }
}
