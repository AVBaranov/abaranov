package ru.job4j.collectionsframework.sample;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
//import java.io.File;
//import java.io.IOException;
import java.io.*;
import java.util.Map;
import javax.*;

/**
 * Created by Andrey on 12.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        //SAXParserFactory parserF = SAXParserFactory.newInstance();
        try {
            //SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();
            SAXParserFactory.newInstance().newSAXParser().parse(new File("chapter_005/src/main/java/ru/job4j/collectionsframework/sample/config.xml"), new Handler());
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

        System.out.println(handler.getI());


    }


}
