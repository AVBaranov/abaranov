package ru.job4j.CollectionsFramework.bank;
import javax.jws.soap.SOAPBinding;
import java.util.*;
/**
 * Created by Андрей on 04.05.2017.
 */
class comparator implements Comparator<String> {
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
}
class test {
    int a;
    int b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        test test = (test) o;

        if (a != test.a) return false;
        return b == test.b;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }

    public test(int a, int b) {
        this.a = a;
        this.b = b;

    }
}
public class run {
    public static void main(String[] args) {

        ValidAction ob = new ValidAction();
        User u1 = new User("petrushka", "0506 122312");
        User u2 = new User("penek", "0557 112232");
        User u3 = new User("penekas", "0557 112232");
        ob.addUser(u1);
        ob.addUser(u2);
        Account ac1 = new Account(10000, 122334);
        Account ac2 = new Account(40000, 125554);
        Account ac3 = new Account(410000, 125554);
        Account ac4 = new Account(41000000, 125554);
        ob.addAccountToUser(u1, ac1);
        ob.addAccountToUser(u2, ac2);
        ob.addAccountToUser(u1, ac3);
        ob.addAccountToUser(u1, ac4);
        /*for (Account ac : ob.getUserAccounts(u1)) {
            System.out.println(ac.getValue());
        }*/
        List<Account> l1 = new ArrayList<>();
        l1.add(ac1);
        System.out.println(ob.getUserAccounts(u1).get(0).getValue());
        System.out.println(ob.getUserAccounts(u2).get(0).getValue());
        //ob.transferMoney(u1, ob.getMap().get(u1).get(0), u2, ob.getMap().get(u2).get(0), 5000);
        System.out.println(ob.getUserAccounts(u1).get(0).getValue());
        System.out.println(ob.getUserAccounts(u2).get(0).getValue());
        //ob.transferMoney(u1, ob.getMap().get(u1).get(0), u2, ob.getMap().get(u2).get(0), 5000);
        System.out.println(ob.transferMoney(u1, ac1, u2, ac2, 5000));
        System.out.println(ob.getUserAccounts(u1).get(0).getValue());
        System.out.println(ob.getUserAccounts(u2).get(0).getValue());
        System.out.println(ob.getMap().size());
        //Set<User> set = ob.getMap().keySet();
        for (User user : ob.getMap().keySet()) {
            System.out.println(user.getName());
        }
        System.out.println(ob.getMap().get(u1).get(0).getValue());



    }
}
