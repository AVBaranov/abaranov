package hibernate.todolist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 07.12.2017.
 */
public class ItemStorage {

    Connection conn = null;

    PreparedStatement st = null;

    List<Item> items = new CopyOnWriteArrayList<>();

    public ItemStorage() {
        /*try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/admin";
            String username = "postgres";
            String password = "password";
            this.conn = DriverManager.getConnection(url, username, password);
            st = this.conn.prepareStatement("CREATE TABLE if not exists itemstorage (id SERIAL PRIMARY KEY, descr TEXT, created TEXT, done BOOLEAN )");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    public List<Item> getAll() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Item> items = session.createQuery("from Item").list();
        session.getTransaction().commit();
        session.close();
        factory.close();
        return items;

        /*List<Item> list = new ArrayList<>();
        try {
            this.st = conn.prepareStatement("SELECT * FROM itemstorage");
            ResultSet rs = this.st.executeQuery();
            while (rs.next())
            {
                list.add(new Item(rs.getInt("id"),rs.getString("descr"), rs.getString("created"), rs.getBoolean("done")));
            }
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;*/
    }

    public void add(Item item) {

            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            Item it = new Item();
            it.setId(item.getId());
            it.setDescr(item.getDescr());
            it.setCreated(item.getCreated());
            it.setDone(item.getDone());
            session.saveOrUpdate(it);
            session.getTransaction().commit();
            session.close();
            factory.close();

        /*try {
            Class.forName("org.postgresql.Driver");
            st = this.conn.prepareStatement("INSERT INTO itemstorage (id, descr, created, done) VALUES (?, ?, ?, ?)");
            st.setInt(1, item.getId());
            st.setString(2, item.getDescr());
            st.setString(3, item.getCreated());
            st.setBoolean(4, item.getDone());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        /*Class.forName("org.postgresql.Driver");
        st = this.conn.prepareStatement("INSERT INTO users (login, email) VALUES (?, ?, ?, ?)");
        st.setInt(1, 10);
        st.setString(2, "1");
        st.setString(3, "2");
        st.setInt(4, 20);
        st.executeUpdate();
        st.close();*/
    }



}
