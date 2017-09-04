package ru.job4j.synchronization;

import ru.job4j.synchronization.store.User;
import ru.job4j.synchronization.store.UserStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey on 03.09.2017.
 */
public class RunThreads {

    public static void main(String[] args) {
        /*Counter counter = new Counter();
        Thread t1 = new IndirectThreaed(counter);
        Thread t2 = new IndirectThreaed(counter);
        Thread t3 = new IndirectThreaed(counter);
        Thread t4 = new IndirectThreaed(counter);
        Thread t5 = new IndirectThreaed(counter);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());*/

        /*UserStorage store = new UserStorage();
        store.add(new User(1, 100));
        store.add(new User(2, 150));
        System.out.println(String.format("%s %s\n%s %s", store.get(0).getId(), store.get(0).getAmount(), store.get(1).getId(), store.get(1).getAmount()));
        store.transfer(1,2,90);
        System.out.println(String.format("%s %s\n%s %s", store.get(0).getId(), store.get(0).getAmount(), store.get(1).getId(), store.get(1).getAmount()));
        store.transfer(1,2,10);
        System.out.println(String.format("%s %s\n%s %s", store.get(0).getId(), store.get(0).getAmount(), store.get(1).getId(), store.get(1).getAmount()));

        File file = new File("C:\\Users\\Andrey\\Desktop/2");
        File[] array = file.listFiles();
        try (FileInputStream fin = new FileInputStream("C:\\Users\\Andrey\\Desktop/2/1.txt")) {
            char[] ar = new char[fin.available()];
            for (int i = 0; i < ar.length; i++) {
                ar[i] = (char) fin.read();
            }
            for (char value : ar) {
                System.out.print(value);
            }
            String str = new String(ar);
            System.out.println("\n" + str);
            String[] mas = str.split(" ");
            for (String value : mas) {
                System.out.println(value);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String check = new String("check");
        for (int i = 0; i < array.length; i++) {
            if (!array[i].isDirectory()) {
                try (FileInputStream fin = new FileInputStream("C:\\Users\\Andrey\\Desktop/2/1.txt")) {
                    char[] ar = new char[fin.available()];
                    for (int j = 0; j < ar.length; j++) {
                        ar[j] = (char) fin.read();
                    }
                    String str = new String(ar);
                    String[] strArr = str.split(" ");
                    for (int j = 0; j < strArr.length; j++) {
                        if (strArr[j].equalsIgnoreCase(check)) {
                            System.out.println("fuck you");
                            break;
                        }
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
        List<String> ls = new RunThreads().parallelStream(new File("C:\\Users\\Andrey\\Desktop/2"), "check");
        for (String value : ls) {
            System.out.println(value);
        }

    }



    public List<String> parallelStream(File root, String text) {
        List<String> result = new ArrayList<>();
        File[] array = root.listFiles();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].isDirectory()) {
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
