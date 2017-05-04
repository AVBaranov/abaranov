package ru.job4j.CollectionsFramework.bank;
import java.util.*;
/**
 * Created by Андрей on 04.05.2017.
 */
public class Action {
    private List<User> users = new ArrayList<>();
    //private List<Account> accounts = new ArrayList<>();
    private Map<User, List<Account>> map = new HashMap<>();
    public void addUser(User user) {
        //users.add(user);
        map.put(user, user.accounts);
    }
    public void deleteUser(User user) {
        //users.remove(user);
        map.remove(user);
    }
    public void addAccountToUser(User user, Account account) {

                user.accounts.add(account);
                //List<Account> tempaccounts = new ArrayList<>();
                //tempaccounts.add(account);
                map.put(user, user.accounts);


    }
    public void deleteAccountFromUser(User user, Account account) {
        //user.accounts.remove(account);
        List<Account> temp = map.get(user);
        temp.remove(account);
        map.replace(user, temp);
    }
    public List<Account> getUserAccounts(User user) {
        //return user.accounts;
        return map.get(user);
    }
    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, int amount) {
        boolean b = true;
        Iterator<Account> srciter = srcUser.accounts.iterator();
        boolean src = true;
        while (srciter.hasNext()) {
            if (srciter.next().equals(srcAccount)) {
                src = false;
            }
        }
        if (src) {
            return false;
        }

        Iterator<Account> dstiter = dstUser.accounts.iterator();
        boolean dst = true;
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

    List<Account> meth(User user) {
        return map.get(user);
    }

}
