package ru.job4j.collectionsframework.bank;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
//import java.util.Iterator;
/**
 * Created by Андрей on 04.05.2017.
 */
public class Action {
    /**
     * Map.
     */
    private Map<User, List<Account>> map = new HashMap<>();
    /**
     * method adds user to map.
     * @param user - additing user
     */
    public void addUser(User user) {
        ArrayList<Account> list = new ArrayList<Account>();
        map.put(user, list);
    }
    /**
     * method deletes user from map.
     * @param user - deliting user
     */
    public void deleteUser(User user) {
        map.remove(user);
    }
    /**
     * method returns current map.
     * @return map
     */
    public Map<User, List<Account>> getMap() {
        return map;
    }
    /**
     * method adds account to user.
     * @param user - additing user
     * @param account - additing account
     */
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
    /**
     * method deletes account to user.
     * @param user - deleting user
     * @param account - deleting account
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (!map.containsKey(user)) {
            throw new UserNotFoundException("user not found");
        }
        List<Account> temp = map.get(user);
        temp.remove(account);
        map.replace(user, temp);
    }
    /**
     * method returns user's accounts.
     * @param user - user for account
     * @return list of accounts
     */
    public List<Account> getUserAccounts(User user) {
        return map.get(user);
    }
    /**
     * method checks that user and account are exist.
     * @param user - checking user
     * @param account - checking account
     * @return checked account
     */
    public Account checkAccount(User user, Account account) {
        if (!map.containsKey(user) || !map.get(user).contains(account)) {
            throw new UserNotFoundException("user not found");
        }
            Account result = null;
            List<Account> list = map.get(user);

            for (Account acc : list) {
                if (acc.equals(account)) {
                    result = acc;
                }
            }
            return result;
    }
    /**
     * method transfers the money.
     * @param srcUser - source user
     * @param srcAccount - source account
     * @param dstUser - destenation user
     * @param dstAccount - destenation account
     * @param amount - money to transfer
     * @return true or false
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, int amount) {
        boolean b = false;

        if (checkAccount(srcUser, srcAccount) == null || checkAccount(dstUser, dstAccount) == null) {
            throw new UserNotFoundException("user not found");
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
