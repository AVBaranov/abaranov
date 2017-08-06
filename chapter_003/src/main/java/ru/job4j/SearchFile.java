package ru.job4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Andrey on 06.08.2017.
 */
public class SearchFile {

    /**
     * method search file.
     * @param src - source directory
     * @param target - target file
     * @param log - file for logs
     */
    public void findFile(File src, String target, File log) throws IOException {
        File[] array = src.listFiles();
        for (int i = 0; i < array.length; i++) {
            if (array[i].isDirectory()) {
                findFile(array[i], target, log);
            }
            if (target.equals(array[i].getName()) && !(array[i].isDirectory())) {
                FileOutputStream out = new FileOutputStream(log);
                out.write(array[i].getPath().getBytes());
                System.out.println(String.format("found %s", array[i].getName()));
                return;
            }
        }
    }

}
