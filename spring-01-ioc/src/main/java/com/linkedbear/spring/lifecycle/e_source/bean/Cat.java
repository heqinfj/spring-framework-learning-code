package com.linkedbear.spring.lifecycle.e_source.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class Cat {
    
    @Value("miaomiao")
    private String name;
    
    @Autowired
    @Qualifier("master")
    private Person master;

    @Autowired
    @Qualifier("secondMaster")
    private Person secMaster;

    @Autowired
    private Person person;

    @Resource
    private List<Person> personList;
    
    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", master=" + master + '\'' + ", secMaster=" + secMaster + '\''
                + ", person=" + person
                + '\n' + ", personList=" + personList.toString()
                + '}';
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Person getMaster() {
        return master;
    }
    
    public void setMaster(Person master) {
        this.master = master;
    }
}
