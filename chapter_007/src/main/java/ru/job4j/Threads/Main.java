package ru.job4j.Threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 30.08.2017.
 */

class ErrorThread extends Thread {

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


public class Main {

    public static void main(String[] args) {
//        new RunThreads("sfgdfgh   sdsdg   wfgedgdfg  qwrwerwertwet   sdfgdfg     ghmghjg   ").run();

        /*Thread t = new Thread(new ReadStrng("dxfgsddfsgd"));
        t.start();
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (t.isAlive()) System.out.println("sdgsg");*/


        Thread t1 = new Thread(new ErrorThread());
        Thread t2 = new Thread(new ErrorThread());
        Thread t3 = new Thread(new ErrorThread());
        t1.start();
        t2.start();
        t3.start();
        try {
//            t1.join();
//            t2.join();
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ErrorThread.getCounter());


    }
}