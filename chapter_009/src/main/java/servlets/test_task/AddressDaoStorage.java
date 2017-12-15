package servlets.test_task;

import servlets.test_task.databaseException.NoSuchIdException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 13.12.2017.
 */
public class AddressDaoStorage implements DaoStorage<Address> {
    Connection conn = null;

    PreparedStatement st = null;

    public AddressDaoStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            st = this.conn.prepareStatement("CREATE TABLE if not exists address (id SERIAL PRIMARY KEY, address VARCHAR)");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void add(Address address) throws SQLException {
            st = this.conn.prepareStatement("INSERT INTO address VALUES (?, ?)");
            st.setInt(1, address.getId());
            st.setString(2, address.getAddress());
            st.executeUpdate();
            st.close();
    }

    public List<Address> getAll() throws SQLException {
        List<Address> list = new CopyOnWriteArrayList<>();
            this.st = conn.prepareStatement("SELECT * FROM address");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                list.add(new Address(rs.getInt("id"),rs.getString("address")));
            }
            st.close();
            rs.close();
        return list;
    }

    public void update(int id, Address address) {
        try {
            st = this.conn.prepareStatement("UPDATE address SET id = ?, address = ? WHERE id = ?");
            st.setInt(1, address.getId());
            st.setString(2, address.getAddress());
            st.setInt(3, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            st = this.conn.prepareStatement("DELETE FROM address where id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Address findById(int id) {
        Address address = null;
        boolean idExist = true;
        try {
            this.st = conn.prepareStatement("SELECT * FROM address");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                if (rs.getInt("id") == id) {
                    idExist = false;
                    address = new Address(rs.getInt("id"), rs.getString("address"));
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
        return address;
    }
}
