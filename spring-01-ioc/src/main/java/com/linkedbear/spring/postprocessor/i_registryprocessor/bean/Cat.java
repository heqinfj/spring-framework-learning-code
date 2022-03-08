package com.linkedbear.spring.postprocessor.i_registryprocessor.bean;

import org.springframework.stereotype.Component;

@Component
public class Cat extends Animal {

    private Zoo zoo;

    private Color color;

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", zoo=" + zoo +
                ", color=" + color +
                '}';
    }
}
