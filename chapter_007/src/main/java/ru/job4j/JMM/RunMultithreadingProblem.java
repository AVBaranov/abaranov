package ru.job4j.JMM;

/**
 * Created by Andrey on 02.09.2017.
 */
public class RunMultithreadingProblem {
    public static void main (String[] args) {
        new Thread(new MultithreadingProblem()).start();
        new Thread(new MultithreadingProblem()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(MultithreadingProblem.getCounter());
    }
}
