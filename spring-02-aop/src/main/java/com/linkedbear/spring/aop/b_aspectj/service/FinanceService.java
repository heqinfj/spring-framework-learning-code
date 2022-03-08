package com.linkedbear.spring.aop.b_aspectj.service;

import com.linkedbear.spring.aop.b_aspectj.component.Log;
import org.springframework.stereotype.Component;


@Component
public class FinanceService {
    
    public void addMoney(double money) {
        System.out.println("FinanceService 收钱 === " + money);
    }
    
    @Log
    public double subtractMoney(double money) {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }
    
    public double subtractMoney(double money, String id) throws Exception {
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }
    
    public double getMoneyById(String id) {
        System.out.println("FinanceService 查询账户，id为" + id);
        return Math.random();
    }

    public Money findMoney(){
        Money money = new Money("人民币",10);
        return money;
    }

    public class Money{

        private String type;

        private int value;

        public Money(String type, int value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Money{" +
                    "type='" + type + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}
