package ru.job4j.collectionsframework.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Андрей on 17.05.2017.
 */
public class UserStoreTest {
    @Test
    public void whenAddNewUserThenHaveOneNewUser() {
        Store<User> userstore = new UserStore(new SimpleArray<>());
        userstore.add(new User("someuser"));
        assertThat(userstore.get(0).getId(), is("someuser"));
    }
    @Test
    public void vhewDeleteFirstUserThenSecondUserBecomesFirstUser() {
        Store<User> userstore = new UserStore(new SimpleArray<>());
        User user1 = new User("firstuser");
        User user2 = new User("seconduser");
        userstore.add(user1);
        userstore.add(user2);
        userstore.delete(user1);
        assertThat(userstore.get(0).getId(), is("seconduser"));
    }
    @Test
    public void whenUpdateUserStoreThenHaveNewUser() {
        Store<User> userstore = new UserStore(new SimpleArray<>());
        userstore.add(new User("user"));
        userstore.update(0, new User("changeduser"));
        assertThat(userstore.get(0).getId(), is("changeduser"));
    }

}