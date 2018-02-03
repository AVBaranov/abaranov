package spring.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 02.02.2018.
 */
public class MemoryStorage implements Storage<User> {
    List<User> users = new ArrayList<>();
    @Override
    public void add(User user) {
        users.add(user);
    }
    @Override
    public List<User> getAll() {
        return this.users;
    }
}
