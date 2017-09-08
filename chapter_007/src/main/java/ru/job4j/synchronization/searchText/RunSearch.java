package ru.job4j.synchronization.searchText;

import sun.nio.ch.ThreadPool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Andrey on 05.09.2017.
 */
public class RunSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("doc");
        list.add("txt");

        List<String> ls = new ParallelStream().search(new File("C:\\Users\\Andrey\\Desktop/2"), "check", list);
        for (String value : ls) {
            System.out.println(value);
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////


        /*Thread t1 = new IncThread(new File("C:\\Users\\Andrey\\Desktop/2"), "check", list);
        Thread t2 = new IncThread(new File("C:\\Users\\Andrey\\Desktop/2"), "check", list);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


//        new ParallelStream().show();


    }
}
