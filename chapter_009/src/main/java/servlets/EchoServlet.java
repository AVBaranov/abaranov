package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Created by Андрей on 16.10.2017.
 */
public class EchoServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(EchoServlet.class);

    Connection conn = null;

    PreparedStatement st = null;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = this.conn.prepareStatement("CREATE TABLE if not exists newservlet (id SERIAL PRIMARY KEY, name TEXT, login TEXT, email TEXT, date TIMESTAMP )");
            st.executeUpdate();
            st = this.conn.prepareStatement("INSERT INTO newservlet (name, login, email, date) VALUES (?, ?, ?, ?)");
            st.setString(1, "Walt");
            st.setString(2, "Walter");
            st.setString(3, "WW@mail.ru");
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<User> list = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            this.st = this.conn.prepareStatement("CREATE TABLE if not exists newservlet (id SERIAL PRIMARY KEY, name TEXT, login TEXT, email TEXT, date TIMESTAMP )");
            this.st.executeUpdate();
            this.st = conn.prepareStatement("SELECT * FROM newservlet");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                list.add(new User(rs.getString("name"),rs.getString("login"),rs.getString("email"), rs.getTimestamp("date")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        for (User values : list) {
            writer.append(String.format("%s %s %s \n", values.getName(), values.getLogin(), values.getEmail()));
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = this.conn.prepareStatement("CREATE TABLE if not exists newservlet (id SERIAL PRIMARY KEY, name TEXT, login TEXT, email TEXT, date TIMESTAMP )");
            st.executeUpdate();
            st = this.conn.prepareStatement("UPDATE newservlet SET name = ?, login = ?, email = ?, date = ? WHERE id = ?");
            st.setString(1, "Rick");
            st.setString(2, "walking_Rick");
            st.setString(3, "WR@mail.ru");
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.setInt(5, 2);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = this.conn.prepareStatement("CREATE TABLE if not exists newservlet (id SERIAL PRIMARY KEY, name TEXT, login TEXT, email TEXT, date TIMESTAMP )");
            st.executeUpdate();
            st = this.conn.prepareStatement("DELETE FROM newservlet where id = ?");
            st.setInt(1, 1);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
