package ru.job4j.start;
import ru.job4j.models.*;
import java.util.*;
/**
 * Created by Andrey on 02.04.2017.
 */
public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        //Item item = new Item();
        Item it = new Item("second name", "second desc", 2);
        tracker.add(it);
        Item it2 = new Item("third name", "third desc", 3);
        tracker.add(it2);
        Item it3 = new Item("force name", "third de34sc", 4);
        System.out.println(tracker.findAll().length);
        for(int i=0; i<tracker.findAll().length; i++) {
            System.out.println(tracker.findAll()[i].getName()+ " " + tracker.findAll()[i].getId());
        }
        for(Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }
        Item its = new Item("second name", "second desc", 2);
        tracker.delete(it2);
        for(Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }
        tracker.delete(it2);



    }
}
