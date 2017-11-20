package servlets;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Андрей on 16.11.2017.
 */
public class UserStorage {

    private static final UserStorage userStorage = new UserStorage();

    private List<TestUser> users = new CopyOnWriteArrayList<>();

    private UserStorage() {
    }

    public void add(TestUser user) {
        this.users.add(user);
    }

    public List<TestUser> getUsers() {
        return this.users;
    }

    public static UserStorage getInstance() {
        return userStorage;
    }
}
