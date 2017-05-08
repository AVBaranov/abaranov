package ru.job4j.collectionsframework;

import org.junit.Test;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Andrey on 30.04.2017.
 */
public class UserConvertTest {
    /**
     * Test convert collection to array.
     */
    @Test
    public void whenCollectionHasNineElementsThenArrayIsTheSame() {
        UserConvert usercon = new UserConvert();
        User user = new User(11, "mouse", "mouseland");
        User user2 = new User(1112, "fish", "fishland");
        User user3 = new User(11234, "volf", "volfland");
        HashMap<Integer, User> expectetion = new HashMap<>();
        expectetion.put(11, user);
        expectetion.put(1112, user2);
        expectetion.put(11234, user3);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        list.add(user3);
        HashMap<Integer, User> reality = usercon.process(list);
        assertThat(expectetion, is(reality));
    }
}
