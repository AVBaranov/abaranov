package ru.job4j.collectionsframework.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.*;

/**
 * Created by Андрей on 21.08.2017.
 */
public class UserHandler extends DefaultHandler {
    public static void main(String[] args) {
        try {
           File file = new File("C:\\Users\\Андрей\\Desktop/orders.xml");
            SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();
            UserHandler userhandler = new UserHandler();

            long start = System.currentTimeMillis();

            saxparser.parse(file, userhandler);

            long end = System.currentTimeMillis();
            System.out.println(end - start);

//            System.out.println(userhandler.sell.size());

            // вывод биржевого стакана продаж
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

    public Map<String, Order> sell = new TreeMap<>(Comparator.reverseOrder());
    public Map<String, Order> buy = new TreeMap<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // добавление заказов
        if (qName.startsWith("A")) {
            // добавление заказов на продажу
            if (attributes.getValue(1).equalsIgnoreCase("SELL")) {
                boolean b = true;
                for (Map.Entry value : this.sell.entrySet()) {
                    if (value.getKey().equals(attributes.getValue(2))) {
                        sell.put(attributes.getValue(2), new Order((((Order) value.getValue()).getVolume() + Integer.parseInt(attributes.getValue(3))), Long.parseLong(attributes.getValue(4))));
                        b = false;
                        break;
                    }
                }
                if (b) {
                    sell.put(attributes.getValue(2), new Order((Integer.parseInt(attributes.getValue(3))), Long.parseLong(attributes.getValue(4))));
                }
            }
            //добавление заказов на покупку
            if (attributes.getValue(1).equalsIgnoreCase("BUY")) {
                boolean b = true;
                for (Map.Entry value : this.buy.entrySet()) {
                    if (value.getKey().equals(attributes.getValue(2))) {
                        buy.put(attributes.getValue(2), new Order((((Order) value.getValue()).getVolume() + Integer.parseInt(attributes.getValue(3))), Long.parseLong(attributes.getValue(4))));
                        b = false;
                        break;
                    }
                }
                if (b) {
                    buy.put(attributes.getValue(2), new Order((Integer.parseInt(attributes.getValue(3))), Long.parseLong(attributes.getValue(4))));
                }
            }
        }
        // удаление заказов
        if (qName.startsWith("D")) {
            Iterator<Map.Entry<String, Order>> iterSell = sell.entrySet().iterator();
            Iterator<Map.Entry<String, Order>> iterBuy = buy.entrySet().iterator();
            // удаление заказов на продажу
            while (iterSell.hasNext()) {
                if (iterSell.next().getValue().getOrderId() == Integer.parseInt(attributes.getValue(1))) {
                    iterSell.remove();
                }
            }
            // удаление заказов на покупку
            while (iterBuy.hasNext()) {
                if (iterBuy.next().getValue().getOrderId() == Integer.parseInt(attributes.getValue(1))) {
                    iterBuy.remove();
                }
            }
            /*for (Map.Entry value : this.sell.entrySet()) {
                if (((Orders) value.getValue()).getOrderId() == *//*Integer.parseInt(attributes.getValue(1))*//*224) {
                    sell.remove(value.getKey(), value.getValue());
                }
            }*/
        }
    }
}
