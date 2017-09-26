package ru.job4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Andrey on 26.09.2017.
 */
public class SQLStorage {

    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main (String[] args) {
        String url = "jdbc:postgresql://localhost:5432/admin";

        String username = new String("postgres");
        String password = new String("password");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);

//            PreparedStatement st = conn.prepareStatement("SELECT * FROM shop as s where s.price in (?, ?)");
//
//            st.setInt(1, 52);
//            st.setInt(2, 40);
//            ResultSet rs = st.executeQuery();
            PreparedStatement st = conn.prepareStatement("DELETE FROM shop WHERE price = ?");
            st.setInt(1, 49);
            int rowsDeleted = st.executeUpdate();
//            while (rs.next())
//            {
//
//                System.out.println(String.format("%s %s %s", rs.getString("name"), rs.getString("shop_name"), rs.getString("price")));
//            } rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }

    }
}
