package org.mlooser.learn.j9c;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentPerson {
    private String firstName;
    private String lastName;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public ConcurrentPerson() {
    }

    public ConcurrentPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setData(String first, String last){
        lock.writeLock().lock();
        try {
            this.firstName = first;
            this.lastName = last;
        }finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public String toString() {
        lock.readLock().lock();
        try {
            return firstName + " " + lastName;
        }finally {
            lock.readLock().unlock();
        }
    }
}
