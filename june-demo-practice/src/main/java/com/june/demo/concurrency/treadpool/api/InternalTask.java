package com.june.demo.concurrency.treadpool.api;

import com.june.demo.concurrency.treadpool.api.RunnableQueue;

/**
 * InternalTask 用于线程池内部，
 * 会使用到RunnableQueue, 不断从queue中取出某个runnable，并运行runnable的run方法
 */
public class InternalTask implements Runnable {
    public void run() {

    }

//    private final RunnableQueue runnableQueue;
//
//    private volatile boolean running = true;
//
//    public InternalTask(RunnableQueue runnableQueue) {
//        this.runnableQueue = runnableQueue;
//    }
//
//    @Override
//    public void run() {
//
//        /**
//         * 如果当前任务为running并且没有被中断，则其将不断从queue中获取runnable， 然后执行run
//         */
//        while (running && !Thread.currentThread().isInterrupted()) {
//            try {
//                Runnable task = runnableQueue.take();
//                task.run();
//            } catch (Exception e) {
//                e.printStackTrace();
//                running = false;
//                // break;
//            }
//        }
//    }

//    /**
//     * 停止当前任务，主要会在线程池的shutdown方法中使用
//     */
//    public void stop() {
//        this.running = false;
//    }
}
