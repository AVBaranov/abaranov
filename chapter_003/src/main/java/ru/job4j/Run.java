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

class comp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() > o2.length() ? 1 : -1;
    }
}

class comp2 implements Comparator<Character[]> {
    @Override
    public int compare(Character[] o1, Character[] o2) {
        return o1.length >= o2.length ? 1 : -1;
    }
}

class cl implements FilenameFilter {

     final String str;

     public cl(String str) {
         this.str = str;
     }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(this.str);
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
//        ab.dropAbuses(System.in, System.out, new String[] {"str1", "str2", "str3"});

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
        sort.sort(new File("C:\\Users\\Andrey\\Desktop\\SRC.txt"), new File("C:\\Users\\Andrey\\Desktop\\DEST.txt"));









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


        System.out.println();
        File file = new File("C:\\Users\\Andrey\\Desktop/TEMP/filik.txt");
//        for (int i = 0; i < 5; i++) {
//            try (RandomAccessFile r = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/failik" + (i + 1) + ".txt", "rw")) {
//                r.write(new byte[] {'k','a', 'k', 'a'});
//            }
//            catch (IOException e) {
//                e.getMessage();
//            }
//        }

        int count = 0;
        List<Character> list = new ArrayList<>();
        List<List<Character>> ll = new ArrayList<>();

        List<Character[]> listchar;
        try (RandomAccessFile rf = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/file.txt", "rw")) {
            int value;
            int i = 0;
            while ((value = rf.read()) != -1) {
                list.add((char) value);
                if (((Character)(char)value).equals('\n') ) {
                    ll.add(list);
                    list = new ArrayList<>();
                }
                if ((char) value == '\n') {
                    count++;
                }
                if (count >= 5) {
                    count = 0;
                    listchar = new ArrayList<>();
                    List<Object[]> listobj = new ArrayList<>();
                    for (int j = 0; j < ll.size(); j++) {
                        listobj.add(ll.get(j).toArray());
                    }
                    for (int x = 0; x < listobj.size(); x++) {
                        Character[] temp = new Character[listobj.get(x).length];
                        for (int y = 0; y < listobj.get(x).length; y++) {
                            temp[y] = (Character) listobj.get(x)[y];
                        }
                        listchar.add(temp);
                    }
                    listchar.sort(new comp2());

                    RandomAccessFile r = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part" + (i + 1) + ".txt", "rw");

                    for (int j = 0; j < listchar.size(); j++) {
                        byte[] ar = new byte[listchar.get(j).length];
                        for (int k = 0; k < ar.length; k++) {
                            ar[k] = (byte) (char) listchar.get(j)[k];
                        }
                        r.write(ar);

                    }
                    ll.clear();
                    i++;
                }
//                count++;
            }

        }
        catch (IOException e) {
            e.getMessage();
        }

//        listchar.sort(new comp2());
//        for (int i = 0; i < listchar.size(); i++) {
//            for (Character value : listchar.get(i)) {
//                System.out.print(value);
//            }
//        }


        System.out.println();
        List<String> l = new ArrayList<>();
        l.add("str");
        l.add("string");
        l.add("offstring");
        l.add("onstr");
        l.add("asdfsdsffsdfsdfsfdsf");
        l.sort(new comp().reversed());
        for (String value : l) {
            System.out.println(value);
        }
        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(i).length() < l.get(j).length()) {
//                    String buff = l.get(i);
//                    l.add(i, l.get(j));
//                    l.add(j, buff);
                }
            }

        }

//        for (int i = 0; i < ll.size(); i++) {
//            for (int j = 0; j < ll.get(i).size(); j++) {
//                System.out.print(ll.get(i).get(j));
//            }
//
//        }





        String str = new String("str");
        char[] mas = str.toCharArray();
        byte[] ar = new byte[mas.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (byte) mas[i];
        }
        try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/FILE1000000.txt", "rw")) {
            ra.write(ar);
        }
        catch (IOException e) {

        }




//        String str = new String("dfghshghdf");
//        try (RandomAccessFile ra = new RandomAccessFile(new File("C:\\Users\\Andrey\\Desktop/test.txt"), new String("rw"))){
//
//            byte[] ar = new byte[(int) ra.length()];
//            ra.write(str.getBytes());
//            ra.seek(0);
//            ra.read(ar);
//            for (byte value : ar) {
//                System.out.print((char) value);
//            }
//
//
//
//        }
//        catch (IOException e) {
//            e.getMessage();
//        }

        File file2 = new File("C:\\Users\\Andrey\\Desktop/test.txt");
        System.out.println();
        System.out.println(file2.length());
        try (RandomAccessFile rf = new RandomAccessFile(file2, "rw");) {
            int temp;
            while ((temp = rf.read()) != -1) {
                System.out.print((char) temp);
            }

        }
        catch (IOException e) {
            e.getMessage();
        }















    }




}
