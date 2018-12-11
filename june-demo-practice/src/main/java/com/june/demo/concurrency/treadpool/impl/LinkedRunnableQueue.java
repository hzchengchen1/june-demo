package com.june.demo.concurrency.treadpool.impl;

import com.june.demo.concurrency.treadpool.api.DenyPolicy;
import com.june.demo.concurrency.treadpool.api.RunnableQueue;
import com.june.demo.concurrency.treadpool.api.ThreadPool;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {

    /**
     * 任务队列最大容量，在构造时传入
     */
    private final int limit;

    /**
     * 拒绝策略
     */
    private final DenyPolicy denyPolicy;

    /**
     * 存放任务的队列
     */
    private final LinkedList<Runnable> runnableList = new LinkedList<Runnable>();

    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    public void offer(Runnable runnable) {

    }

    public Runnable take() {
        return null;
    }

    public int size() {
        return 0;
    }
}
