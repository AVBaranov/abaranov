package ru.job4j.collectionsframework.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Андрей on 22.05.2017.
 */
public class ArraySet<E> implements Iterator<E> {

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] values;

    private int index = 0;

    private int count = 0;

    private int itercount = 0;

    public ArraySet() {
        this.values = EMPTY_ELEMENTDATA;
    }

    /**
     * method adds elements to collection.
     *@param value - adding element
     *@return true if element was added, false otherwise
     */
    public boolean add(E value) {

        if (notExistDuplicate(value)) {
            count++;
            if (values.length <= count) {
                int temp = values.length + 1;
                values = Arrays.copyOf(values, temp);
            }
            values[index++] = value;
            sortByHashCode();
            return true;
        }
        return false;
    }

    /**
     * method checking array for duplicates.
     *@param val - element checking for duplicate
     *@return true if there is no duplicates in array
     */
    boolean notExistDuplicate(E val) {
        if (binarySearch(val, values)) return false;
        return true;
    }

    /**
     * method searching duplicates.
     *@param val - element checking for duplicate
     *@param arr - source array
     *@return true if duplicate detected
     */
    public boolean binarySearch(E val, Object[] arr) {
        if (search(val, arr, 0, arr.length - 1) != -1) {
            return true;
        }
        return false;
    }

    /**
     * method searching duplicates in array.
     *@param val - element checking for duplicate
     *@param arr - source array
     *@param lo - index of first element in array
     *@param hi - index of last element in array
     *@return index of duplicate element
     */
    private int search(E val, Object[] arr, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (val.hashCode() < arr[mid].hashCode()) {
            return search(val, arr, lo, mid - 1);
        } else if (val.hashCode() > arr[mid].hashCode()) {
            return search(val, arr, mid +1, hi);
        } else return mid;
    }

    /**
     * method for sort elements in array by hashCode.
     */
    void sortByHashCode() {
        mergeSort(0, values.length);
    }

    /**
     * merge sort.
     *@param low - index of first element in source array
     *@param high - index of last element in source array
     */
    void mergeSort(int low, int high) {
            if (low + 1 < high) {
                int mid = (low + high) >>> 1;
                mergeSort(low, mid);
                mergeSort(mid, high);

                int size = high - low;
                Object[] b = new Object[size];
                int i = low;
                int j = mid;
                for (int k = 0; k < size; k++) {
                    if (j >= high || i < mid && values[i].hashCode() < values[j].hashCode()) {
                        b[k] = values[i++];
                    } else {
                        b[k] = values[j++];
                    }
                }
                System.arraycopy(b, 0, values, low, size);
            }
    }

    /**
     * old method adding element to collection.
     *@param value - adding element
     */
    public boolean oldAdd(E value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                return false;
            }
        }
        count++;
        if (values.length <= count) {
            int temp = values.length + 1;
            values = Arrays.copyOf(values, temp);
        }
        values[index++] = value;
        return true;
    }

    @Override
    public boolean hasNext() {
        return values.length > itercount;
    }

    @Override
    public E next() {
        return (E) values[itercount++];
    }
}
