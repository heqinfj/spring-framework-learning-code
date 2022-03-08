package com.linkedbear.spring.boot.threaddemo.mainsub;

import com.linkedbear.spring.boot.service.UserService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;

/**
 * @author heqin
 */
public class OrderHandleTask extends AbstractThreadTask {

    /**
     * 可能需要注入的某些服务
     */
    private UserService userService;

    public OrderHandleTask(CountDownLatch mainCompleteSignal, CountDownLatch subCompleteSignal, BlockingDeque<Boolean> taskResults, RollBack rollBack, DataSourceTransactionManager transactionManager, Map<String,Object> params) {
        super(mainCompleteSignal, subCompleteSignal, taskResults, rollBack,transactionManager,params);
    }

    @Override
    public void initParam() {
        this.userService = (UserService) getParam("userService");
    }

    @Override
    public boolean processTask() {
        String currentThreadName = Thread.currentThread().getName();
        try {
            userService.saveAndQuery();
            //模拟调用数据库耗时
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        //模拟线程3执行结果为false
        if (currentThreadName.equals(MainSubThreadTransSyncTool.customThreadNamePrefix + "3")) {
            return false;
        }
        return true;
    }
}
