package ru.job4j.CollectionsFramework.bank;
import java.util.*;
/**
 * Created by Андрей on 04.05.2017.
 */
public class run {
    public static void main(String[] args) {
        User user1 = new User("petrushka", "0506 122312");
        User user2 = new User("penek", "0557 112232");
        User user3 = new User("utka", "0517 112121");
        Action ob = new Action();
        ob.addUser(user1);
        ob.addUser(user2);
        ob.addUser(user3);
        Account ac1 = new Account(1000, 122334);
        Account ac2 = new Account(40000, 125554);
        Account ac3 = new Account(7000000, 125777554);
        //ob.addAccountToUser(user1, ac1);
        //ob.addAccountToUser(user1, new Account(100000, 12231234));
        //ob.addAccountToUser(user1, new Account(20000000, 12234));
        ob.addAccountToUser(user1, ac2);
        ob.addAccountToUser(user1, ac3);
        ob.addAccountToUser(user2, ac1);
        System.out.println(ob.meth(user1));
        System.out.println(ob.meth(user2));
        int i = 0;
        /*for (Account value : ob.getUserAccounts(user1))
        {
            System.out.println(value.getValue());
            i++;
        }*/


        ob.deleteAccountFromUser(user2, ac1);

        i = 0;
        /*for (Account value : ob.getUserAccounts(user1))
        {
            System.out.println(value.getValue());
            i++;
        }*/





    }
}
