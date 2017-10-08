package ru.job4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Андрей on 02.10.2017.
 */
public class Assembly_Module {
    private Connection conn = null;

    private void initConnection(File connectSettings) throws FileNotFoundException, SQLException {
        Scanner sc = new Scanner(connectSettings);
        String url = sc.nextLine();
        String username = sc.nextLine();
        String password = sc.nextLine();
        this.conn = DriverManager.getConnection(url, username, password);
        PreparedStatement st = conn.prepareStatement("CREATE TABLE if not exists vacancy (id SERIAL PRIMARY KEY, name TEXT, link TEXT, date TEXT )");
        st.executeUpdate();
    }

    Document html = null;
    Elements e = null;
    Elements e2 = null;

    private void parseHTML() throws IOException {
        html = Jsoup.connect("http://www.sql.ru/forum/job-offers/100").get();
        e = html.select("td[class$=postslisttopic]");
        e2 = html.select("td[style][class]");
    }

    private void workDB(File connectSettings) {
        PreparedStatement st = null;
        try {
            this.initConnection(connectSettings);
            this.parseHTML();
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
                    st = conn.prepareStatement("INSERT INTO vacancy(name, link, date) VALUES (?, ?, ?)");
                    // проверка отсутствия дубликатов
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void execute(File connectSettings, long runFrequencySeconds) {
        while(true) {
            this.workDB(connectSettings);
            try {
                Thread.sleep(runFrequencySeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
