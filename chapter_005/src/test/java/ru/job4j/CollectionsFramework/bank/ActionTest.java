package ru.job4j.CollectionsFramework.bank;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Andrey Baranov
 * @version $Id$
 * @since 0.1
 */
public class ActionTest {
    /**
     * Convert array to collection.
     */
    @Test
    public void whenMinusFiveThousandFromFirstAccountThenPlusFiveThousandToSecondAccount() {
        ValidAction ob = new ValidAction();
        User user1 = new User("black", "0506 122312");
        User user2 = new User("white", "0557 112232");
        ob.addUser(user1);
        ob.addUser(user2);
        Account ac1 = new Account(50000, 122334);
        Account ac2 = new Account(40000, 125554);
        ob.addAccountToUser(user1, ac1);
        ob.addAccountToUser(user2, ac2);
        ob.transferMoney(user1, /*user1.accounts*/ob.getMap().get(user1).get(0), user2, /*user2.accounts.get(0)*/ob.getMap().get(user2).get(0), 5000);
        int expectetion = ob.getUserAccounts(user2).get(0).getValue();
        int reality = 45000;
        assertThat(expectetion, is(reality));
    }

}
