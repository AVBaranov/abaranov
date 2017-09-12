package ru.job4j.synchronization.searchText;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 05.09.2017.
 */
public class ParallelStream {

    private List<String> textStore = new ArrayList<>();

    public boolean search(File root, String text, List<String> exp) {
        synchronized (this) {
//            List<String> result = new ArrayList<>();
            /**
             *  boolean folder for checking if searching word was found.
             */
            boolean ADDELEMENT = false;
            File[] array = root.listFiles();
            boolean b = true;
            for (int i = 0; i < array.length; i++) {
               // если элемент корневой директории является директорией, то рекурсивно вызываем метод для этого элемента
                if (array[i].isDirectory()) {
                    search(array[i], text, exp);
                }
                // если элемент не является директорией, то начинаем поиск
                if (!array[i].isDirectory()) {
                    //проверяем есть ли файлы с таким с расширением
                    String expansion = array[i].getName().replace(".", "AAA");
                    String[] expArr = expansion.split("AAA");
                    for (int x = 0; x < exp.size(); x++) {
                        if (exp.get(x).equalsIgnoreCase(expArr[expArr.length - 1])) {
                            b = false;
                            break;
                        }
                    }
                    //если файлов с таким расширением нет, то выбрасываем исключение
                    if (b) {
                        throw new NoSuchExpansionException("no such expansion");
                    }
                    //если файлы с таким расширением есть, то приступаем к поиску искомого слова в файлах директории
                    try (FileInputStream fin = new FileInputStream(array[i])) {
                        char[] ar = new char[fin.available()];
                        for (int j = 0; j < ar.length; j++) {
                            ar[j] = (char) fin.read();
                        }
                        String str = new String(ar);
                        String[] strArr = str.split(" ");
                        for (int j = 0; j < strArr.length; j++) {
                            if (strArr[j].equalsIgnoreCase(text)) {
//                                result.add(array[i].getPath());
                                textStore.add(array[i].getPath());
                                ADDELEMENT = true;
                                break;
                            }
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return ADDELEMENT;
        }
    }

    public void show() {
        for (String value : textStore) {
            System.out.println(value);
        }
    }
}
