package ru.job4j.CollectionsFramework.bank;

/**
 * Created by Andrey on 06.05.2017.
 */
public class ValidAction extends Action {
    public void addAccountToUser(User user, Account account) {
        try {
            super.addAccountToUser(user, account);
        }
        catch(UserNotFoundException ufe) {
            System.out.println("user not found");
        }
    }
    public void deleteAccountFromUser(User user, Account account) {
        try {
            super.deleteAccountFromUser(user, account);
        }
        catch(UserNotFoundException ufe) {
            System.out.println("user not found");
        }
    }

}
