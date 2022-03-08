package com.linkedbear.spring.boot.threaddemo.mainsub;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqin
 */
public class AppMain {
    public static void main(String[] args) {
        MainSubThreadTransSyncTool mainSubThreadTransSyncTool = new MainSubThreadTransSyncTool();
        int subThreadCount = 5;
        Map<String, Object> params = new HashMap<>();
        TestService testService = new TestService();
        params.putIfAbsent("testService", testService);
        DataSourceTransactionManager transactionManager = null;
        Class taskClazz = OrderHandleTask.class;
        mainSubThreadTransSyncTool.excuteTask(subThreadCount, params, transactionManager, taskClazz);
    }
}
