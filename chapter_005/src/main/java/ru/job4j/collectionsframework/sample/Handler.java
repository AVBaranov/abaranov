package ru.job4j.collectionsframework.sample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Andrey on 12.06.2017.
 */
public class Handler extends DefaultHandler {

    private int id;
    private String element;
    public Map<Integer, String> data = new HashMap<>();
    public int i;

//    @Override
//    public void startDocument() throws SAXException {
//        System.out.println("START PARSING . . .");
//        i = 10;
//    }
//
//    @Override
//    public void endDocument() throws SAXException {
//        System.out.println("END PARSING . . .");
//    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        if (element.equals("product")) {
            id = Integer.parseInt(attributes.getValue(0));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = "";
        id = -1;
    }

    @Override
    public void characters(char[] array, int start, int length) throws SAXException {
        if (element.equals("title")) {
            String str = new String(array, start, length);
            data.put(id, str);
            for (Map.Entry<Integer, String> value : data.entrySet()) {
                System.out.println(value.getKey() + ": " + value.getValue());
            }
        }
    }

    public Map<Integer, String> getData() {

        return data;
    }

}
