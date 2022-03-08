/**
 * @author heqin
 */
package com.linkedbear.spring.boot.threaddemo.mainsub;

/**
 * 多线程的事务控制
 * https://www.cnblogs.com/fansong/articles/13402788.html
 *利用2个 CountDownLatch 进行主线程与子线程的切换，实现子线程的事务最终提交；
 *
 * 背景：
 *   在项目中使用多线程抓取第三方数据执行数据入库时，如果某个子线程执行异常，其他子线事务全部回滚，spring对多线程无法进行事务控制，
 *   是因为多线程底层连接数据库的时候，是使用的线程变量（TheadLocal）,线程之间事务隔离，每个线程有自己的连接，事务肯定不是同一个了。
 */