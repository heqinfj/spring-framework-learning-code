package com.linkedbear.architecture.g_logutils.utils;

import java.util.Arrays;

public class LogUtils {
    
    public static void printLog(String className, String methodName, Object... args) {
        System.out.println(className + " " + methodName + " ...");
        System.out.println("�����б�: " + Arrays.toString(args));
    }
}
