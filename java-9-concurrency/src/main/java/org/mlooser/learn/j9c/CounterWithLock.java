package org.mlooser.learn.j9c;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLock {
    private int value = 0;
    private Lock lock = new ReentrantLock();

    public void addValue(int toAdd) {
        lock.lock();
        try {
            value += toAdd;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        return value;
    }

}
