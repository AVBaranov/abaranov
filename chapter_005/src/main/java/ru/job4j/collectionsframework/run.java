package ru.job4j.collectionsframework;

import java.util.*;

import ru.job4j.collectionsframework.iterator.EvenNumbers;
import ru.job4j.collectionsframework.map.Hashmap;
import ru.job4j.collectionsframework.set.ArraySet;
import ru.job4j.collectionsframework.tree.Tree;

/**
 * Created by Andrey on 09.05.2017.
 */
class sorting implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < o1.length(); i++) {
            if(o1.toCharArray()[i] == ' ') {
                count1++;
            }
        }
        for (int i = 0; i < o2.length(); i++) {
            if(o2.toCharArray()[i] == ' ') {
                count2++;
            }
        }
        if (count1 > count2) {
            return 1;
        } else if (count1 < count2) {
            return -1;
        }
        return 0;
    }
}

class megasort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        String[] ar1 = o1.split("/");
        String[] ar2 = o2.split("/");

        for (int i = 0; i < ar1.length && i < ar2.length; i++) {

        }
        boolean b = true;
        for (int i = 0; i < ar1.length && i < ar2.length; i++) {
            if (ar1[i].compareTo(ar2[i]) > 0) {
                b = false;
                return 1;
            } else if (ar1[i].compareTo(ar2[i]) < 0) {
                b = false;
                return -1;
            }
        }
        if (b) {
            if (ar1.length < ar2.length) {
                return -1;
            } else if (ar1.length > ar2.length) {
                return 1;
            }
        }
        return 0;
    }
}

class cl implements Iterator {
    private final int[] values;
    private int index = 0;
    public cl(int[] values) {
        this.values = values;
    }
    int size = 0;
    public Object next() {
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
        return temp[index++];
    }

    public boolean hasNext() {
        return size > index;
    }

}

class cl2 implements Iterator {
    private final int[][] values;
    private int index = 0;
    private int index2 = 0;
    int count = 0;
    int template = 0;

    public cl2(int[][] values) {
        this.values = values;
    }

    public Object next() {
        count++;
        if (index2 == values[index].length) {
            index++;
            template += index2;
            index2 = 0;
        }
        return values[index][index2++];
    }

    public boolean hasNext() {
        int temp = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j= 0; j < values[i].length; j++) {
                temp++;
            }
        }
        return temp > count;
    }
}

class cl3 implements Iterator {
    private final int[] values;
    private int index = 0;
    public cl3(int[] values) {
        this.values = values;
    }
    int size = 0;
    public Object next() {
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
        return temp[index++];
    }

    public boolean hasNext() {
        return size > index;
    }
}

class test<E> {

    public Object[] array;

    public boolean binarySearch(E value, Object[] array) {
        if (search(value, array, 0, array.length - 1) != -1) {
            return true;
        }
        return false;
    }

    private int search(E val, Object[] arr, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (val.hashCode() < arr[mid].hashCode()) {
            return search(val, arr, lo, mid - 1);
        } else if (val.hashCode() > arr[mid].hashCode()) {
            return search(val, arr, mid +1, hi);
        } else return mid;
    }

    void mergeSort() {
        mergeSort(0, array.length);
    }

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
                if (j >= high || i < mid && array[i].hashCode() < array[j].hashCode()) {
                    b[k] = array[i++];
                } else {
                    b[k] = array[j++];
                }
            }
            System.arraycopy(b, 0, array, low, size);
        }

    }

    void bubbleSort(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].hashCode() > array[j].hashCode()) {
                    Object temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}





public class run {
    public static void main(String[] args) {

        class user implements Comparable<user> {
            private String name;
            public user(String name) {
                this.name = name;
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof user)) return false;
                user temp = (user) o;
                return this.name.equals(temp.name);
            }
            @Override
            public int hashCode() {
                int result = this.name == null ? 0 : this.name.hashCode();
                return result;
            }
            @Override
            public int compareTo(user o) {
                return this.name.compareTo(o.name);
            }

            @Override
            public String toString() {
                return "user{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
        Hashmap<user, String> temp = new Hashmap<user, String>();
        System.out.println(temp.insert(new user("Freeman"), "Gordon"));
        System.out.println(temp.insert(new user("Freeman"), "Gordon"));
        System.out.println(temp.insert(new user("key"), "value"));
        System.out.println(temp.delete(new user("key")));
        System.out.println(temp.insert(new user("Freeman"), "Gordon"));
        System.out.println(temp.delete(new user("key")));
        System.out.println(temp.size());
        System.out.println(temp.get(new user("Freeman")));


        EvenNumbers en = new EvenNumbers(new int[] {1,2,3,4,5,6,7,8,9});
        while (en.hasNext()) {
            System.out.println(en.next());
        }

        int COUNT = 100000;
            long start = System.currentTimeMillis();
            Map map = new HashMap<>(COUNT);
            for (int i = 0; i < COUNT; i++) {
                map.put(i,i);
            }
            System.out.println(System.currentTimeMillis() - start);


        Tree<String> ob = new Tree<>();
        ob.add("a", "b");
        ob.add("a", "c"); // код валится скорее всего из за того что не инициализируется поле children
        //ob.add("a", "d");



        test test = new test();
        Integer[] arr = { 1,12,23,34,55,61,67,77,88,89,101 };
        System.out.println(test.binarySearch(101, arr));



        String[] values = {"as", "qw", "az", "rt", "fg"};
        for (String value : values) {
            System.out.print(value + " ");
        }
        System.out.println();


            for(int i = 0; i < values.length - 1; i++) {
                for (int j = i + 1; j < values.length - 1; j++) {
                    if (values[j].hashCode() > values[j + 1].hashCode()) {
                        String temperate = values[j + 1];
                        values[j + 1] = values[j];
                        values[j] = temperate;
                    }
                }
            }
        for (String value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println(test.binarySearch("qw", values));
        Random generator = new Random();
        Integer[] ar = new Integer[20];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = generator.nextInt(10);
        }
        for (Integer value: ar) {
            System.out.print(value + " ");
        }
        System.out.println();




        test.array = new Integer[20];
        for (int i = 0; i < test.array.length; i++) {
            test.array[i] = generator.nextInt(10);
        }
        for (int i = 0; i < test.array.length; i++) {
            System.out.print(test.array[i] + " ");
        }
        System.out.println();
        test.mergeSort();
        for (int i = 0; i < test.array.length; i++) {
            System.out.print(test.array[i] + " ");
        }
        System.out.println();
        ArraySet<Integer> ars = new ArraySet<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            ars.add(generator.nextInt(10));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        while (ars.hasNext()) {
            System.out.print(ars.next() + " ");
        }
        System.out.println();

        ArraySet<Integer> ars2 = new ArraySet<>();
        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            ars2.oldAAdd(generator.nextInt(10));
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - begin2);

        while (ars2.hasNext()) {
            System.out.print(ars2.next() + " ");
        }




        System.out.println();


    }






    int[] findnaturalnumbers(int[] sourcearray) {

        int counter = 0;
        for (int i = sourcearray.length - 1; i >= 0 ; i--) {
            boolean b = true;
            for (int k = i - 1; k >= 0; k--) {
                if (sourcearray[i] != 1 && sourcearray[k] != 1) {
                    if (sourcearray[i] % sourcearray[k] == 0) {
                        b = false;
                    }
                }
            }
            if (b) {
                counter++;
            }
        }

        int[] template = new int[counter];
        for (int i = sourcearray.length - 1; i >= 0 ; i--) {
            boolean b = true;
            for (int k = i - 1; k >= 0; k--) {
                if (sourcearray[i] != 1 && sourcearray[k] != 1) {
                    if (sourcearray[i] % sourcearray[k] == 0) {
                        b = false;
                    }
                }
            }
            if (b) {
                template[counter - 1] = sourcearray[i];
                counter--;
            }
        }
        return template;
    }

}
