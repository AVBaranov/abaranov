package ru.job4j.collectionsframework.sample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.job4j.collectionsframework.map.Hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Andrey on 12.06.2017.
 */
public class Handler extends DefaultHandler {

    private int id;
    private String element;
    public Map<Integer, String> data = new HashMap<>();
    private List<String> list = new ArrayList<>();
    private int i;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        if (element.equals("product")) {
            System.out.println("STARTELEMENT");
            id = Integer.parseInt(attributes.getValue(0));
            System.out.println(id);
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
            System.out.println("CHARACTERS");
            String str = new String(array, start, length);
            System.out.println(str);
            data.put(id, str);
            list.add("asdf");
            i = 10;
        }
    }

    public Map<Integer, String> getData() {
        return data;
    }
    public List<String> getStr() {
        return list;
    }

    public int getI() {
        return i;
    }
}
