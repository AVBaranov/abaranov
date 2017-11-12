package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Andrey on 12.11.2017.
 */
public class GetUsers extends HttpServlet {

    private List<String> list = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = null;
        List<User> list = new ArrayList<>();
        PreparedStatement st = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            conn = DriverManager.getConnection(url, username, password);
            st = conn.prepareStatement("CREATE TABLE if not exists newservlet (id SERIAL PRIMARY KEY, name TEXT, login TEXT, email TEXT, date TIMESTAMP )");
            st.executeUpdate();
            st.close();
            st = conn.prepareStatement("SELECT * FROM newservlet");

            ResultSet rs = st.executeQuery();
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

        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder("<table>");
        for (User value : list) {
            sb.append("<tr><td>" + value.getName() + " " + value.getLogin()  + " " + value.getEmail() + " " + value.getCreateDate() + "</td></tr>");
        }
        writer.append(sb);
        writer.flush();
    }
}
