package ru.job4j;


import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Attributes;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



import java.sql.*;


import java.io.File;

/**
 * Created by Andrey on 26.09.2017.
 */



public class Main {

//    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main (String[] args) {

        /*DBTracker tracker = new DBTracker(new File("C:\\Users\\Андрей\\Desktop/trackersettings.txt"));
        tracker.add(new DBItem("apple", "round", new Timestamp(System.currentTimeMillis())));
        tracker.add(new DBItem("deka", "megadeka", new Timestamp(System.currentTimeMillis())));
        tracker.add(new DBItem("durinabol", "megadurinabol", new Timestamp(System.currentTimeMillis())));
        List<DBItem> list = tracker.findAll();
        for (DBItem value : list) {
            System.out.println(String.format("%s %s ", value.getName(), value.getDescription()));
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


       /* Connection conn = null;


        try {

            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("CREATE TABLE if not exists vacancy (id SERIAL PRIMARY KEY, name TEXT, link TEXT, date TEXT )");
            st.executeUpdate();

            Document html = Jsoup.connect("http://www.sql.ru/forum/job-offers/35").get();


            Elements e = html.select("td[class$=postslisttopic]");


            System.out.println(e.get(0).getElementsByTag("a").attr("href"));
            System.out.println(e.get(10).text());


            Elements e2 = html.select("td[style][class]");


            st = conn.prepareStatement("SELECT name FROM vacancy");
            ResultSet rs = st.executeQuery();
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
            begin : for (int i = 0; i < e.size(); i++) {
                if (e.get(i).text().contains("JavaScript") || e.get(i).text().contains("Java Script")) {
                    System.out.println("JAVASCRIPT IS NOT CORRECT");
                    continue;
                }
                if (e.get(i).text().contains("Java") || e.get(i).text().contains("java")) {
                    System.out.println(String.format("%s  -  %s \n%s", e.get(i).getElementsByTag("a").text(), e2.get(i).text(), e.get(i).getElementsByTag("a").attr("href")));
                    st = conn.prepareStatement("INSERT INTO vacancy(name, link, date) VALUES (?, ?, ?)");

                    for (int j = 0; j < names.size(); j++) {
                        if ((e.get(i).text()).equals(names.get(j))) {
                            continue begin;
                        }
                    }
                    st.setString(1, e.get(i).text());
                    st.setString(2, e.get(i).getElementsByTag("a").attr("href"));
                    st.setString(3, e2.get(i).text());
                    st.executeUpdate();
                }
            }
            names.clear();

            long time = 3000;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



       // сохранение в бд в таблицу vacancy
//       new Assembly_Module().execute(new File("C:\\Users\\Андрей\\Desktop/readme.txt"), 100);

        String [][] theDogs = new String[3][];
        System.out.println(theDogs[2][0]);

    }



}
