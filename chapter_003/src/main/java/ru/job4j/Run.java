package ru.job4j;
import ru.job4j.input_output.*;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.nio.charset.CharsetEncoder;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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


class comp implements Comparator<Character[]> {
    @Override
    public int compare(Character[] o1, Character[] o2) {
        return o1.length >= o2.length ? 1 : -1;
    }
}
class comp2 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() >= o2.length() ? 1 : -1;
    }
}


public class Run {
    public static void main(String[] args){


        /*int count = 0;
        int counter = 0;
        int end = 0;
        int endcount = 0;
        List<Character> list = new ArrayList<>();
        List<List<Character>> ll = new ArrayList<>();
        List<Character[]> listchar;
        List<Object[]> listobj = new ArrayList<>();
        List<String> strlist = new ArrayList<>();
        String str = new String("");
        try (RandomAccessFile rf = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/file.txt", "rw")) {
            int value;
            int i = 1;
            while ((value = rf.read()) != -1) {
                if ((char) value == '\n') {
                    end++;
                }
            }
            rf.seek(0);
            while ((value = rf.read()) != -1) {
                str += (char) value;
                list.add((char) value);
                if (((Character)(char)value).equals('\n') ) {
                    ll.add(list);
                    list = new ArrayList<>();
                    strlist.add(str);
                    str = "";
                }
                if ((char) value == '\n') {
                    endcount++;
                    count++;
                }



                if (count >= 5) {
                    counter++;
                    count = 0;
                    listchar = new ArrayList<>();
                    listobj = new ArrayList<>();
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
                    listchar.sort(new comp());

                    RandomAccessFile r = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part" + (i++) + ".txt", "rw");

                    for (int j = 0; j < listchar.size(); j++) {
                        byte[] ar = new byte[listchar.get(j).length];
                        for (int k = 0; k < ar.length; k++) {
                            ar[k] = (byte) (char) listchar.get(j)[k];
                        }
                        r.write(ar);

                    }
                    ll.clear();

                }

                //  ЭТОТ БЛОК IF НУЖЕН ЧТОБЫ УЧЕСТЬ ПОСЛЕДНИЕ БАЙТЫ В ИСХОДНОМ ФАЙЛЕ И ЗАПИСАТЬ ИХ В ОТДЕЛЬНЫЙ ФАЙЛ
                if (endcount >= end) {
                    listchar = new ArrayList<>();
                    listobj = new ArrayList<>();
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
                    listchar.sort(new comp());
                    RandomAccessFile r = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part" + (counter + 1) + ".txt", "rw");
                    for (int j = 0; j < listchar.size(); j++) {
                        byte[] ar = new byte[listchar.get(j).length];
                        for (int k = 0; k < ar.length; k++) {
                            ar[k] = (byte) (char) listchar.get(j)[k];
                        }
                        r.write(ar);

                    }
                    ll.clear();
                }

            }
            System.out.println(end);
        }
        catch (IOException e) {
            e.getMessage();
        }






        // БЕРЕМ 1-Й ВРЕМЕННЫЙ ФАЙЛ И ПОМЕЩАЕМ ЕГО В СПИСОК
        List<String> endlist1 = new ArrayList<>();
        String endstr1 = new String("");
        try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part1.txt", "rw")) {
            int value;
            while ((value = ra.read()) != -1) {
                endstr1 += (char) value;
                if (((Character) (char) value).equals('\n')) {
                    endlist1.add(endstr1);
                    endstr1 = "";
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }


        String[] finalar1 = new String[endlist1.size()];
        for (int i = 0; i < finalar1.length; i++) {
            finalar1[i] = (String) endlist1.toArray()[i];
        }




        List<String> templist = new ArrayList<>();
        String tempstr = new String("");
        int k = 2;
        for (int i = 0; i < counter; i++) {
            try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part" + (k++) + ".txt", "rw")) {
                int value;
                while ((value = ra.read()) != -1) {
                    tempstr += (char) value;
                    if (((Character) (char) value).equals('\n')) {
                        templist.add(tempstr);
                        tempstr = "";
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }

            String[] tempar = new String[templist.size()];
            for (int j = 0; j < tempar.length; j++) {
                tempar[j] = templist.get(j);
            }
            finalar1 = mergesort(finalar1, tempar);

            templist.clear();

        }
        for (String value : finalar1) {
            System.out.print(value);
        }

        try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/FINAL.txt", "rw")) {

            for (int i = 0; i < finalar1.length; i++) {
                byte[] temp = new byte[(finalar1[i].toCharArray()).length];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = (byte) finalar1[i].toCharArray()[j];
                }
                ra.write(temp);
            }
        }
        catch (IOException e) {
            e.getMessage();
        }*/


        new SortFile().sortfile(new File("C:\\Users\\Анна\\Desktop/file.txt"), new File("C:\\Users\\Анна\\Desktop/FINAL.txt"));

        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("C:\\Users\\Анна\\Desktop/file.zip"))) {
            System.out.println(zin.getNextEntry() + " " + zin.getNextEntry());
        }
        catch (IOException e) {
            e.getMessage();
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\Users\\Анна\\Desktop/file.zip"))) {
            zout.putNextEntry(new ZipEntry("C:\\projects"));

        }
        catch (IOException e) {
            e.getMessage();
        }

        Scanner sc = new Scanner(System.in);

        System.out.println((int) (Math.random() * 10));
        String str = "";
        while (!str.equals("end")) {
            str = sc.next();
            try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Анна\\Desktop/file.txt", "rw")) {
                if (str.equals("stop")) {
                    while (!str.equals("continue")) {
                        if (str.equals("end")) {
                            break;
                        }
                        str = sc.next();
                    }
                }
                ra.seek((int) (Math.random() * 10));
                for (int i = 0; i < 10; i++) {
                    System.out.print((char) ra.read());
                }

            }
            catch (IOException e) {
                e.getMessage();
            }
        }


    }

    public static void sortfile(File srcfile, File destfile) {
        int count = 0;
        /*
        определяет сколько временных файлов было создано
        */
        int counter = 0;
        int end = 0;
        int endcount = 0;
        List<Character> list = new ArrayList<>();
        List<List<Character>> ll = new ArrayList<>();
        List<Character[]> listchar;
        List<Object[]> listobj;
        List<String> strlist = new ArrayList<>();
        String str = new String("");
        // СВЯЗЫВАЕМСЯ С ИСХОДНЫМ ФАЙЛОМ С ПОМОЩЬЮ ПОТОКА ВВОДА
        try (RandomAccessFile rf = new RandomAccessFile(srcfile, "rw")) {
            int value;
            int i = 1;
            // ОПРЕДЕЛЯЕМ СКОЛЬКО СТРОК В ИСХОДНОМ ФАЙЛЕ (БУДЕТ ИСПОЛЬЗОВАНО ДЛЯ ЗАПИСИ ПОСЛЕДНИХ БАЙТ ИСХ ФАЙЛА)
            while ((value = rf.read()) != -1) {
                if ((char) value == '\n') {
                    end++;
                }
            }

            rf.seek(0);
            // СЧИТЫВАЕМ ДАННЫЕ ИЗ ВХОДНОГО ПОТОКА
            while ((value = rf.read()) != -1) {
                str += (char) value;
                list.add((char) value);
                if (((Character)(char)value).equals('\n') ) {
                    ll.add(list);
                    list = new ArrayList<>();
                    strlist.add(str);
                    str = "";
                }
                if ((char) value == '\n') {
                    endcount++;
                    count++;
                }


                // УСЛОВИЕ РАЗБИЕНИЯ ИСХОДНОГО ФАЙЛА НА ВРЕМЕННЫЕ ФАЙЛЫ
                // ЕСЛИ ИЗ ИСХ ФАЙЛА БЫЛО СЧИТАНО В ОПЕРАТИВНУЮ ПАМЯТЬ 5 СТРОК, ТО ЗАПИСЫВАЕМ СЧИТАННЫЕ СТРОКИ ВО ВРЕМЕННЫЙ ФАЙЛ
                if (count >= 5) {
                    counter++;
                    count = 0;

                    strlist.sort(new comp2());


                    RandomAccessFile r = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part" + (i++) + ".txt", "rw");

                    for (int j = 0; j < strlist.size(); j++) {
                        byte [] ar = new byte[strlist.get(j).length()];
                        for (int k = 0; k < ar.length; k++) {
                            ar[k] = (byte) strlist.get(j).toCharArray()[k];
                        }
                        r.write(ar);
                    }
                    strlist.clear();

                }

                //  ЭТОТ БЛОК IF НУЖЕН ЧТОБЫ УЧЕСТЬ ПОСЛЕДНИЕ БАЙТЫ В ИСХОДНОМ ФАЙЛЕ И ЗАПИСАТЬ ИХ В ОТДЕЛЬНЫЙ ФАЙЛ
                if (endcount >= end) {
                    strlist.sort(new comp2());
                    RandomAccessFile r = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part" + (counter + 1) + ".txt", "rw");
                    for (int j = 0; j < strlist.size(); j++) {
                        byte [] ar = new byte[strlist.get(j).length()];
                        for (int k = 0; k < ar.length; k++) {
                            ar[k] = (byte) strlist.get(j).toCharArray()[k];
                        }
                        r.write(ar);
                    }
                    strlist.clear();
                }

            }
        }
        catch (IOException e) {
            e.getMessage();
        }

        // БЕРЕМ 1-Й ВРЕМЕННЫЙ ФАЙЛ И ПОМЕЩАЕМ ЕГО В СПИСОК
        List<String> endlist = new ArrayList<>();
        String endstr = new String("");
        try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part1.txt", "rw")) {
            int value;
            while ((value = ra.read()) != -1) {
                endstr += (char) value;
                if (((Character) (char) value).equals('\n')) {
                    endlist.add(endstr);
                    endstr = "";
                }
            }
        }
        catch (IOException e) {
            e.getMessage();
        }


        //ПРЕОБРАЗУЕМ СПИСОК СТРОК В МАССИВ СТРОК
        String[] finalar = new String[endlist.size()];
        for (int i = 0; i < finalar.length; i++) {
            finalar[i] = (String) endlist.toArray()[i];
        }

        List<String> templist = new ArrayList<>();
        String tempstr = new String("");
        // ПРОХОДИМ ПО ВСЕМ ВРЕМЕННЫМ ФАЙЛАМ И ПООЧЕРЕДНО СЛИВАЕМ ИХ С 1-М ВРЕМЕННЫМ ФАЙЛОМ, ЗАПИСАННЫМ В МАССИВ finalar
        for (int i = 0; i < counter; i++) {
            try (RandomAccessFile ra = new RandomAccessFile("C:\\Users\\Андрей\\Desktop/TEMP/part" + (i + 2) + ".txt", "rw")) {
                int value;
                while ((value = ra.read()) != -1) {
                    tempstr += (char) value;
                    if (((Character) (char) value).equals('\n')) {
                        templist.add(tempstr);
                        tempstr = "";
                    }
                }
            }
            catch (IOException e) {
                e.getMessage();
            }

            String[] tempar = new String[templist.size()];
            for (int j = 0; j < tempar.length; j++) {
                tempar[j] = templist.get(j);
            }
            finalar = mergesort(finalar, tempar);

            templist.clear();

        }

        //ЗАПИСЫВАЕМ ОТСОРТИРОВАННЫЙ ИСХОДНЫЙ ФАЙЛ(НАХОДЯЩИЙСЯ В МАССИВЕ finalar) В ФАЙЛ destfile
        try (RandomAccessFile ra = new RandomAccessFile(destfile, "rw")) {

            for (int i = 0; i < finalar.length; i++) {
                byte[] temp = new byte[(finalar[i].toCharArray()).length];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = (byte) finalar[i].toCharArray()[j];
                }
                ra.write(temp);
            }
        }
        catch (IOException e) {
            e.getMessage();
        }

    }





    public static String[] mergesort(String[] array1, String[] array2) {
        String[] array = new String[array1.length + array2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < array.length; k++) {
            if (i == array1.length) {
                array[k] = array2[j];
                j++;
                continue;
            }
            if (j == array2.length) {
                array[k] = array1[i];
                i++;
                continue;
            }
            if (array1[i].length() <= array2[j].length()) {
                array[k] = array1[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
            }
        }
        return array;
    }

}
