package ru.job4j;

import javafx.beans.binding.MapExpression;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey on 03.10.2017.
 */
public class Test extends DefaultHandler {

    public static void main(String[] args) {
        /*try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {


                public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
                {

                    if ("entry".equals(qName)) {
                        for (int i = 0; i < atts.getLength(); i++) {
                            System.out.println(atts.getValue(i));
                        }
                    }
                }

            };

            saxParser.parse("C:\\Users\\Andrey\\Desktop/2.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }*/


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



        /*Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            conn.setAutoCommit(false);
            PreparedStatement st =conn.prepareStatement("CREATE TABLE IF NOT EXISTS TEST (field INT )");
            st.executeUpdate();
            st = conn.prepareStatement("INSERT INTO TEST VALUES (1)");
            st.executeUpdate();
            st = conn.prepareStatement("SELECT * FROM TEST");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("field"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/


//        new Assembly_Module().execute(new File("C:\\Users\\Andrey\\Desktop/readme.txt"), 1000);


        Map<Character, Integer> map = new HashMap<>();
        char[] array = new String("sdfsdgs").toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            map.put(array[i], count);
            count = 0;
        }


        /*for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%s %x", entry.getKey(), entry.getValue()));
        }*/

        


    }
}