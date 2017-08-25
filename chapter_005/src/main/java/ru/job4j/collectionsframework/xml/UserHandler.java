package ru.job4j.collectionsframework.xml;

import java.io.File;

/**
 * Created by Андрей on 21.08.2017.
 */
public class UserHandler {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        new UserParser().parseFile(new File("C:\\Users\\Андрей\\Desktop/orders.xml"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

}
