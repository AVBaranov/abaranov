package ru.job4j.collectionsframework.bank;

/**
 * Created by Andrey on 06.05.2017.
 */
public class ValidAction extends Action {
    /**
     * method for valid account's adding.
     * @param user - adding user
     * @param account - adding account
     */
    public void addAccountToUser(User user, Account account) {
        try {
            super.addAccountToUser(user, account);
        } catch (UserNotFoundException ufe) {
            System.out.println("user not found");
        }
    }
    /**
     * method for valid account's deleting.
     * @param user - deleting user
     * @param account - deleting account
     */
    public void deleteAccountFromUser(User user, Account account) {
        try {
            super.deleteAccountFromUser(user, account);
        } catch (UserNotFoundException ufe) {
            System.out.println("user not found");
        }
    }
    /**
     * method for valid account's checking.
     * @param user - deleting user
     * @param account - deleting account
     * @return user's account
     */
    public Account checkAccount(User user, Account account) {
        Account ac = null;
        try {
            ac = super.checkAccount(user, account);
        } catch (UserNotFoundException ufe) {
            System.out.println("user or account not found");
        }
        return ac;
    }
    /**
     * method for valid account's checking.
     * @param srcUser - source user
     * @param srcAccount - source account
     * @param dstUser - destination user
     * @param dstAccount - destination account
     * @param amount - amount of money
     * @return true or false
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, int amount) {
        boolean b = false;
        try {
            super.transferMoney(srcUser, srcAccount, dstUser, dstAccount, amount);
            b = true;
        } catch (UserNotFoundException ufe) {
           System.out.println();
        }
        return b;
    }

}
