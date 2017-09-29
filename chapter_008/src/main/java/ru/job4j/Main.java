package ru.job4j;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


import java.io.File;

/**
 * Created by Andrey on 26.09.2017.
 */



public class Main {

    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main (String[] args) {

        DBTracker tracker = new DBTracker(new File("C:\\Users\\Andrey\\Desktop/readme.txt"));
        tracker.add(new DBItem("apple", "round", new Timestamp(System.currentTimeMillis())));
        tracker.add(new DBItem("deka", "megadeka", new Timestamp(System.currentTimeMillis())));
        tracker.add(new DBItem("durinabol", "megadurinabol", new Timestamp(System.currentTimeMillis())));
        List<DBItem> list = tracker.findAll();
        for (DBItem value : list) {
            System.out.println(String.format("%s %s ", value.getName(), value.getDescription()));
        }





        /*long start = System.currentTimeMillis();

        try {
            System.out.println(new SQLStorage().countSumOfElements(1000000, "postgres", "password", "admin", "C:\\Users\\Andrey\\Desktop/1.xml", "C:\\Users\\Andrey\\Desktop/2.xml", "C:\\Users\\Andrey\\Desktop/xslFilter.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);*/

    }



}
