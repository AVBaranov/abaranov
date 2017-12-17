package servlets.test_task;

import servlets.test_task.databaseException.NoSuchAddressException;
import servlets.test_task.databaseException.NoSuchIdException;
import servlets.test_task.databaseException.NoSuchRoleException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 12.12.2017.
 */
public class UserDaoStorage implements DaoStorage<User> {
    Connection conn = null;

    PreparedStatement st = null;

    public UserDaoStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            st = this.conn.prepareStatement("CREATE TABLE if not exists newuser (id SERIAL PRIMARY KEY, login VARCHAR , password VARCHAR, email VARCHAR, role_id INTEGER REFERENCES Role(id), address_id INTEGER REFERENCES Address(id))");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int ifRoleExists(User user) throws SQLException {
        List<Role> roles = new ArrayList<>();
        int role_id = 0;
        boolean roleExists = true;
        this.st = conn.prepareStatement("SELECT * FROM Role");
        ResultSet rs = this.st.executeQuery();
        while (rs.next())
        {
            roles.add(new Role(rs.getInt("id"), rs.getString("role")));
        }
        st.close();
        rs.close();

        for (Role value : roles) {
            if (value.getRole().equals(user.getRole())) {
                role_id = value.getId();
                roleExists = false;
                break;
            }
        }
        if (roleExists) {
            throw new NoSuchRoleException("no such role in the table");
        }
        return role_id;
    }

    private int ifAddressExists(User user) throws SQLException {
        List<Address> addresses = new ArrayList<>();
        int address_id = 0;
        boolean addressExists = true;
        this.st = conn.prepareStatement("SELECT * FROM Address");
        ResultSet rs2 = this.st.executeQuery();
        while (rs2.next())
        {
            addresses.add(new Address(rs2.getInt("id"), rs2.getString("address")));
        }
        st.close();
        rs2.close();


        for (Address value : addresses) {
            if (value.getAddress().equals(user.getAddress())) {
                address_id = value.getId();
                addressExists = false;
                break;
            }
        }
        if (addressExists) {
            throw new NoSuchAddressException("no such address in the table");
        }
        return address_id;
    }

    public void add(User user) throws SQLException {

        int role_id = this.ifRoleExists(user);

        int address_id = this.ifAddressExists(user);

        st = this.conn.prepareStatement("INSERT INTO newuser (login, password, email, role_id, address_id) VALUES (?, ?, ?, ?, ?)");
        st.setString(1, user.getLogin());
        st.setString(2, user.getPassword());
        st.setString(3, user.getEmail());
        st.setInt(4, role_id);
        st.setInt(5, address_id);
        st.executeUpdate();
        st.close();

    }

    private List<Address> getAddresses() {
        List<Address> listAddress = new CopyOnWriteArrayList<>();
        try {
            this.st = conn.prepareStatement("SELECT * FROM Address");
            ResultSet rs2 = this.st.executeQuery();
            while (rs2.next())
            {
                listAddress.add(new Address(rs2.getInt("id"), rs2.getString("address")));
            }
            st.close();
            rs2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listAddress;
    }

    private List<Role> getRoles() {
        List<Role> listRole = new CopyOnWriteArrayList<>();
        try {
            this.st = conn.prepareStatement("SELECT * FROM Role");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                listRole.add(new Role(rs.getInt("id"), rs.getString("role")));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listRole;
    }

    public List<User> getAll() throws SQLException {

        List<User> list = new CopyOnWriteArrayList<>();

        List<Role> listRole = this.getRoles();

        List<Address> listAddress = this.getAddresses();

        this.st = conn.prepareStatement("SELECT * FROM newuser");
        ResultSet rs = this.st.executeQuery();
        String role = new String("TEMP_ROLE");
        String address = new String("TEMP_ADDRESS");
        while (rs.next())
        {
            int role_id = rs.getInt("role_id");
            int address_id = rs.getInt("address_id");
            for (Role value : listRole) {
                if (value.getId() == role_id) {
                    role = value.getRole();
                    break;
                }
            }
            for (Address value : listAddress) {
                if (value.getId() == address_id) {
                    address = value.getAddress();
                    break;
                }
            }
            list.add(new User(rs.getString("login"),rs.getString("password"),rs.getString("email"), role, address));
        }
        st.close();
        rs.close();
        return list;
    }

    public void update(int id, User user) {

        int role_id = 0;
        int address_id = 0;
        try {
            role_id = this.ifRoleExists(user);
            address_id = this.ifAddressExists(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            st = this.conn.prepareStatement("UPDATE newuser SET login = ?, password = ?, email = ?, role_id = ?, address_id = ? WHERE id = ?");
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setString(3, user.getEmail());
            st.setInt(4, role_id);
            st.setInt(5, address_id);
            st.setInt(6, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try {
            st = this.conn.prepareStatement("DELETE FROM newuser where id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findById(int id) {
        String role = new String("TEMP_ROLE");
        String address = new String("TEMP_ADDRESS");
        List<Role> listRole = this.getRoles();
        List<Address> listAddress = this.getAddresses();
        User user = null;
        boolean idExist = false;
        try {
            this.st = conn.prepareStatement("SELECT * FROM newuser");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                if (rs.getInt("id") == id) {
                    idExist = true;
                    int role_id = rs.getInt("role_id");
                    int address_id = rs.getInt("address_id");
                    for (Role value : listRole) {
                        if (value.getId() == role_id) {
                            role = value.getRole();
                            break;
                        }
                    }
                    for (Address value : listAddress) {
                        if (value.getId() == address_id) {
                            address = value.getAddress();
                            break;
                        }
                    }
                    user = new User(rs.getString("login"), rs.getString("password"), rs.getString("email"), role, address);
                }
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!idExist) {
            throw new NoSuchIdException("no such id");
        }
        return user;
    }

    class Essence {
        String role;
        String address;
        public Essence(String role, String address) {
            this.role = role;
            this.address = address;
        }
        public String getRole() {
            return this.role;
        }
        public String getAddress() {
            return this.address;
        }

    }

    public List<Essence> getEssences(String userLogin) throws SQLException {
        List<Essence> list = new CopyOnWriteArrayList<>();
        this.st = conn.prepareStatement("SELECT r.role, a.address FROM newuser u INNER JOIN role r ON u.role_id = r.id INNER JOIN address a ON u.address_id = a.id WHERE u.login = ?");
        st.setString(1, userLogin);
        ResultSet rs = this.st.executeQuery();

        while (rs.next())
        {
            list.add(new Essence(rs.getString("role"), rs.getString("address")));
        }
        st.close();
        rs.close();
        return list;
    }

    private void addRole(Role role) {
        try {
            st = this.conn.prepareStatement("CREATE TABLE if not exists role (id SERIAL PRIMARY KEY, role VARCHAR)");
            st.executeUpdate();
            st.close();
            st = this.conn.prepareStatement("INSERT INTO role VALUES (?, ?)");
            st.setInt(1, role.getId());
            st.setString(2, role.getRole());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAddress(Address address) {
        try {
            st = this.conn.prepareStatement("CREATE TABLE if not exists address (id SERIAL PRIMARY KEY, address VARCHAR)");
            st.executeUpdate();
            st.close();
            st = this.conn.prepareStatement("INSERT INTO address VALUES (?, ?)");
            st.setInt(1, address.getId());
            st.setString(2, address.getAddress());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEssence(User user, Role role, Address address) {
        this.addRole(role);
        this.addAddress(address);
        try {
            st = this.conn.prepareStatement("INSERT INTO newuser (login, password, email, role_id, address_id) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setString(3, user.getEmail());
            st.setInt(4, role.getId());
            st.setInt(5, address.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
