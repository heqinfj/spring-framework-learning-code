package com.linkedbear.spring.proxy.b_jdk;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author heqin
 */
public class TestGetProxyClass {
    private static List<Partner> partners = new ArrayList<>();

    static {
        partners.add(new IndividualPartner("肖洁洁"));
        partners.add(new IndividualPartner("田苟"));
        partners.add(new IndividualPartner("高总裁"));
    }

    public static void main(String[] args) {
        Partner partner = partners.remove(0);
        Class<?> proxyClass = Proxy.getProxyClass(partner.getClass().getClassLoader(), partner.getClass().getInterfaces());
        System.out.println(proxyClass);
    }
}

