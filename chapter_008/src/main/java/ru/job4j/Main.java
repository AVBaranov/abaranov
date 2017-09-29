package ru.job4j;


import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Created by Andrey on 26.09.2017.
 */
public class Main {

    public static void main (String[] args) {

        long start = System.currentTimeMillis();

        try {
            System.out.println(new SQLStorage().countSumOfElements(10, "postgres", "password", "admin", "C:\\Users\\Андрей\\Desktop/1.xml", "C:\\Users\\Андрей\\Desktop/2.xml", "C:\\Users\\Андрей\\Desktop/xslFilter.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}
