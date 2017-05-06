package ru.job4j.CollectionsFramework.bank;
import java.util.*;
/**
 * Created by Андрей on 04.05.2017.
 */
public class Action {
    private Map<User, List<Account>> map = new HashMap<>();
    public void addUser(User user) {
        ArrayList<Account> list = new ArrayList<Account>();
        map.put(user, list);
    }
    public void deleteUser(User user) {
        map.remove(user);
    }

    public Map<User, List<Account>> getMap() {
        return map;
    }

    public void addAccountToUser(User user, Account account) {
        if (!map.containsKey(user)) {
            throw new UserNotFoundException("user not found");
        }
        if (map.containsKey(user)) {
            List<Account> temp = map.get(user);
            temp.add(account);
            map.put(user, temp);
        }
    }
    public void deleteAccountFromUser(User user, Account account) {
        if (!map.containsKey(user)) {
            throw new UserNotFoundException("user not found");
        }
        List<Account> temp = map.get(user);
        temp.remove(account);
        map.replace(user, temp);
    }
    public List<Account> getUserAccounts(User user) {
        return map.get(user);
    }
    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, int amount) {
        boolean b = true;
        Iterator<Account> srciter = map.get(srcUser).iterator();
        boolean src = false;
        // проверка что есть пользователь, который будет переводить деньги
        if (!map.containsKey(srcUser)) {
            src = true;
        }
        // проверка что есть пользователь, которому будут переводиться деньги
        if (!map.containsKey(dstUser)) {
            src = true;
        }

        // проверка что есть счет, куда будут переводиться деньги
        while (srciter.hasNext()) {
            if (srciter.next().equals(srcAccount)) {
                src = false;
            }
        }
        if (src) {
            return false;
        }

        Iterator<Account> dstiter = map.get(dstUser).iterator();
        boolean dst = true;
        // проверка что есть счет, откуда будут переводиться деньги
        while (dstiter.hasNext()) {
            if (dstiter.next().equals(dstAccount)) {
                dst = false;
            }
        }
        if (dst) {
            return false;
        }
        boolean total = false;
            if (srcAccount.getValue() < amount) {
                total = true;
            }
            if (total) {
                System.out.println("недостаточно средств для перевода!");
                return false;
            }
        List<Account> srcTemp= map.get(srcUser);
            for (Account account : srcTemp) {
                if (account.equals(srcAccount)) {
                    account.setValue(srcAccount.getValue() - amount);
                }
            }
            map.replace(srcUser, srcTemp);
        List<Account> dstTemp= map.get(dstUser);
        for (Account account : dstTemp) {
            if (account.equals(dstAccount)) {
                account.setValue(dstAccount.getValue() + amount);
            }
        }
        map.replace(dstUser, dstTemp);

        return b;
    }



}
