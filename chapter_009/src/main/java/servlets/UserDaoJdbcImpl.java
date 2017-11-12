package servlets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 30.10.2017.
 */
public class UserDaoJdbcImpl implements UserDao {



    Connection conn = null;

    PreparedStatement st = null;

    public UserDaoJdbcImpl() {
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

    @Override
    public void put(User user) throws SQLException, ClassNotFoundException {
            st = this.conn.prepareStatement("INSERT INTO newservlet (name, login, email, date) VALUES (?, ?, ?, ?)");
            st.setString(1, "Walt");
            st.setString(2, "Walter");
            st.setString(3, "WW@mail.ru");
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            st.close();
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
            this.st = conn.prepareStatement("SELECT * FROM newservlet");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                list.add(new User(rs.getString("name"),rs.getString("login"),rs.getString("email"), rs.getTimestamp("date")));
            }
            st.close();
            rs.close();
        return list;
    }

    @Override
    public void update() throws SQLException, ClassNotFoundException {
            st = this.conn.prepareStatement("UPDATE newservlet SET name = ?, login = ?, email = ?, date = ? WHERE id = ?");
            st.setString(1, "Rick");
            st.setString(2, "walking_Rick");
            st.setString(3, "WR@mail.ru");
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.setInt(5, 5);
            st.executeUpdate();
            st.close();
    }

    @Override
    public void delete() throws SQLException, ClassNotFoundException {
            st = this.conn.prepareStatement("DELETE FROM newservlet where id = ?");
            st.setInt(1, 2);
            st.executeUpdate();
            st.close();
    }

}
