package ru.job4j.synchronization.store;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.synchronization.store.NoSuchUserIdException;
import ru.job4j.synchronization.store.NotEnoughAmountException;
import ru.job4j.synchronization.store.User;

import java.util.*;


/**
 * Created by Andrey on 03.09.2017.
 */
@ThreadSafe public class UserStorage {

    private Object lock = new Object();

    @GuardedBy("lock") private List<User> UserList = new ArrayList<>();

    public User add(User user) {
        synchronized (this) {
            if (user == null) {
                System.out.println("no such user");
                return null;
            }
            UserList.add(user);
            return user;
        }
    }

    public boolean delete(User user) {
        synchronized (this) {
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
    }

    public User get(int index) {
        synchronized (this) {
            return UserList.get(index);
        }
    }

    private int srcindex = 0;
    private int dstindex = 0;

    private void checkForException(int srcId, int destId, int amount) {
        synchronized (this) {
            boolean b = true;
            for (int i = 0; i < UserList.size(); i++) {
                if (UserList.get(i).getId() == srcId) {
                    b = false;
                    this.srcindex = i;
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
                    this.dstindex = i;
                    break;
                }
            }
            if (b) {
                throw new NoSuchUserIdException("no such destinetion id");
            }

            for (int i = 0; i < UserList.size(); i++) {
                if (UserList.get(i).getId() == srcId) {
                    if (UserList.get(i).getAmount() < amount)
                    {
                        throw new NotEnoughAmountException("not enough amount");
                    }
                    if (amount < 0) {
                        throw new IllegalAmountException("amount can't be negative");
                    }
                }
            }
        }
    }

    public void transfer(int srcId, int destId, int amount) {
        synchronized(this) {
            this.checkForException(srcId, destId, amount);
            UserList.set(this.srcindex, new User(srcId, (UserList.get(this.srcindex).getAmount() - amount)));
            UserList.set(this.dstindex, new User(destId, (UserList.get(this.dstindex).getAmount() + amount)));
        }
    }

}

