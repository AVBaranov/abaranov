package ru.job4j.start;
import ru.job4j.models.Item;
//import java.util.Arrays;
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
                        System.out.println(String.format("%s %s %s %s", tracker.findAll()[i].getName(), tracker.findAll()[i].getDescription(), tracker.findAll()[i].getCreate(), tracker.findAll()[i].getId()));
                        //System.out.println(tracker.findAll()[i].getName() + " " + tracker.findAll()[i].getDescription() + " " + tracker.findAll()[i].getCreate() + " " + tracker.findAll()[i].getId());
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
            if (s.equals(String.valueOf(4))) {
                System.out.print("Enter ID: ");
                String temp = input.ask();
                /*boolean b = true;
                for(int i=0; i<tracker.findAll().length; i++) {
                    if(tracker.findAll()[i].getId().equals(temp)) {
                        System.out.println("Your request:");
                        System.out.println(tracker.findAll()[i].getName() + " " + tracker.findAll()[i].getDescription() + " " + tracker.findAll()[i].getCreate() + " " + tracker.findAll()[i].getId());
                        b = false;
                        break;
                    }
                }
                if (b) {
                    System.out.println("You entered incorrect value!");
                }*/
                Item it = tracker.findById(temp);
                if (it != null) {
                    System.out.println(String.format("%s %s %s %s", it.getName(), it.getDescription(), it.getCreate(), it.getId()));
                    /*System.out.println(it.getName() + " " + it.getDescription() + " " + it.getCreate() + " " + it.getId());*/
                } else {
                    System.out.println("You entered incorrect value!");
                }
            }
            if (s.equals(String.valueOf(5))) {
                System.out.print("Enter your name: ");
                String name = input.ask();
                for (int i = 0; i < tracker.findByName(name).length; i++) {
                    System.out.println(String.format("%s %s %s %s", tracker.findByName(name)[i].getName(), tracker.findByName(name)[i].getDescription(), tracker.findByName(name)[i].getCreate(), tracker.findByName(name)[i].getId()));
                    //System.out.println(tracker.findByName(name)[i].getName() + " " + tracker.findByName(name)[i].getDescription() + " " + tracker.findByName(name)[i].getCreate() + " " + tracker.findByName(name)[i].getId());
                }
            }
            if (s.equals(String.valueOf(6))) {
                System.out.println("Bye!");
                break;
            }
            if (!(s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6"))) {
                System.out.println("Incorrect input! Try again");
                continue;
            }
        }



    }
}
