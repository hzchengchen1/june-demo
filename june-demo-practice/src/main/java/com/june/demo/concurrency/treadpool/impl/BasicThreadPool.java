package com.june.demo.concurrency.treadpool.impl;

import com.june.demo.concurrency.treadpool.api.RunnableQueue;
import com.june.demo.concurrency.treadpool.api.ThreadFactory;
import com.june.demo.concurrency.treadpool.api.ThreadPool;

public class BasicThreadPool extends Thread implements ThreadPool{
    public void execute(Runnable runnable) {

    }

    public void shutdown() {

    }

    public int getInitSize() {
        return 0;
    }

    public int getMaxSize() {
        return 0;
    }

    public int getCoreSize() {
        return 0;
    }

    public int getQueueSize() {
        return 0;
    }

    public int getActiveCount() {
        return 0;
    }

    public boolean isShutdown() {
        return false;
    }

//    /**
//     * 初始化线程数量
//     */
//    private final int initSize;
//
//    /**
//     * 最大线程数
//     */
//    private final int maxSize;
//
//    /**
//     * 核心线程数量
//     */
//    private final int coreSize;
//
//    /**
//     * 当前活跃线程数量
//     */
//    private int activeCount;
//
//    /**
//     * 创建线程需要的工厂
//     */
//    private final ThreadFactory threadFactory;
//
//    /**
//     * 任务队列
//     */
//    private final RunnableQueue runnableQueue;

//    /**
//     * 线程池是否已经被shutdown
//     */
//    private volatile boolean isShutdown = false;
//
////    private final Queue<ThreadTask>
//
//    public void execute(Runnable runnable) {
//
//    }
//
//    public void shutdown() {
//
//    }
//
//    public int getInitSize() {
//        return 0;
//    }
//
//    public int getMaxSize() {
//        return 0;
//    }
//
//    public int getCoreSize() {
//        return 0;
//    }
//
//    public int getQueueSize() {
//        return 0;
//    }
//
//    public int getActiveCount() {
//        return 0;
//    }
//
//    public boolean isShutdown() {
//        return false;
//    }
}
