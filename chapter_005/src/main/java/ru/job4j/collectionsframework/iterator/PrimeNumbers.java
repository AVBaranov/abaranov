package ru.job4j.collectionsframework.iterator;

import java.util.Iterator;

/**
 * Created by Андрей on 12.05.2017.
 */
/*public class PrimeNumbers implements Iterator {
    private final int[] values;

    private int[] newvalues;

    private int index = 0;

    public PrimeNumbers(int[] values) {
        this.values = values;
        this.newvalues = this.init();
    }

    int size = 0;

    private int[] init() {
        int counter = 0;
        for (int i = values.length - 1; i >= 0 ; i--) {
            boolean b = true;
            for (int k = i - 1; k >= 0; k--) {
                if (values[i] != 1 && values[k] != 1) {
                    if (values[i] % values[k] == 0) {
                        b = false;
                    }
                }
            }
            if (b) {
                counter++;
            }
        }
        size = counter;
        int[] temp = new int[counter];
        for (int i = values.length - 1; i >= 0 ; i--) {
            boolean b = true;
            for (int k = i - 1; k >= 0; k--) {
                if (values[i] != 1 && values[k] != 1) {
                    if (values[i] % values[k] == 0) {
                        b = false;
                    }
                }
            }
            if (b) {
                temp[counter - 1] = values[i];
                counter--;
            }
        }
        return temp;
    }

    public Object next() {
        return newvalues[index++];
    }

    public boolean hasNext() {
        return size > index;
    }
}*/
public class PrimeNumbers implements Iterator {
    private final int[] values;
    public int count = 0;
    private int index;
    public PrimeNumbers(int[] values) {
        this.values = values;
        init();
    }
    private void init() {
        int j=0;
        index = values[0];
        for(int i = index; i <= values.length + 2; i++) {
            for(j = 2; (i % j) != 0; j++) {
            }
            if(i == j) {
                size++;
            }
        }
    }

    public int size = 0;



    public Object next() {
        count++;
        int j=0;
        for(int i = index; i <= values.length + 2; i++) {
            for(j = 2; (i % j) != 0; j++) {
            }
            index ++;
            if(i == j) {
                break;
            }
        }
        return j;
    }

    public boolean hasNext() {

        return size > count;
    }
}
