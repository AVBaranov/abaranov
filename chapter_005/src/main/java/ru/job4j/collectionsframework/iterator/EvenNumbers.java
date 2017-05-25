package ru.job4j.collectionsframework.iterator;

import java.util.Iterator;

/**
 * Created by Андрей on 12.05.2017.
 */
/*public class EvenNumbers implements Iterator {

    private final int[] values;

    private int[] newvalues;

    private int index = 0;

    public EvenNumbers(int[] values) {
        this.values = values;
        this.newvalues = this.init();
    }

    int size = 0;

    private int[] init() {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                count++;
            }
        }
        size = count;
        int j = 0;
        int[] temp = new int[count];
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                temp[j] = values[i];
                j++;
            }
        }
        //size = temp.length;
        return temp;
    }

    public Object next() {
        return newvalues[index++];
    }

    public boolean hasNext() {
        return size > index;
    }
}*/
public class EvenNumbers implements Iterator {

    private final int[] values;

    private int index = 0;

    public EvenNumbers(int[] values) {
        this.values = values;
        init();
    }

    int size = 0;

    private void init() {
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                size++;
            }
        }
    }
    int count = 0;
    public Object next() {
        count++;
        while (index < values.length) {
            if (values[index] % 2 == 0) {
                break;
            }
            index++;
        }
        return values[index++];
    }

    public boolean hasNext() {

        return size > count;
    }
}


