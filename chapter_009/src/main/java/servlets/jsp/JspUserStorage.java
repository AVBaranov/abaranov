package servlets.jsp;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 20.11.2017.
 */
public class JspUserStorage {

    Connection conn = null;

    PreparedStatement st = null;

    List<Jsp_User> store = new CopyOnWriteArrayList<>();

    private static final JspUserStorage userstoragedatabase = new JspUserStorage();

    private JspUserStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            st = this.conn.prepareStatement("CREATE TABLE if not exists TEST_TABLE (id SERIAL PRIMARY KEY, name TEXT, login TEXT, email TEXT, date TIMESTAMP )");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static JspUserStorage getInstance() {
        return userstoragedatabase;
    }

    public void add(Jsp_User user) {
        try {
            Class.forName("org.postgresql.Driver");
            st = this.conn.prepareStatement("INSERT INTO TEST_TABLE (name, login, email, date) VALUES (?, ?, ?, ?)");
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setTimestamp(4, user.getCreateDate());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Jsp_User> getUsers() {
        try {
            Class.forName("org.postgresql.Driver");
            this.st = conn.prepareStatement("SELECT * FROM TEST_TABLE");
            ResultSet rs = this.st.executeQuery();

            this.store.clear();

            while (rs.next())
            {
                this.store.add(new Jsp_User(rs.getString("name"),rs.getString("login"), rs.getString("email"), rs.getTimestamp("date")));
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this.store;
    }

    public void delete(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            st = this.conn.prepareStatement("DELETE FROM TEST_TABLE WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Jsp_User user) {
        try {
            Class.forName("org.postgresql.Driver");
            st = this.conn.prepareStatement("UPDATE TEST_TABLE SET name = ?, login = ?, email = ? WHERE id = ?");
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setInt(4, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

