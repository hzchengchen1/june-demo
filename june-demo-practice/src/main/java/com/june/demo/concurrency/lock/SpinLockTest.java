package com.june.demo.concurrency.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * <p>
 * 自旋锁是指尝试获取锁的线程不会立即阻塞，
 * 而是采用循环的方式去尝试获取锁，
 * 轻量级操作，无需挂起线程，
 * 这样的好处是减少线程上下文切换的消耗，缺点是循环会消耗CPU
 */
public class SpinLockTest implements Runnable {

    static int sum;

    private SpinLock lock;

    public SpinLockTest(SpinLock lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock lock = new SpinLock();
        for (int i = 0; i < 100; i++) {
            SpinLockTest test = new SpinLockTest(lock);
            Thread t = new Thread(test);
            t.start();
        }

        Thread.currentThread().sleep(1000);
        System.out.println(sum);
    }

    @Override
    public void run() {
        this.lock.lock();
        sum ++;
        this.lock.unLock();
    }
}


class SpinLock {

    /**
     * java中原子（CAS）操作
     */
    AtomicReference<Thread> owner = new AtomicReference<Thread>(); //持有自旋锁的线程对象

    private int count;

    public void lock() {
        Thread cur = Thread.currentThread();
        /**
         * lock函数将owner设置为当前线程，并且预测原来的值为空。unlock函数将owner设置为null，并且预测值为当前线程。当有第二个线程调用lock操作时由于owner值不为空，导致循环
         * 一直被执行，直至第一个线程调用unlock函数将owner设置为null，第二个线程才能进入临界区。
         */

        while (!owner.compareAndSet(null, cur)) {
        }
    }

    public void unLock() {
        Thread cur = Thread.currentThread();
        owner.compareAndSet(cur, null);
    }
}