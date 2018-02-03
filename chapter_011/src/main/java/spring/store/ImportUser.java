package spring.store;

import java.util.List;

/**
 * Created by Andrey on 02.02.2018.
 */
public class ImportUser {
    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }

    public List<User> getAll() {
        return this.storage.getAll();
    }
}
