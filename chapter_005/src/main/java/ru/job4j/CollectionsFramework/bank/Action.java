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
    public Account checkAccount(User user, Account account) {
        Account ac = null;
        boolean b1 = true;
        boolean b2 = false;
        if (!map.containsKey(user)) {
            b1 = false;
        }
        Iterator<Account> iter = map.get(user).iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(account)) {
                b2 = true;
            }
        }
        if (b1 && b2) {
            ac = account;
        }
        return ac;
    }
    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, int amount) {
        boolean b = false;

        if (checkAccount(srcUser, srcAccount) == null) {
            return false;
        }
        if (checkAccount(dstUser, dstAccount) == null) {
            return false;
        }
        Account src = checkAccount(srcUser, srcAccount);
        Account dst = checkAccount(dstUser, dstAccount);
        if (src.getValue() >= amount) {
            src.setValue(srcAccount.getValue() - amount);
            dst.setValue(dstAccount.getValue() + amount);
            b = true;
        }
        return b;
    }



}
