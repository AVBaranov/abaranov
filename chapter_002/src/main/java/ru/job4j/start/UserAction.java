package ru.job4j.start;

/**
 * Created by Andrey on 09.04.2017.
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
