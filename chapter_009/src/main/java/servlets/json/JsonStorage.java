package servlets.json;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 07.12.2017.
 */
public class JsonStorage {

    Connection conn = null;

    PreparedStatement st = null;

    List<JsonUser> users = new CopyOnWriteArrayList<>();

    private static final JsonStorage instance = new JsonStorage();

    public static JsonStorage getInstance() {
        return instance;
    }

    private JsonStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            st = this.conn.prepareStatement("CREATE TABLE if not exists teststorage (login TEXT, email TEXT, city TEXT, country TEXT )");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<JsonUser> getAll() {
        List<JsonUser> list = new ArrayList<>();
        try {
            this.st = conn.prepareStatement("SELECT * FROM teststorage");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                list.add(new JsonUser(rs.getString("login"),rs.getString("email")));
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(JsonUser user)throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        st = this.conn.prepareStatement("INSERT INTO teststorage (login, email) VALUES (?, ?)");
        st.setString(1, user.getLogin());
        st.setString(2, user.getEmail());
        st.executeUpdate();
        st.close();
        /*Class.forName("org.postgresql.Driver");
        st = this.conn.prepareStatement("INSERT INTO users (login, email) VALUES (?, ?, ?, ?)");
        st.setInt(1, 10);
        st.setString(2, "1");
        st.setString(3, "2");
        st.setInt(4, 20);
        st.executeUpdate();
        st.close();*/
    }

    public void update(String login, String city, String country) {
        List<JsonUser> list = new ArrayList<>();
        try {
            this.st = conn.prepareStatement("SELECT * FROM teststorage");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                list.add(new JsonUser(rs.getString("login"),rs.getString("email"), rs.getString("city"), rs.getString("country")));
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (JsonUser user : list) {
            if (user.getLogin().equals(login)) {
               /* user.setCity(city);
                user.setCountry(country);*/
               try {
                   st = this.conn.prepareStatement("UPDATE teststorage SET city = ?, country = ? WHERE login = ?");
                   st.setString(1, city);
                   st.setString(2, country);
                   st.setString(3, login);
                   st.executeUpdate();
                   st.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }

            }
        }
    }

}
