package com.dp.utils;

public interface ILock {

    boolean tryLock(long timeoutSec);

    void unlock();
}
