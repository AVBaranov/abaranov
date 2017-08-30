package ru.job4j.Threads;

/**
 * Created by Андрей on 30.08.2017.
 */
public class Delay {
    public void start () {
        try {
            System.out.println("start program");
            Thread.sleep(400);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void end () {
        try {
            Thread.sleep(400);
            System.out.println("end program");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
