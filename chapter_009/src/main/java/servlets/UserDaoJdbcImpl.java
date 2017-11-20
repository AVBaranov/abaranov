package servlets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 30.10.2017.
 */
public class UserDaoJdbcImpl implements UserDao {

    Connection conn = null;

    PreparedStatement st = null;

    private static final UserDaoJdbcImpl userstore = new UserDaoJdbcImpl();

    private UserDaoJdbcImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            st = this.conn.prepareStatement("CREATE TABLE if not exists newservlet (id SERIAL PRIMARY KEY, name TEXT, login TEXT, email TEXT, date TIMESTAMP )");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static UserDaoJdbcImpl getInstance() {
        return userstore;
    }

    @Override
    public void put(User user) throws SQLException, ClassNotFoundException {
        st = this.conn.prepareStatement("INSERT INTO newservlet (name, login, email, date) VALUES (?, ?, ?, ?)");
        st.setString(1, user.getName());
        st.setString(2, user.getLogin());
        st.setString(3, user.getEmail());
        st.setTimestamp(4, user.getCreateDate());
        st.executeUpdate();
        st.close();
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try {
            this.st = conn.prepareStatement("SELECT * FROM newservlet");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                list.add(new User(rs.getString("name"),rs.getString("login"),rs.getString("email"), rs.getTimestamp("date")));
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(int id, User user) throws SQLException, ClassNotFoundException {
        st = this.conn.prepareStatement("UPDATE newservlet SET name = ?, login = ?, email = ?, date = ? WHERE id = ?");
        st.setString(1, user.getName());
        st.setString(2, user.getLogin());
        st.setString(3, user.getEmail());
        st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        st.setInt(5, id);
        st.executeUpdate();
        st.close();
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        st = this.conn.prepareStatement("DELETE FROM newservlet where id = ?");
        st.setInt(1, id);
        st.executeUpdate();
        st.close();
    }

}
