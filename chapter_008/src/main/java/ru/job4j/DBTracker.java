package ru.job4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Andrey on 29.09.2017.
 */
public class DBTracker {
    Connection conn = null;

    public DBTracker(File connectSettings) {
        this.initConnection(connectSettings);
    }

    private void initConnection(File file) {
        try {
            Scanner sc = new Scanner(file);
            String url = sc.nextLine();
            String username = sc.nextLine();
            String password = sc.nextLine();
            this.conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = this.conn.prepareStatement("CREATE TABLE if not exists tracker (id SERIAL PRIMARY KEY, name TEXT, descr TEXT, date TIMESTAMP )");
            st.executeUpdate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void add(DBItem item) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into tracker (name, descr, date) values (?, ?, ?)");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setTimestamp(3, item.getCreate());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String name) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM tracker WHERE name = ?");
            st.setString(1, name);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(int id, DBItem item) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tracker SET name = ?, descr = ?, date = ? WHERE id = ?");
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setTimestamp(3, item.getCreate());
            st.setInt(4, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public DBItem findBNyId(int id) {
        DBItem item = null;
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("SELECT * FROM tracker WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                item = new DBItem(rs.getInt("id"),rs.getString("name"),rs.getString("descr"), rs.getTimestamp("date"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return item;
    }

    public List<DBItem> findAll() {
        List<DBItem> list = new ArrayList<>();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("SELECT * FROM tracker");
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                list.add(new DBItem(rs.getInt("id"),rs.getString("name"),rs.getString("descr"), rs.getTimestamp("date")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
