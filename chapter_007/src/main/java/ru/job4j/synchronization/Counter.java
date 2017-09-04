package ru.job4j.synchronization;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Created by Andrey on 03.09.2017.
 */
@ThreadSafe public class Counter {
    private Object lock = new Object();

    @GuardedBy("lock") private int count = 0;

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }

    public void increment() {
        synchronized (lock) {
            this.count++;
        }
    }
}
