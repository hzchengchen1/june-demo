package com.june.demo.concurrency.treadpool.api;

/**
 * 任务队列，主要用于缓存提交到线程池中的任务
 */
public interface RunnableQueue {

    /**
     * 当有新的任务进来会首先offer到队列中
     */
    void offer(Runnable runnable);

    /**
     * 工作线程通过take方法获取runnable
     */
    Runnable take();

    /**
     * 获取队列中任务的数量
     */
    int size();
}
