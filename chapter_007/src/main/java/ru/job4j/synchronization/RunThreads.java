package ru.job4j.synchronization;

/**
 * Created by Andrey on 03.09.2017.
 */
public class RunThreads {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new IndirectThreaed(counter);
        Thread t2 = new IndirectThreaed(counter);
        Thread t3 = new IndirectThreaed(counter);
        Thread t4 = new IndirectThreaed(counter);
        Thread t5 = new IndirectThreaed(counter);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
