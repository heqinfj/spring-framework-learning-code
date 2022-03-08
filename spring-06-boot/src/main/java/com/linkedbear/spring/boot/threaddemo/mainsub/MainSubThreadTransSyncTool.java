package com.linkedbear.spring.boot.threaddemo.mainsub;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author heqin
 */
public class MainSubThreadTransSyncTool<T> {

    public static String customThreadNamePrefix = "heq-pool-thread-";

    public void excuteTask(int subThreadCount, Map<String,Object> params, DataSourceTransactionManager transactionManager,Class taskClazz) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
        System.out.println(String.format("线程%s开始执行方法%s！", Thread.currentThread().getName(), stackTraceElement.getMethodName()));
        //主线程完成标记
        CountDownLatch mainCompleteSignal = new CountDownLatch(1);

        //子线程完成标记
        CountDownLatch subCompleteSignal = new CountDownLatch(subThreadCount);

        //所有子线程执行任务的结果集
        BlockingDeque<Boolean> taskResults = new LinkedBlockingDeque<Boolean>(subThreadCount);

        RollBack rollBack = new RollBack(false);


        final AtomicInteger threadNumber = new AtomicInteger(1);

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(subThreadCount, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, customThreadNamePrefix + threadNumber.getAndIncrement());
            }
        });

        try {
            for (int i = 1; i <= subThreadCount; i++) {
                //AbstractThreadTask threadTask = new OrderHandleTask(mainCompleteSignal, subCompleteSignal, taskResults, rollBack,transactionManager,params);
                //利用反射实例化对象
                Constructor constructor = taskClazz.getDeclaredConstructor(CountDownLatch.class,CountDownLatch.class,BlockingDeque.class,RollBack.class,DataSourceTransactionManager.class,Map.class);
                AbstractThreadTask threadTask = (AbstractThreadTask)constructor.newInstance(mainCompleteSignal, subCompleteSignal, taskResults, rollBack,transactionManager,params);

                newFixedThreadPool.execute(threadTask);
            }

            long beginTime = System.currentTimeMillis();

            //========================================================================//
            try {
                //等待所有子线程执行完成
                subCompleteSignal.await();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            //========================================================================//

            System.out.println(String.format("主线程%s，开始处理判断是否所有的子线程都执行成功！期间耗时：%s", Thread.currentThread().getName(), (System.currentTimeMillis() - beginTime)));
            try {
                //根据taskResults，判断rollBack的状态
                for (int i = 0; i < subThreadCount; i++) {
                    Boolean aBoolean = taskResults.take();
                    if (!aBoolean) {
                        rollBack.setNeedRollBack(true);
                    }
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            //将程序控制权交给子线程
            mainCompleteSignal.countDown();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭线程池，释放资源 TODO 这个要注意平时
            newFixedThreadPool.shutdown();
        }
    }

}
