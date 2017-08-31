package ru.job4j.Threads.program_interrupt;

/**
 * Created by Андрей on 01.09.2017.
 */
public class Time implements Runnable {
    private final Integer count;
    private final String text;
    public Time(Integer count, String text) {
        this.count = count;
        this.text = text;
    }

    @Override
    public void run() {

        Thread t = new Thread(new CountChar(this.text));
        t.start();
        try {
            Thread.sleep(count);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (t.isAlive()) {
            t.interrupt();
        }

    }
}
