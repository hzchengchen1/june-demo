package com.june.demo.concurrency.treadpool.api;

/**
 * 创建线程的工厂
 */
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
