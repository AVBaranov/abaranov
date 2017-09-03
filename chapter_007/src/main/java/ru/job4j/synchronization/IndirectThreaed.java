package ru.job4j.synchronization;

/**
 * Created by Andrey on 03.09.2017.
 */
public class IndirectThreaed extends Thread {
    private final Counter counter;

    IndirectThreaed(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        this.counter.increment();
    }
}
