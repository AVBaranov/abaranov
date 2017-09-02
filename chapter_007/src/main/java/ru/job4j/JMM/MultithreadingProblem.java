package ru.job4j.JMM;

/**
 * Created by Andrey on 02.09.2017.
 */
public class MultithreadingProblem implements Runnable {

    private static Integer counter = 0;

    public static Integer getCounter() {
        return counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            counter++;
        }
    }
}
