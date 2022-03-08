package com.linkedbear.spring.proxy.c_cglib;

import com.linkedbear.spring.proxy.a_basic.Partner;
import com.linkedbear.spring.proxy.a_basic.Player;
import net.sf.cglib.core.DebuggingClassWriter;

public class Client {
    
    public static void main(String[] args) throws Exception {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E:\\code\\heq\\heqinfj_fork\\1-proxySource_temp");
        Player player = new Player("郝武辽");
        Partner partner = PartnerPlatform.getPartner(50);
        System.out.println("cglib代理类的实例：" + partner);
        
        partner.receiveMoney(20);
        partner.playWith(player);
        
        partner.receiveMoney(200);
        partner.playWith(player);
    }
}
