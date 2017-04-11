package ru.job4j.start;
//import ru.job4j.models.Item;
//import java.util.Arrays;
//import java.util.Scanner;

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
     * @param tracker - Tracker object
     */
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Method for all calculate in program.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            if (key == 6) {
                System.out.println("Bye");
                break;
            }
            menu.select(key);
        } while (/*!"y".equals(this.input.ask("Exit? : y/n"))*/true);
    }

    /**
     * method main.
     * @param args - arguments
     */
    public static void main(String[] args) {
        StartUI obj = new StartUI(new ConsoleInput(), new Tracker());
        obj.init();
    }
}
