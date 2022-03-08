package com.linkedbear.spring.boot.threaddemo.mainsub;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author heqin
 */
public abstract class AbstractThreadTask implements Runnable {

    private CountDownLatch mainCompleteSignal;

    private CountDownLatch subCompleteSignal;

    private BlockingDeque<Boolean> taskResults;

    private RollBack rollBack;

    private Map<String, Object> params;//= new ConcurrentHashMap<>();

    protected DataSourceTransactionManager transactionManager;

    protected TransactionStatus status;

    public AbstractThreadTask(CountDownLatch mainCompleteSignal, CountDownLatch subCompleteSignal, BlockingDeque<Boolean> taskResults, RollBack rollBack, DataSourceTransactionManager transactionManager, Map<String, Object> params) {
        this.mainCompleteSignal = mainCompleteSignal;
        this.subCompleteSignal = subCompleteSignal;
        this.taskResults = taskResults;
        this.rollBack = rollBack;
        this.transactionManager = transactionManager;
        this.params = params;
        initParam();
    }

    protected Object getParam(String key) {
        return params.get(key);
    }

    /**
     * 事务提交
     */
    private void submit() {
        System.out.println(String.format("线程%s开始事务提交submit。", Thread.currentThread().getName()));
        transactionManager.commit(status);
    }

    /**
     * 事务回滚
     */
    private void rollBack() {
        System.out.println(String.format("线程%s开始事务回滚rollBack。", Thread.currentThread().getName()));
        transactionManager.rollback(status);
    }


    /**
     * 初始化方法：作用是把线程池工具任务执行类所需的外部资源通过 AbstractThreadTask.class的构造方法中 Map<String,Object> params参数进行初始化传递进来
     */
    public abstract void initParam();

    /**
     * 执行任务,返回false表示任务执行错误，需要回滚
     *
     * @return
     */
    public abstract boolean processTask();

    @Override
    public void run() {
        //TODO 本地事务的处理  线程之间事务隔离，每个线程都有自己的数据库连接，所以线程之间用的不是同一个事务；
        //关注下 DefaultTransactionDefinition 与 DefaultTransactionAttribute（继承了 DefaultTransactionDefinition）
        //DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        DefaultTransactionAttribute def = new DefaultTransactionAttribute();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        status = transactionManager.getTransaction(def);

        //子线程执行任务逻辑，并将执行结果放到taskResults中
        boolean taskResult = processTask();
        taskResults.add(taskResult);
        //使用 subCompleteSignal.countDown()释放子线程锁定，同时使用 mainCompleteSignal.await();阻塞子线程，将程序的控制权交还给主线程。
        subCompleteSignal.countDown();

        //========================================================================//
        try {
            //等待主线程的逻辑执行完成
            mainCompleteSignal.await();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        //========================================================================//

        System.out.println(String.format("子线程%s，开始执行处理是否进行事务提交还是回滚。。。", Thread.currentThread().getName()));
        if (rollBack != null && rollBack.isNeedRollBack()) {
            //System.err.println(String.format("子线程%s，开始进行事务回滚。。。", Thread.currentThread().getName()));
            rollBack();
        } else if (rollBack != null && !rollBack.isNeedRollBack()) {
            //System.err.println(String.format("子线程%s，开始进行事务提交。。。", Thread.currentThread().getName()));
            submit();
        }
    }
}
