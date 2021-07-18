package com.linkedbear.spring.proxy.c_cglib;

/**
 * @author heqin
 */
public class TestFinally {
    public static void main(String[] args) {
        //testTryFinally();
        //testTryCatchFinally();
        String s = testReturnFinally();
        System.out.println("获取到的返回: " + s);
    }

    private static void testTryFinally() {
        try {
            System.out.println("我来了，要进行统计下数据了。。。");
            int a = 1 / 0;
        } finally {
            System.out.println("这里进行了兜底处理。。。");//TODO 有执行到
        }
    }


    private static void testTryCatchFinally() {
        try {
            System.out.println("我来了，要进行统计下数据了。。。");
            int a = 1 / 0;
        } catch (Exception e) {
            throw new IllegalArgumentException("有异常： " + e.getMessage());
        } finally {
            System.out.println("这里进行了兜底处理。。。");//TODO 有执行到
        }
    }

    private static String testReturnFinally() {
        try {
            System.out.println("我来了，要进行统计下数据了。。。");
            //int a = 1 / 0;
            return preCalc();
            //在执行时，是return语句先把返回值写入到内存中，然后停下来等待finally语句块执行完，最后执行return指令。
        } catch (Exception e) {
            throw new IllegalArgumentException("有异常： " + e.getMessage());
        } finally {
            System.out.println("这里进行了兜底处理。。。");//TODO 有执行到
        }
    }

    private static String preCalc(){
        String str = "我计算好了。。。";
        System.out.println("preCalc: " + str);
        return str;
    }
}
