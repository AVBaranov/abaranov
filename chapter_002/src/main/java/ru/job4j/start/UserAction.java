package ru.job4j.start;

/**
 * Created by Andrey on 09.04.2017.
 */
public interface UserAction {
    /**
     * method determines action.
     * @return key
     */
    int key();
    /**
     * method adds item.
     * @param input - input object
     * @param tracker - tracker object
     */
    void execute(Input input, Tracker tracker);
    /**
     * method show information about action.
     * @return information
     */
    String info();
}
