package com.linkedbear.spring.postprocessor.i_registryprocessor.bean;

public class Color {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Color{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
