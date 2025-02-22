package com.linkedbear.spring.proxy.c_cglib;

import com.linkedbear.spring.proxy.a_basic.Partner;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 陪玩平台
 */
public class PartnerPlatform {
    
    private static List<Partner> partners = new ArrayList<>();
    
    static {
        partners.add(new Partner("肖洁洁"));
        partners.add(new Partner("田苟"));
        partners.add(new Partner("高总裁"));
    }
    
    /**
     * 由陪玩平台根据预算推荐陪玩
     * @param money 预算
     * @return
     */
    public static Partner getPartner(int money) {
        Partner partner = partners.remove(0);
        System.out.println("目标类的实例：" + partner);
        return (Partner) Enhancer.create(partner.getClass(), new MethodInterceptor() {
            private int budget = money;
            private boolean status = false;

            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                // 如果在付钱时没给够，则标记budget为异常值
                if (method.getName().equals("receiveMoney")) {
                    int money = (int) args[0];
                    this.status = money >= budget;
                }
                if (status) {
                    //https://www.liaoxuefeng.com/wiki/1252599548343744/1339039378571298
                    return methodProxy.invokeSuper(proxy,args);//TODO 代理对象proxy的属性name为null，不知为什么？
                    //return method.invoke(partner, args);
                }
                return null;
            }
        });
    }
}
