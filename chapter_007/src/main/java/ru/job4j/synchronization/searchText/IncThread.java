package ru.job4j.synchronization.searchText;

import java.io.File;
import java.util.List;

/**
 * Created by Andrey on 05.09.2017.
 */
public class IncThread extends Thread {

    File root;
    String text;
    List<String> exp;

    public IncThread(File root, String text, List<String> exp) {
        this.root = root;
        this.text = text;
        this.exp = exp;
    }

    @Override
    public void run() {
        new ParallelStream().search(this.root, this.text, this.exp);
    }
}
