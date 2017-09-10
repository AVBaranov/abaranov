package ru.job4j.wait_notify;

/**
 * Created by Andrey on 10.09.2017.
 */
class SimpleLock {

    public void lock(Object lock) {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void unlock(Object lock) {
        synchronized (lock) {
            lock.notify();
        }
    }

}
