package ru.job4j.collectionsframework.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Андрей on 17.05.2017.
 */
public class RoleStoreTest {
    @Test
    public void whenAddNewUserThenHaveOneNewUser() {
        Store<Role> rolestore = new RoleStore(new SimpleArray<>());
        rolestore.add(new Role("somerole"));
        assertThat(rolestore.get(0).getId(), is("somerole"));
    }
    @Test
    public void vhewDeleteFirstUserThenSecondUserBecomesFirstUser() {
        Store<Role> rolestore = new RoleStore(new SimpleArray<>());
        Role role1 = new Role("firstrole");
        Role role2 = new Role("secondrole");
        rolestore.add(role1);
        rolestore.add(role2);
        rolestore.delete(role1);
        assertThat(rolestore.get(0).getId(), is("secondrole"));
    }
    @Test
    public void whenUpdateUserStoreThenHaveNewUser() {
        Store<Role> rolestore = new RoleStore(new SimpleArray<>());
        rolestore.add(new Role("role"));
        rolestore.update(0, new Role("changedrole"));
        assertThat(rolestore.get(0).getId(), is("changedrole"));
    }
}