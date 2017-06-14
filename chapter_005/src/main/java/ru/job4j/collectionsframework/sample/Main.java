package ru.job4j.collectionsframework.sample;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.*;


/**
 * Created by Andrey on 12.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxparser = factory.newSAXParser();
            saxparser.parse(new File("chapter_005/src/config.xml"), new Handler());
        }
        catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Handler handler = new Handler();
        for (Map.Entry<Integer, String> value : handler.getData().entrySet()) {
            System.out.println(value.getKey() + ": " + value.getValue());
        }
        try {
            handler.startDocument();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        System.out.println(handler.i);



    }


}
