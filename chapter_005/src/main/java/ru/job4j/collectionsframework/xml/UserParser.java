package ru.job4j.collectionsframework.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Андрей on 25.08.2017.
 */
public class UserParser extends DefaultHandler {
    public Map<String, Order> sell = new TreeMap<>(Comparator.reverseOrder());
    public Map<String, Order> buy = new TreeMap<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String OPERATION = attributes.getValue(1);
        String PRICE = attributes.getValue(2);
        String VOLUME = attributes.getValue(3);
        String ORDERID = attributes.getValue(4);
        // добавление заказов
        if (qName.startsWith("A")) {
            // добавление заказов на продажу
            if (OPERATION.equalsIgnoreCase("SELL")) {
                boolean b = true;
                for (Map.Entry value : this.sell.entrySet()) {
                    if (value.getKey().equals(PRICE)) {
                        sell.put(PRICE, new Order((((Order) value.getValue()).getVolume() + Integer.parseInt(VOLUME)), Long.parseLong(ORDERID)));
                        b = false;
                        break;
                    }
                }
                if (b) {
                    sell.put(PRICE, new Order((Integer.parseInt(VOLUME)), Long.parseLong(ORDERID)));
                }
            }
            //добавление заказов на покупку
            if (OPERATION.equalsIgnoreCase("BUY")) {
                boolean b = true;
                for (Map.Entry value : this.buy.entrySet()) {
                    if (value.getKey().equals(PRICE)) {
                        buy.put(PRICE, new Order((((Order) value.getValue()).getVolume() + Integer.parseInt(VOLUME)), Long.parseLong(ORDERID)));
                        b = false;
                        break;
                    }
                }
                if (b) {
                    buy.put(PRICE, new Order((Integer.parseInt(VOLUME)), Long.parseLong(ORDERID)));
                }
            }
        }
        // удаление заказов
        if (qName.startsWith("D")) {
            Iterator<Map.Entry<String, Order>> iterSell = sell.entrySet().iterator();
            Iterator<Map.Entry<String, Order>> iterBuy = buy.entrySet().iterator();
            // удаление заказов на продажу
            while (iterSell.hasNext()) {
                if (iterSell.next().getValue().getOrderId() == Integer.parseInt(OPERATION)) {
                    iterSell.remove();
                }
            }
            // удаление заказов на покупку
            while (iterBuy.hasNext()) {
                if (iterBuy.next().getValue().getOrderId() == Integer.parseInt(OPERATION)) {
                    iterBuy.remove();
                }
            }
        }
    }

    public void parseFile(File file) {
        try {
            UserParser userhandler = new UserParser();
            SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();

            saxparser.parse(file, userhandler);
            for (Map.Entry value : userhandler.sell.entrySet()) {
                System.out.println(String.format("%s: %s", value.getKey(), ((Order) value.getValue()).getVolume(), ((Order) value.getValue()).getOrderId()));
            }

            System.out.println();
            // вывод биржевого стакана покупок
            for (Map.Entry value : userhandler.buy.entrySet()) {
                System.out.println(String.format("%s: %s", value.getKey(), ((Order) value.getValue()).getVolume(), ((Order) value.getValue()).getOrderId()));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
