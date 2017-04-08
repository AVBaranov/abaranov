package ru.job4j.start;
import ru.job4j.models.Item;
//import java.util.Arrays;
import java.util.Scanner;

//import ru.job4j.figure.Paint;
//import ru.job4j.figure.Square;
//import ru.job4j.figure.Triangle;
/**
 * class StartUI.
 */
public class StartUI {
    /**
     * Input object.
     */
    private Input input;
    /**
     * Tracker object.
     */
    private Tracker tracker;
    /**
     * Constructor.
     * @param input - Input object
     */
    StartUI(Input input) {
        this.input = input;
    }
    /**
     * Constructor.
     * @param input - Input object
     */
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Method for all calculate in program.
     */
    public void init() {
        //Tracker tracker = new Tracker();
        Scanner in = new Scanner(System.in);
        //ConsoleInput input = new ConsoleInput();
        String s = new String();
        for (;;) {
            System.out.print("0. Add new item\n1. Show all items\n2. Edit item\n3. Delete item\n4. Find item by id\n5. Find items by name\n6. Exit program\nSelect: ");
            // = in.next();
            s = input.ask();

            if (s.equals(String.valueOf(0))) {
                System.out.print("Enter your name: ");
                String name = input.ask();
                System.out.print("Enter task's description: ");
                String desc = input.ask();
                //System.out.print("Enter current date: ");
                //long create = input.askDate();
                Item it1 = new Item(name, desc/*, create*/);
                tracker.add(it1);
            }

            if (s.equals(String.valueOf(3))) {
                System.out.print("Enter your name: ");
                String name = input.ask();
                System.out.print("Enter task's description: ");
                String desc = input.ask();
                //System.out.print("Enter current date: ");
                //long create = input.askDate();
                Item temp = null;
                boolean b = false;
                for (int i = 0; i < tracker.findAll().length; i++) {
                    if (name.equals(tracker.findAll()[i].getName()) && desc.equals(tracker.findAll()[i].getDescription())/* && create == tracker.findAll()[i].getCreate()*/) {
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
                        System.out.println(String.format("%s %s %s", tracker.findAll()[i].getName(), tracker.findAll()[i].getDescription(), /*tracker.findAll()[i].getCreate(),*/ tracker.findAll()[i].getId()));
                        //System.out.println(tracker.findAll()[i].getName() + " " + tracker.findAll()[i].getDescription() + " " + tracker.findAll()[i].getCreate() + " " + tracker.findAll()[i].getId());
                        Item item = tracker.findAll()[i];
                    }
                } else {
                    System.out.println("Nothing to display");
                }
            }

            if (s.equals(String.valueOf(2))) {
                System.out.print("Enter item's id to replace: ");
                String id = input.ask();
                boolean b = true;
                for (int i = 0; i < tracker.findAll().length; i++) {
                    if (tracker.findAll()[i].getId().equals(id)) {
                        System.out.print("Enter new name: ");
                        //tracker.findAll()[i].setName(input.ask());
                        String name = input.ask();
                        System.out.print("Enter new description: ");
                        //tracker.findAll()[i].setDescription(input.ask());
                        String desc = input.ask();
                        //System.out.print("Enter new date: ");
                        //tracker.findAll()[i].setCreate(input.askDate());
                        //long create = input.askDate();
                        b = false;
                        tracker.update(id, new Item(name, desc/*, create*/));
                        break;
                    }
                }
                if (b) {
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
                    System.out.println(String.format("%s %s %s", it.getName(), it.getDescription(),/* it.getCreate(),*/ it.getId()));
                    /*System.out.println(it.getName() + " " + it.getDescription() + " " + it.getCreate() + " " + it.getId());*/
                } else {
                    System.out.println("You entered incorrect value!");
                }
            }
            if (s.equals(String.valueOf(5))) {
                System.out.print("Enter your name: ");
                String name = input.ask();
                for (int i = 0; i < tracker.findByName(name).length; i++) {
                    System.out.println(String.format("%s %s %s", tracker.findByName(name)[i].getName(), tracker.findByName(name)[i].getDescription(), /*tracker.findByName(name)[i].getCreate(), */tracker.findByName(name)[i].getId()));
                    //System.out.println(tracker.findByName(name)[i].getName() + " " + tracker.findByName(name)[i].getDescription() + " " + tracker.findByName(name)[i].getCreate() + " " + tracker.findByName(name)[i].getId());
                }
            }
            if (s.equals(String.valueOf(6))) {
                System.out.println("Bye!");
                //break;
                return;
                //System.exit(0);
            }
            if (!(s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6"))) {
                System.out.println("Incorrect input! Try again");
                continue;
            }
        }
    }
    /**
     * method main.
     * @param args - arguments
     */
    public static void main(String[] args) {
        StartUI obj = new StartUI(new ConsoleInput(), new Tracker());
        obj.init();

        /*Paint paint = new Paint();
        System.out.println(paint.draw(new Triangle()));
        String str = new String("  *\n ***\n*****\n");
        System.out.println(str.equals(paint.draw(new Triangle())));
        System.out.println(paint.draw(new Square()));*/

    }
}
