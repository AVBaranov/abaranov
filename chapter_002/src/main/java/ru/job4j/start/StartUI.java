package ru.job4j.start;
import ru.job4j.models.Item;
//import java.util.Random;
import java.util.Scanner;
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

        /*Item it = new Item("second name", "second desc", 2);
        tracker.add(it);
        Item it2 = new Item("third name", "third desc", 3);
        tracker.add(it2);
        Item it3 = new Item("force name", "force desc", 4);
        tracker.add(it3);
        Item it4 = new Item("second name", "force desc", 4);
        tracker.add(it4);*/
        Scanner in = new Scanner(System.in);
        ConsoleInput input = new ConsoleInput();
        String s = new String();
        for (;;) {
            System.out.print("0. Add new item\n1. Show all items\n2. Edit item\n3. Delete item\n4. Find item by id\n5. Find items by name\n6. Exit program\nSelect: ");
            s = in.next();
            if (s.equals(String.valueOf(0))) {
                System.out.print("Enter your name: ");
                String name = input.ask();
                System.out.print("Enter task's description: ");
                String desc = input.ask();
                System.out.print("Enter current date: ");
                long create = input.askDate();
                Item it1 = new Item(name, desc, create);
                tracker.add(it1);
            }
            if (s.equals(String.valueOf(3))) {
                System.out.print("Enter your name: ");
                String name = input.ask();
                System.out.print("Enter task's description: ");
                String desc = input.ask();
                System.out.print("Enter current date: ");
                long create = input.askDate();
                Item temp = null;
                boolean b = false;
                for (int i = 0; i < tracker.findAll().length; i++) {
                    if (name.equals(tracker.findAll()[i].getName()) && desc.equals(tracker.findAll()[i].getDescription()) && create == tracker.findAll()[i].getCreate()) {
                        temp = tracker.findAll()[i];
                        b = true;
                        break;
                    }
                }
                if (b) {
                    tracker.delete(temp);
                    System.out.println("Done");
                } else {
                    System.out.println("You entered incorrect value!");
                }

            }
            if (s.equals(String.valueOf(1))) {
                if (tracker.findAll().length != 0) {
                    System.out.println("Your items:");
                    for (int i = 0; i < tracker.findAll().length; i++) {
                        System.out.println(tracker.findAll()[i].getName() + " " + tracker.findAll()[i].getDescription() + " " + tracker.findAll()[i].getCreate());
                    }
                } else {
                    System.out.println("Nothing to display");
                }
            }
            if (s.equals(String.valueOf(2))) {
                System.out.print("Enter your name: ");
                String name = input.ask();
                System.out.print("Enter task's description: ");
                String desc = input.ask();
                System.out.print("Enter current date: ");
                long create = input.askDate();
                Item temp = null;
                boolean b = false;
                for (int i = 0; i < tracker.findAll().length; i++) {
                    if (name.equals(tracker.findAll()[i].getName()) && desc.equals(tracker.findAll()[i].getDescription()) && create == tracker.findAll()[i].getCreate()) {
                        temp = tracker.findAll()[i];
                        b = true;
                        break;
                    }
                }
                if (b) {
                    tracker.update(temp);
                    System.out.println("Done");
                } else {
                    System.out.println("You entered incorrect value!");
                }


            }
            if (s.equals(String.valueOf(6))) {
                System.out.println("Bye!");
                break;
            }
            if (!(s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("6"))) {
                System.out.println("Incorrect input! Try again");
                continue;
            }
        }


    }
}
