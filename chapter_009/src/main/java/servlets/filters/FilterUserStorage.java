package servlets.filters;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 20.11.2017.
 */
public class FilterUserStorage {

//    public String check;

    Connection conn = null;

    PreparedStatement st = null;

    List<Filter_User> users = new CopyOnWriteArrayList<>();

    List<Filter_User> accounting = new CopyOnWriteArrayList<>();

    public String value;

    private static final FilterUserStorage instance = new FilterUserStorage();

    private FilterUserStorage() {
        try {
                Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            this.st = conn.prepareStatement("SELECT * FROM rolestorage");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                this.accounting.add(new Filter_User(rs.getString("login"),rs.getString("email"),rs.getString("password")));
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        this.accounting.add(new Filter_User("admin", "root@root", "admin"));
    }

    public static FilterUserStorage getInstance() {
        return instance;
    }

    public void add(Filter_User user) {
       this.users.add(user);
    }

    public List<Filter_User> getUsers() {
        this.users.clear();
        try {
            this.st = conn.prepareStatement("SELECT * FROM rolestorage");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                users.add(new Filter_User(rs.getString("login"),rs.getString("email"),rs.getString("password")));
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.users;
    }

    public void update(String old_login, Filter_User user) throws SQLException, ClassNotFoundException {
        st = this.conn.prepareStatement("UPDATE rolestorage SET login = ?, email = ?, password = ? WHERE login = ?");
        st.setString(1, user.getLogin());
        st.setString(2, user.getEmail());
        st.setString(3, user.getPassword());
        st.setString(4, old_login);
        st.executeUpdate();
        st.close();
    }


    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        for (Filter_User user : this.accounting) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
}

