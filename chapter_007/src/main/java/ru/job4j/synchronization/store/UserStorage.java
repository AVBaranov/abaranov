package ru.job4j.synchronization.store;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.synchronization.store.NoSuchUserIdException;
import ru.job4j.synchronization.store.NotEnoughAmountException;
import ru.job4j.synchronization.store.User;

import java.util.*;


/**
 * Created by Andrey on 03.09.2017.
 */
@ThreadSafe public class UserStorage {

    private List<User> UserList = new ArrayList<>();

    public User add(User user) {
        if (user == null) {
            System.out.println("no such user");
            return null;
        }
        UserList.add(user);
        return user;
    }

    public boolean delete(User user) {
        boolean b = false;
        if (user != null) {
            for (int i = 0; i < UserList.size(); i++) {
                if (UserList.get(i).getId() == user.getId()) {
                    UserList.remove(i);
                    b = true;
                    break;
                }
            }
        }
        return b;
    }

    public User get(int index) {
        return UserList.get(index);
    }

    public void transfer(int srcId, int destId, int amount) {

        boolean b = true;

        int srcindex = 0;
        int dstindex = 0;

        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getId() == srcId) {
                b = false;
                srcindex = i + 1;
                break;
            }
        }
        if (b) {
            throw new NoSuchUserIdException("no such source id");

        }

        b = true;

        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getId() == destId) {
                b = false;
                dstindex = i + 1;
                break;
            }
        }
        if (b) {
            throw new NoSuchUserIdException("no such destinetion id");

        }

        b = true;

        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getId() == srcId) {
                if (UserList.get(i).getAmount() < amount)
                {
                    throw new NotEnoughAmountException("not enough amount");
                }
            }
        }

        System.out.println(srcindex + " " + dstindex);
        UserList.set(srcindex, new User(srcId, (UserList.get(srcId).getAmount() - amount)));
        UserList.set(dstindex, new User(destId, (UserList.get(destId).getAmount() + amount)));


    }

}

