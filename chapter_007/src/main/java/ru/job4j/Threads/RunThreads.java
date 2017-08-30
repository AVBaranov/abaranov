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

        Thread thread1 = new Thread(new ReadText(this.text, 1));
        thread1.start();

        Thread thread2 = new Thread(new ReadText(this.text, 2));
        thread2.start();

        new Delay().end();

        long end = System.currentTimeMillis();

        if (EXECUTION_TIME <= (end - begin)) {
            thread1.interrupt();
            thread2.interrupt();
            System.out.println("Threads have been interrupted");
        }
    }
}
