package ru.job4j.Threads.program_interrupt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 01.09.2017.
 */
public class CountChar implements Runnable {
    private final String string;

    public CountChar(String string) {
        this.string = string;
    }

    @Override
    public void run() {
        char[] text = string.toCharArray();
        int counter = 0;
        for (int i = 0; i < text.length; i++) {
            /*List<Integer> ls = new ArrayList<>();
            for (int j = 0; j < 1000000; j++) {
                ls.add(j);
            }*/
            if (Thread.interrupted()) {
                System.out.println(String.format("program counted %s symbols. thread have been interrupted!", counter));
                return;
            }
            counter++;
        }
        System.out.println(String.format("program counted %s symbols", counter));
    }
}
