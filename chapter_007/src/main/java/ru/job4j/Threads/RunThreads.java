package ru.job4j.Threads;

/**
 * Created by Андрей on 30.08.2017.
 */
public class RunThreads {
    final long EXECUTION_TIME = 1000;
    private final String text;
    public RunThreads(String text) {
        this.text = text;
    }
    public void run() {
        new Delay().start();

        long begin = System.currentTimeMillis();


        Thread t1 = new Thread() {
            @Override
            public void run() {
                char[] ar = text.toCharArray();
                int count = 0;
                for (int i = 0; i < ar.length; i++) {
                    if (ar[i] == ' ') {
                        count++;
                    }
                }
                System.out.println(count);
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(text.split(" +").length);
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Delay().end();

        long end = System.currentTimeMillis();

        if (EXECUTION_TIME <= (end - begin)) {
            t1.interrupt();
            t2.interrupt();
            System.out.println("Threads have been interrupted");
        }
    }
}
