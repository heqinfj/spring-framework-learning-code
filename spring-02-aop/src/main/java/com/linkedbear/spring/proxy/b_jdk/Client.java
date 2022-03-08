package com.linkedbear.spring.proxy.b_jdk;

import com.linkedbear.spring.proxy.a_basic.Player;

public class Client {
    
    public static void main(String[] args) throws Exception {
        Player player = new Player("郝武辽");
        Partner partner = PartnerPlatform.getPartner(50);
        System.out.println("jdk动态代理类的实例：" + partner);
    
        partner.receiveMoney(20);
        partner.playWith(player);
    
        partner.receiveMoney(200);
        partner.playWith(player);
        System.out.println(partner.toString());
    }
}
