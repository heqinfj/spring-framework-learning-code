package com.linkedbear.spring.proxy.c_cglib.cglibproxysource;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.linkedbear.spring.proxy.c_cglib.cglibproxysource.Partner$$EnhancerByCGLIB$$f21e8be3;
import java.lang.reflect.InvocationTargetException;

import com.linkedbear.spring.proxy.a_basic.Player;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.reflect.FastClass;

/**
 * 代理类（Partner$$EnhancerByCGLIB$$f21e8be3）的FastClass
 */
public abstract class Partner$$EnhancerByCGLIB$$f21e8be3$$FastClassByCGLIB$$731d1421 extends FastClass {
    public Partner$$EnhancerByCGLIB$$f21e8be3$$FastClassByCGLIB$$731d1421(Class var1) {
        super(var1);
    }

    public int getIndex(Signature var1) {
        String var10000 = var1.toString();
        switch(var10000.hashCode()) {
            case -2055565910:
                if (var10000.equals("CGLIB$SET_THREAD_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V")) {
                    return 11;
                }
                break;
            case -1804057781:
                if (var10000.equals("receiveMoney(I)V")) {
                    return 8;
                }
                break;
            case -1457535688:
                if (var10000.equals("CGLIB$STATICHOOK1()V")) {
                    return 21;
                }
                break;
            case -1411812934:
                if (var10000.equals("CGLIB$hashCode$4()I")) {
                    return 17;
                }
                break;
            case -894172689:
                if (var10000.equals("newInstance(Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 5;
                }
                break;
            case -623122092:
                if (var10000.equals("CGLIB$findMethodProxy(Lnet/sf/cglib/core/Signature;)Lnet/sf/cglib/proxy/MethodProxy;")) {
                    return 20;
                }
                break;
            case -508378822:
                if (var10000.equals("clone()Ljava/lang/Object;")) {
                    return 3;
                }
                break;
            case -419626537:
                if (var10000.equals("setCallbacks([Lnet/sf/cglib/proxy/Callback;)V")) {
                    return 9;
                }
                break;
            case 41465883:
                if (var10000.equals("CGLIB$receiveMoney$1(I)V")) {
                    return 22;
                }
                break;
            case 292267852:
                if (var10000.equals("CGLIB$playWith$0(Lcom/linkedbear/spring/proxy/a_basic/Player;)V")) {
                    return 15;
                }
                break;
            case 374345669:
                if (var10000.equals("CGLIB$equals$2(Ljava/lang/Object;)Z")) {
                    return 18;
                }
                break;
            case 560567118:
                if (var10000.equals("setCallback(ILnet/sf/cglib/proxy/Callback;)V")) {
                    return 10;
                }
                break;
            case 811063227:
                if (var10000.equals("newInstance([Ljava/lang/Class;[Ljava/lang/Object;[Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 4;
                }
                break;
            case 973717575:
                if (var10000.equals("getCallbacks()[Lnet/sf/cglib/proxy/Callback;")) {
                    return 13;
                }
                break;
            case 1221173700:
                if (var10000.equals("newInstance([Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 6;
                }
                break;
            case 1230699260:
                if (var10000.equals("getCallback(I)Lnet/sf/cglib/proxy/Callback;")) {
                    return 14;
                }
                break;
            case 1413510715:
                if (var10000.equals("playWith(Lcom/linkedbear/spring/proxy/a_basic/Player;)V")) {
                    return 7;
                }
                break;
            case 1517819849:
                if (var10000.equals("CGLIB$toString$3()Ljava/lang/String;")) {
                    return 16;
                }
                break;
            case 1584330438:
                if (var10000.equals("CGLIB$SET_STATIC_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V")) {
                    return 12;
                }
                break;
            case 1826985398:
                if (var10000.equals("equals(Ljava/lang/Object;)Z")) {
                    return 0;
                }
                break;
            case 1913648695:
                if (var10000.equals("toString()Ljava/lang/String;")) {
                    return 1;
                }
                break;
            case 1984935277:
                if (var10000.equals("hashCode()I")) {
                    return 2;
                }
                break;
            case 2011844968:
                if (var10000.equals("CGLIB$clone$5()Ljava/lang/Object;")) {
                    return 19;
                }
        }

        return -1;
    }

    public int getIndex(String var1, Class[] var2) {
        switch(var1.hashCode()) {
            case -1776922004:
                if (var1.equals("toString")) {
                    switch(var2.length) {
                        case 0:
                            return 1;
                    }
                }
                break;
            case -1295482945:
                if (var1.equals("equals")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("java.lang.Object")) {
                                return 0;
                            }
                    }
                }
                break;
            case -1053468136:
                if (var1.equals("getCallbacks")) {
                    switch(var2.length) {
                        case 0:
                            return 13;
                    }
                }
                break;
            case -788393059:
                if (var1.equals("receiveMoney")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("int")) {
                                return 8;
                            }
                    }
                }
                break;
            case -124978608:
                if (var1.equals("CGLIB$equals$2")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("java.lang.Object")) {
                                return 18;
                            }
                    }
                }
                break;
            case -60403779:
                if (var1.equals("CGLIB$SET_STATIC_CALLBACKS")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("[Lnet.sf.cglib.proxy.Callback;")) {
                                return 12;
                            }
                    }
                }
                break;
            case -29025554:
                if (var1.equals("CGLIB$hashCode$4")) {
                    switch(var2.length) {
                        case 0:
                            return 17;
                    }
                }
                break;
            case 85179481:
                if (var1.equals("CGLIB$SET_THREAD_CALLBACKS")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("[Lnet.sf.cglib.proxy.Callback;")) {
                                return 11;
                            }
                    }
                }
                break;
            case 94756189:
                if (var1.equals("clone")) {
                    switch(var2.length) {
                        case 0:
                            return 3;
                    }
                }
                break;
            case 147696667:
                if (var1.equals("hashCode")) {
                    switch(var2.length) {
                        case 0:
                            return 2;
                    }
                }
                break;
            case 161998109:
                if (var1.equals("CGLIB$STATICHOOK1")) {
                    switch(var2.length) {
                        case 0:
                            return 21;
                    }
                }
                break;
            case 495524492:
                if (var1.equals("setCallbacks")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("[Lnet.sf.cglib.proxy.Callback;")) {
                                return 9;
                            }
                    }
                }
                break;
            case 1154623345:
                if (var1.equals("CGLIB$findMethodProxy")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("net.sf.cglib.core.Signature")) {
                                return 20;
                            }
                    }
                }
                break;
            case 1456070953:
                if (var1.equals("CGLIB$playWith$0")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("com.linkedbear.spring.proxy.a_basic.Player")) {
                                return 15;
                            }
                    }
                }
                break;
            case 1543336190:
                if (var1.equals("CGLIB$toString$3")) {
                    switch(var2.length) {
                        case 0:
                            return 16;
                    }
                }
                break;
            case 1755148397:
                if (var1.equals("CGLIB$receiveMoney$1")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("int")) {
                                return 22;
                            }
                    }
                }
                break;
            case 1811874389:
                if (var1.equals("newInstance")) {
                    switch(var2.length) {
                        case 1:
                            String var10001 = var2[0].getName();
                            switch(var10001.hashCode()) {
                                case -845341380:
                                    if (var10001.equals("net.sf.cglib.proxy.Callback")) {
                                        return 5;
                                    }
                                    break;
                                case 1730110032:
                                    if (var10001.equals("[Lnet.sf.cglib.proxy.Callback;")) {
                                        return 6;
                                    }
                            }
                        case 2:
                        default:
                            break;
                        case 3:
                            if (var2[0].getName().equals("[Ljava.lang.Class;") && var2[1].getName().equals("[Ljava.lang.Object;") && var2[2].getName().equals("[Lnet.sf.cglib.proxy.Callback;")) {
                                return 4;
                            }
                    }
                }
                break;
            case 1817099975:
                if (var1.equals("setCallback")) {
                    switch(var2.length) {
                        case 2:
                            if (var2[0].getName().equals("int") && var2[1].getName().equals("net.sf.cglib.proxy.Callback")) {
                                return 10;
                            }
                    }
                }
                break;
            case 1878849050:
                if (var1.equals("playWith")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("com.linkedbear.spring.proxy.a_basic.Player")) {
                                return 7;
                            }
                    }
                }
                break;
            case 1905679803:
                if (var1.equals("getCallback")) {
                    switch(var2.length) {
                        case 1:
                            if (var2[0].getName().equals("int")) {
                                return 14;
                            }
                    }
                }
                break;
            case 1951977611:
                if (var1.equals("CGLIB$clone$5")) {
                    switch(var2.length) {
                        case 0:
                            return 19;
                    }
                }
        }

        return -1;
    }

    public int getIndex(Class[] var1) {
        switch(var1.length) {
            case 0:
                return 0;
            case 1:
                if (var1[0].getName().equals("java.lang.String")) {
                    return 1;
                }
            default:
                return -1;
        }
    }

//    public Object invoke(int var1, Object var2, Object[] var3) throws InvocationTargetException {
//        f21e8be3 var10000 = (f21e8be3)var2;
//        int var10001 = var1;
//
//        try {
//            switch(var10001) {
//                case 0:
//                    return new Boolean(var10000.equals(var3[0]));
//                case 1:
//                    return var10000.toString();
//                case 2:
//                    return new Integer(var10000.hashCode());
//                case 3:
//                    return var10000.clone();
//                case 4:
//                    return var10000.newInstance((Class[])var3[0], (Object[])var3[1], (Callback[])var3[2]);
//                case 5:
//                    return var10000.newInstance((Callback)var3[0]);
//                case 6:
//                    return var10000.newInstance((Callback[])var3[0]);
//                case 7:
//                    var10000.playWith((Player)var3[0]);
//                    return null;
//                case 8:
//                    var10000.receiveMoney(((Number)var3[0]).intValue());
//                    return null;
//                case 9:
//                    var10000.setCallbacks((Callback[])var3[0]);
//                    return null;
//                case 10:
//                    var10000.setCallback(((Number)var3[0]).intValue(), (Callback)var3[1]);
//                    return null;
//                case 11:
//                    f21e8be3.CGLIB$SET_THREAD_CALLBACKS((Callback[])var3[0]);
//                    return null;
//                case 12:
//                    f21e8be3.CGLIB$SET_STATIC_CALLBACKS((Callback[])var3[0]);
//                    return null;
//                case 13:
//                    return var10000.getCallbacks();
//                case 14:
//                    return var10000.getCallback(((Number)var3[0]).intValue());
//                case 15:
//                    var10000.CGLIB$playWith$0((Player)var3[0]);
//                    return null;
//                case 16:
//                    return var10000.CGLIB$toString$3();
//                case 17:
//                    return new Integer(var10000.CGLIB$hashCode$4());
//                case 18:
//                    return new Boolean(var10000.CGLIB$equals$2(var3[0]));
//                case 19:
//                    return var10000.CGLIB$clone$5();
//                case 20:
//                    return f21e8be3.CGLIB$findMethodProxy((Signature)var3[0]);
//                case 21:
//                    f21e8be3.CGLIB$STATICHOOK1();
//                    return null;
//                case 22:
//                    var10000.CGLIB$receiveMoney$1(((Number)var3[0]).intValue());
//                    return null;
//            }
//        } catch (Throwable var4) {
//            throw new InvocationTargetException(var4);
//        }
//
//        throw new IllegalArgumentException("Cannot find matching method/constructor");
//    }
//
//    public Object newInstance(int var1, Object[] var2) throws InvocationTargetException {
//        f21e8be3 var10000 = new f21e8be3;
//        f21e8be3 var10001 = var10000;
//        int var10002 = var1;
//
//        try {
//            switch(var10002) {
//                case 0:
//                    var10001.<init>();
//                    return var10000;
//                case 1:
//                    var10001.<init>((String)var2[0]);
//                    return var10000;
//            }
//        } catch (Throwable var3) {
//            throw new InvocationTargetException(var3);
//        }
//
//        throw new IllegalArgumentException("Cannot find matching method/constructor");
//    }

    public int getMaxIndex() {
        return 22;
    }
}

