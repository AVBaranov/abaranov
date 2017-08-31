package ru.job4j.Threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 30.08.2017.
 */

public class Main {
    public static void main(String[] args) {
        new RunThreads("sfgdfgh   sdsdg   wfgedgdfg  qwrwerwertwet   sdfgdfg     ghmghjg   ").run();

        /*Thread t = new Thread(new ReadStrng("dxfgsddfsgd"));
        t.start();
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (t.isAlive()) System.out.println("sdgsg");*/
    }
}
