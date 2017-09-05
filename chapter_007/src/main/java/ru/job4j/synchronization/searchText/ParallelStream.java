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

    static List<String> LIST = new ArrayList<>();

    public List<String> search(File root, String text, List<String> exp) {
        synchronized (this) {
            List<String> result = new ArrayList<>();
            File[] array = root.listFiles();
            boolean b = true;
            for (int i = 0; i < array.length; i++) {
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
                                result.add(array[i].getPath());
                                LIST.add(array[i].getPath());
                                break;
                            }
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }
    }

    public void show() {
        for (String value : LIST) {
            System.out.println(value);
        }
    }
}
