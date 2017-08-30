package ru.job4j.Threads;

/**
 * Created by Андрей on 30.08.2017.
 */
public class ReadText implements Runnable{
    private final String value;

    private final int number;
    public ReadText(String value, int number) {
        this.value = value;
        this.number = number;
    }

    @Override
    public void run() {

        char[] ar = value.toCharArray();
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == ' ') {
                count++;
            }
        }
        if (number == 1) System.out.println(value.split(" +").length);
        if (number == 2) System.out.println(count);

    }
}
