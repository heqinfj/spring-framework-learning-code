package com.linkedbear.spring.proxy.c_cglib.cglibproxysource;

import java.lang.reflect.Method;

import com.linkedbear.spring.proxy.a_basic.Partner;
import com.linkedbear.spring.proxy.a_basic.Player;
import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Partner的代理类
 */
public class Partner$$EnhancerByCGLIB$$f21e8be3 extends Partner implements Factory {
    private boolean CGLIB$BOUND;
    public static Object CGLIB$FACTORY_DATA;
    private static ThreadLocal CGLIB$THREAD_CALLBACKS = null;
    private static Callback[] CGLIB$STATIC_CALLBACKS = null;
    private MethodInterceptor CGLIB$CALLBACK_0;
    private static Object CGLIB$CALLBACK_FILTER;
    private static Method CGLIB$playWith$0$Method = null;
    private static MethodProxy CGLIB$playWith$0$Proxy = null;
    private static Object[] CGLIB$emptyArgs = null;
    private static Method CGLIB$receiveMoney$1$Method = null;
    private static MethodProxy CGLIB$receiveMoney$1$Proxy = null;
    private static Method CGLIB$equals$2$Method = null;
    private static MethodProxy CGLIB$equals$2$Proxy = null;
    private static Method CGLIB$toString$3$Method = null;
    private static MethodProxy CGLIB$toString$3$Proxy = null;
    private static Method CGLIB$hashCode$4$Method = null;
    private static MethodProxy CGLIB$hashCode$4$Proxy = null;
    private static Method CGLIB$clone$5$Method = null;
    private static MethodProxy CGLIB$clone$5$Proxy = null;

    static void CGLIB$STATICHOOK1() {
        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
        CGLIB$emptyArgs = new Object[0];
        Class var0 = null;
        try {
            var0 = Class.forName("com.linkedbear.spring.proxy.a_basic.Partner$$EnhancerByCGLIB$$f21e8be3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class var1 = null;
        Method[] var10000 = new Method[0];
        try {
            var10000 = ReflectUtils.findMethods(new String[]{"equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, (var1 = Class.forName("java.lang.Object")).getDeclaredMethods());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CGLIB$equals$2$Method = var10000[0];
        CGLIB$equals$2$Proxy = MethodProxy.create(var1, var0, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$2");
        CGLIB$toString$3$Method = var10000[1];
        CGLIB$toString$3$Proxy = MethodProxy.create(var1, var0, "()Ljava/lang/String;", "toString", "CGLIB$toString$3");
        CGLIB$hashCode$4$Method = var10000[2];
        CGLIB$hashCode$4$Proxy = MethodProxy.create(var1, var0, "()I", "hashCode", "CGLIB$hashCode$4");
        CGLIB$clone$5$Method = var10000[3];
        CGLIB$clone$5$Proxy = MethodProxy.create(var1, var0, "()Ljava/lang/Object;", "clone", "CGLIB$clone$5");
        try {
            var10000 = ReflectUtils.findMethods(new String[]{"playWith", "(Lcom/linkedbear/spring/proxy/a_basic/Player;)V", "receiveMoney", "(I)V"}, (var1 = Class.forName("com.linkedbear.spring.proxy.a_basic.Partner")).getDeclaredMethods());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CGLIB$playWith$0$Method = var10000[0];
        CGLIB$playWith$0$Proxy = MethodProxy.create(var1, var0, "(Lcom/linkedbear/spring/proxy/a_basic/Player;)V", "playWith", "CGLIB$playWith$0");
        CGLIB$receiveMoney$1$Method = var10000[1];
        CGLIB$receiveMoney$1$Proxy = MethodProxy.create(var1, var0, "(I)V", "receiveMoney", "CGLIB$receiveMoney$1");
    }

    final void CGLIB$playWith$0(Player var1) {
        super.playWith(var1);
    }

    public final void playWith(Player var1) {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            try {
                var10000.intercept(this, CGLIB$playWith$0$Method, new Object[]{var1}, CGLIB$playWith$0$Proxy);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            super.playWith(var1);
        }
    }

    final void CGLIB$receiveMoney$1(int var1) {
        super.receiveMoney(var1);
    }

    public final void receiveMoney(int var1) {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            try {
                var10000.intercept(this, CGLIB$receiveMoney$1$Method, new Object[]{new Integer(var1)}, CGLIB$receiveMoney$1$Proxy);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            super.receiveMoney(var1);
        }
    }

    final boolean CGLIB$equals$2(Object var1) {
        return super.equals(var1);
    }

    public final boolean equals(Object var1) {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            Object var2 = null;
            try {
                var2 = var10000.intercept(this, CGLIB$equals$2$Method, new Object[]{var1}, CGLIB$equals$2$Proxy);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return var2 == null ? false : (Boolean) var2;
        } else {
            return super.equals(var1);
        }
    }

    final String CGLIB$toString$3() {
        return super.toString();
    }

    public final String toString() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        try {
            return var10000 != null ? (String) var10000.intercept(this, CGLIB$toString$3$Method, CGLIB$emptyArgs, CGLIB$toString$3$Proxy) : super.toString();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    final int CGLIB$hashCode$4() {
        return super.hashCode();
    }

    public final int hashCode() {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        if (var10000 != null) {
            Object var1 = null;
            try {
                var1 = var10000.intercept(this, CGLIB$hashCode$4$Method, CGLIB$emptyArgs, CGLIB$hashCode$4$Proxy);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return var1 == null ? 0 : ((Number) var1).intValue();
        } else {
            return super.hashCode();
        }
    }

    final Object CGLIB$clone$5() throws CloneNotSupportedException {
        return super.clone();
    }

    protected final Object clone() throws CloneNotSupportedException {
        MethodInterceptor var10000 = this.CGLIB$CALLBACK_0;
        if (var10000 == null) {
            CGLIB$BIND_CALLBACKS(this);
            var10000 = this.CGLIB$CALLBACK_0;
        }

        try {
            return var10000 != null ? var10000.intercept(this, CGLIB$clone$5$Method, CGLIB$emptyArgs, CGLIB$clone$5$Proxy) : super.clone();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public static MethodProxy CGLIB$findMethodProxy(Signature var0) {
        String var10000 = var0.toString();
        switch (var10000.hashCode()) {
            case -1804057781:
                if (var10000.equals("receiveMoney(I)V")) {
                    return CGLIB$receiveMoney$1$Proxy;
                }
                break;
            case -508378822:
                if (var10000.equals("clone()Ljava/lang/Object;")) {
                    return CGLIB$clone$5$Proxy;
                }
                break;
            case 1413510715:
                if (var10000.equals("playWith(Lcom/linkedbear/spring/proxy/a_basic/Player;)V")) {
                    return CGLIB$playWith$0$Proxy;
                }
                break;
            case 1826985398:
                if (var10000.equals("equals(Ljava/lang/Object;)Z")) {
                    return CGLIB$equals$2$Proxy;
                }
                break;
            case 1913648695:
                if (var10000.equals("toString()Ljava/lang/String;")) {
                    return CGLIB$toString$3$Proxy;
                }
                break;
            case 1984935277:
                if (var10000.equals("hashCode()I")) {
                    return CGLIB$hashCode$4$Proxy;
                }
        }

        return null;
    }

    public Partner$$EnhancerByCGLIB$$f21e8be3() {
        CGLIB$BIND_CALLBACKS(this);
    }

    public Partner$$EnhancerByCGLIB$$f21e8be3(String var1) {
        super(var1);
        CGLIB$BIND_CALLBACKS(this);
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] var0) {
        CGLIB$THREAD_CALLBACKS.set(var0);
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] var0) {
        CGLIB$STATIC_CALLBACKS = var0;
    }

    private static final void CGLIB$BIND_CALLBACKS(Object var0) {
        Partner$$EnhancerByCGLIB$$f21e8be3 var1 = (Partner$$EnhancerByCGLIB$$f21e8be3) var0;
        if (!var1.CGLIB$BOUND) {
            var1.CGLIB$BOUND = true;
            Object var10000 = CGLIB$THREAD_CALLBACKS.get();
            if (var10000 == null) {
                var10000 = CGLIB$STATIC_CALLBACKS;
                if (var10000 == null) {
                    return;
                }
            }

            var1.CGLIB$CALLBACK_0 = (MethodInterceptor) ((Callback[]) var10000)[0];
        }

    }

    public Object newInstance(Callback[] var1) {
        CGLIB$SET_THREAD_CALLBACKS(var1);
        Partner$$EnhancerByCGLIB$$f21e8be3 var10000 = new Partner$$EnhancerByCGLIB$$f21e8be3();
        CGLIB$SET_THREAD_CALLBACKS((Callback[]) null);
        return var10000;
    }

    public Object newInstance(Callback var1) {
        CGLIB$SET_THREAD_CALLBACKS(new Callback[]{var1});
        Partner$$EnhancerByCGLIB$$f21e8be3 var10000 = new Partner$$EnhancerByCGLIB$$f21e8be3();
        CGLIB$SET_THREAD_CALLBACKS((Callback[]) null);
        return var10000;
    }

    public Object newInstance(Class[] var1, Object[] var2, Callback[] var3) {
        CGLIB$SET_THREAD_CALLBACKS(var3);
        Partner$$EnhancerByCGLIB$$f21e8be3 var10000 = new Partner$$EnhancerByCGLIB$$f21e8be3();
        switch (var1.length) {
            case 0:
                //var10000.<init> ();
                break;
            case 1:
                if (var1[0].getName().equals("java.lang.String")) {
                    //var10000.<init> ((String) var2[0]);
                    break;
                }

                throw new IllegalArgumentException("Constructor not found");
            default:
                throw new IllegalArgumentException("Constructor not found");
        }

        CGLIB$SET_THREAD_CALLBACKS((Callback[]) null);
        return var10000;
    }

    public Callback getCallback(int var1) {
        CGLIB$BIND_CALLBACKS(this);
        MethodInterceptor var10000;
        switch (var1) {
            case 0:
                var10000 = this.CGLIB$CALLBACK_0;
                break;
            default:
                var10000 = null;
        }

        return var10000;
    }

    public void setCallback(int var1, Callback var2) {
        switch (var1) {
            case 0:
                this.CGLIB$CALLBACK_0 = (MethodInterceptor) var2;
            default:
        }
    }

    public Callback[] getCallbacks() {
        CGLIB$BIND_CALLBACKS(this);
        return new Callback[]{this.CGLIB$CALLBACK_0};
    }

    public void setCallbacks(Callback[] var1) {
        this.CGLIB$CALLBACK_0 = (MethodInterceptor) var1[0];
    }

    static {
        CGLIB$STATICHOOK1();
    }
}

