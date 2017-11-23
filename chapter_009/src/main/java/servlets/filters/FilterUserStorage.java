package servlets.filters;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 20.11.2017.
 */
public class FilterUserStorage {

//    public String check;

    List<Filter_User> users = new CopyOnWriteArrayList<>();

    List<Filter_User> accounting = new CopyOnWriteArrayList<>();

    private static final FilterUserStorage instance = new FilterUserStorage();

    private FilterUserStorage() {
        this.accounting.add(new Filter_User("root", "root@root", "root"));
    }

    public static FilterUserStorage getInstance() {
        return instance;
    }

    public void add(Filter_User user) {
       this.users.add(user);
    }

    public List<Filter_User> getUsers() {
        return this.users;
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

