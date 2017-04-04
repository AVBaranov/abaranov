package ru.job4j.start;
import ru.job4j.models.Item;
//import java.util.Random;
/**
 * class StartUI.
 */
public class StartUI {
    /**
     * method main.
     * @param args - arguments
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        //Item item = new Item();
        Item it = new Item("first name", "second desc", 2);
        tracker.add(it);
        Item it2 = new Item("second name", "second desc", 3);
        tracker.add(it2);
        Item it3 = new Item("third name", "third desc", 49);
        Item it4 = new Item("force name", "force desc", 49);
        tracker.add(it3);
        tracker.add(it4);
        System.out.println(tracker.findAll().length);
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(tracker.findAll()[i].getName());
        }
        System.out.println();
        /*for (Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }*/
        Item its = new Item("second name", "second desc", 2);
        tracker.delete(it3);

        tracker.delete(it2);
        System.out.println(tracker.findAll().length);
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(tracker.findAll()[i].getName());
        }
        tracker.update(it);
        for (int i = 0; i < tracker.findAll().length; i++) {
            System.out.println(tracker.findAll()[i].getName());
        }


        /*for (int i = 0; i < tracker.findByName("second name").length; i++) {
            System.out.println(tracker.findByName("second name")[i].getName());
        }*/
        //System.out.println(tracker.findByName("second name").length);



    }
}
