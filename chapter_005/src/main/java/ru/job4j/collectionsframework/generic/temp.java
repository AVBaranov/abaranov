package ru.job4j.collectionsframework.generic;

/**
 * Created by Андрей on 15.05.2017.
 */
public class temp<E> {
    Object[] objects;
    int index = 0;

    public temp(int size) {
        this.objects = new Object[size];
    }
    public void add(E value) {
        this.objects[index] = value;
    }
    public E get(int position) {
        return (E) this.objects[position];
    }
    public void delete(E value) {
        Object[] newarr = new Object[objects.length - 1];
        for (int i = 0; i < objects.length; i++) {
            if (value != null && objects[i].equals(value)) {
                Object temp = objects[i];
                objects[i] = objects[objects.length - 1];
                objects[objects.length - 1] = temp;
            }
        }
        /*for (int i = 0; i < newarr.length; i++) {
            newarr[i] = objects[i];
        }*/
        //this.objects = newarr;
        //this.objects[index] = value;
    }
}
