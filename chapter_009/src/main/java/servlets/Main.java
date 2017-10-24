package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Андрей on 23.10.2017.
 */
public class Main {
    Connection conn = null;
    public static void main (String[] args) {
        new Main().todo();
    }
    public void todo() {
        try {
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = this.conn.prepareStatement("CREATE TABLE if not exists servlet (id SERIAL PRIMARY KEY, name TEXT, descr TEXT, date TIMESTAMP )");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


