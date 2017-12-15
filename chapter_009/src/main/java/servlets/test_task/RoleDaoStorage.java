package servlets.test_task;

import servlets.test_task.databaseException.NoSuchIdException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 13.12.2017.
 */
public class RoleDaoStorage implements DaoStorage<Role> {
    Connection conn = null;

    PreparedStatement st = null;

    public RoleDaoStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            st = this.conn.prepareStatement("CREATE TABLE if not exists role (id SERIAL PRIMARY KEY, role VARCHAR)");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(Role role) throws SQLException {
            st = this.conn.prepareStatement("INSERT INTO role VALUES (?, ?)");
            st.setInt(1, role.getId());
            st.setString(2, role.getRole());
            st.executeUpdate();
            st.close();
    }

    public List<Role> getAll() {

        List<Role> list = new CopyOnWriteArrayList<>();
        try {
            this.st = conn.prepareStatement("SELECT * FROM role");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                list.add(new Role(rs.getInt("id"),rs.getString("role")));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(int id, Role role) {
        try {
            st = this.conn.prepareStatement("UPDATE role SET id = ?, role = ? WHERE id = ?");
            st.setInt(1, role.getId());
            st.setString(2, role.getRole());
            st.setInt(3, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            st = this.conn.prepareStatement("DELETE FROM role where id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Role findById(int id) {
        Role role = null;
        boolean idExist = true;
        try {
            this.st = conn.prepareStatement("SELECT * FROM role");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                if (rs.getInt("id") == id) {
                    idExist = false;
                    role = new Role(rs.getInt("id"), rs.getString("role"));
                    break;
                }
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (idExist) {
            throw new NoSuchIdException("no such id");
        }
        return role;
    }

}

