package ru.job4j;
import ru.job4j.input_output.*;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.nio.charset.CharsetEncoder;
import java.util.*;

/**
 * Created by Андрей on 15.06.2017.
 */


 class comparator implements Comparator<List<Character>> {
    @Override
    public int compare(List<Character> o1, List<Character> o2) {
        if (o1.size() >= o2.size()) return 1;
        else if(o1.size() < o2.size()) return -1;
        else return 0;
    }
}

public class Run {
    public static void main(String[] args){


//        String[] ar = new String[10];
//
//        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
//            for (int i = 0; i < ar.length; i++) {
//                ar[i] = bf.readLine();
//                if (ar[i].equals("stop")) break;
//            }
//        }
//        catch (IOException e) {
//            e.getStackTrace();
//        }
//
//        for (String value : ar) {
//            System.out.print(value + " ");
//            if (value.equals("stop")) break;
//        }




//        String str = null;
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            str = br.readLine();
//
//        }
//        catch (IOException e) {
//            e.getStackTrace();
//        }
//
//        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))){
//            out.write(str);
//        }
//        catch (IOException e) {
//            e.getStackTrace();
//        }

//        dropAbuses(System.in, System.out, new String[]{"asd", "sdaf", "sdtgh", "asd", "sdg"});





//        boolean b;
//        String[] ar = new String[]{"str1", "str2", "str3"};
//        String str;
//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            for (;;) {
//                b = true;
//                str = br.readLine();
//                if (str.equals("quit")) break;
//                for (String value : ar) {
//                    if (str.equals(value)) {
//                        b = false;
//                        break;
//                    }
//
//                }
//                if (b) {
//                    PrintWriter pr = new PrintWriter(System.out, true);
//                    pr.println(str);
//                }
//            }
//        }
//        catch (IOException e) {
//            e.getStackTrace();
//        }
        Abuse ab = new Abuse();
        ab.dropAbuses(System.in, System.out, new String[] {"str1", "str2", "str3"});

//        try (FileInputStream fin = new FileInputStream("C:\\Users\\Андрей\\Desktop\\file.txt")) {
//            FileOutputStream fout = new FileOutputStream("C:\\Users\\Андрей\\Desktop\\FILE1000000.txt");
//
//            int value;
//            while ((value = fin.read()) != -1) {
//                fout.write(value);
//            }
//        }
//        catch (IOException e) {
//            e.getMessage();
//        }

//        try (FileWriter fout = new FileWriter("C:\\Users\\Andrey\\Desktop\\FILE1000000.txt")) {
//            fout.write("first\r\nline");
////            fout.append('\n');
////            fout.append("second line");
//        }
//        catch (IOException e) {
//            e.getMessage();
//        }

        Set<List<Character>> set = new TreeSet<>(new comparator());
        List<Character> buffer = new ArrayList<>();
        List<List<Character>> store = new ArrayList<>();
        /*try (FileReader fin = new FileReader("C:\\Users\\Andrey\\Desktop\\FILE1000000.txt")) {

            int value;
            while (true) {
                value = fin.read();
                if (value == -1) {
                    store.add(buffer);
                    break;
                }
                buffer.add((char) value);
                if (((Character)(char)value).equals('\n') ) {
                    store.add(buffer);
                    buffer = new ArrayList<>();
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }*/

        /*try (FileReader fin = new FileReader("C:\\Users\\Andrey\\Desktop\\FILE1000000.txt")) {

            int value;
            while (true) {
                value = fin.read();
                if (value == -1) {
//                    store.add(buffer);
                    break;
                }
                buffer.add((char) value);
                if (((Character)(char)value).equals('\n') ) {
                    store.add(buffer);
                    set.add(buffer);
                    buffer = new ArrayList<>();
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }

        for (List<Character> value : store) {
            for (Character value2 : value) {
                System.out.print(value2);
            }
    }

        System.out.println();
        System.out.println();
        System.out.println(set.size());

        for (List<Character> value : set) {
            for (Character value2 : value) {
                System.out.print(value2);
            }
        }

        try (FileWriter fw = new FileWriter("C:\\Users\\Andrey\\Desktop\\DESTFILE.txt")) {
            for (List<Character> value : set) {
                for (Character value2 : value) {
                    fw.write(value2);
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }*/

        SortFile sort = new SortFile();
        sort.sort("C:\\Users\\Andrey\\Desktop\\SRC.txt", "C:\\Users\\Andrey\\Desktop\\DEST.txt");









        /*for (int i = 0; i < store.size() - 1; i++) {

            if (store.get(i).size() > store.get(i + 1).size()) {
                List<Character> temp = store.get(i);
                store.set(i, store.get(i + 1));
                store.set(i + 1, temp);
            }
        }

        for (List<Character> value : store) {
            for (Character value2 : value) {
                System.out.print(value2);
            }
        }*/
        System.out.println();


        System.out.println("****************************");


        List<Character> check = new ArrayList<>();
        check.add('f');
        check.add('i');
        check.add('r');
        check.add('s');
        check.add('t');
        check.add('\n');
        check.add('s');
        check.add('e');
        check.add('c');
        check.add('o');
        check.add('n');
        check.add('d');
        check.add('\n');
        check.add('t');
        check.add('h');
        check.add('i');
        check.add('r');
        check.add('d');

        List<Character> buf = new ArrayList<>();
        List<List<Character>> ls = new ArrayList<>();

        System.out.println();

        for (int i = 0; i < check.size(); i++) {
            buf.add(check.get(i));
            if (check.get(i).equals('\n') || i == check.size() - 1) {
                ls.add(buf);
                System.out.println("checking...");
                buf = new ArrayList<>();
            }
        }

        System.out.println();
        for (List<Character> value : ls) {
            for (Character value2 : value) {
                System.out.print(value2);
            }
        }



        /*for (List<Character> value : store) {
            for (Character value2 : value) {
                System.out.print(value2);
            }
        }*/

        String str = new String("st");
        System.out.println(str.contains("s"));
        String[] ar = new String[] {"asd", "aq", "str", "st"};
        List<String> list = new ArrayList();
        for (String value : ar) {
            list.add(value);
        }
        System.out.println(list.contains(str));





    }




}
