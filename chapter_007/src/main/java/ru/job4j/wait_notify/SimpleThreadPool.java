package ru.job4j.wait_notify;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/**
 * Created by Andrey on 09.09.2017.
 */
public class SimpleThreadPool {

    static class MakeWork {

        private final int height;

        private final String name;

        public MakeWork(int height, String name) {
            this.height = height;
            this.name = name;
        }

        public void doWork() {
            System.out.println(String.format("%s = %s", this.height, this.name));
        }

    }

    private Queue<Runnable> workQueue = new ConcurrentLinkedQueue<>();

    private final int SIZE;

    private int count = 1;

    public SimpleThreadPool(int nThreads) {
        this.SIZE = nThreads;
    }

    public void execute() {
        for (Runnable value : workQueue) {
            ((Thread) value).start();
        }
    }

    public void add(MakeWork work) {
        if (this.count > this.SIZE) {
            System.out.println("queue is overload");
            return;
        }
        this.workQueue.add(new Thread() {
            @Override
            public void run() {
                work.doWork();
            }
        });
        this.count++;
    }

    public static void main(String[] args) {
        SimpleThreadPool t = new SimpleThreadPool(Runtime.getRuntime().availableProcessors());
        t.add(new MakeWork(10, "string"));
        t.add(new MakeWork(120, "strsdfsdfing"));
        t.add(new MakeWork(1270, "fgjsdfing"));
        t.add(new MakeWork(1250, "strsdertgertggergegfsdfing"));
        t.add(new MakeWork(12570, "strsderttggergegfsdfing"));

        t.execute();
    }


}

