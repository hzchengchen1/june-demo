package com.june.demo.concurrency.treadpool.api;

public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String msg) {
        super(msg);
    }
}
