package ru.job4j;
import ru.job4j.input_output.*;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.net.*;
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


       try {
           new SearchFile().findFile(new File("C:\\Users\\Andrey\\Desktop/Factorial"), "file.txt", new File("C:\\Users\\Andrey\\Desktop/log.txt"));
       }
       catch (IOException e) {
           e.printStackTrace();
       }

       /*try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\Users\\Андрей\\Desktop\\two.zip"))) {
            byte[] ar = new byte[1024];
            FileInputStream fin = new FileInputStream("C:\\Users\\Андрей\\Desktop\\images.jpg");
            zout.putNextEntry(new ZipEntry("images.jpg"));
            int value;
            while ((value = fin.read(ar)) != -1) {
//                zout.write(ar, 0, value);
            }

            zout.write(fin.read());
            zout.close();
       }
       catch (IOException e) {
            e.getStackTrace();
       }

        System.out.println(new String("C:/Users/Андрей/Desktop/web").replaceAll("C:/Users/Андрей/Desktop/we", ""));*/







    }



    private void zipData(File zip_file, File source_dir) throws IOException
    {
        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zip_file));

        addDirectory(zout, source_dir);

        zout.close();

        System.out.println("Zip файл создан!");
    }

    public void addDirectory(ZipOutputStream zout, File fileSource) throws IOException {

        File[] files = fileSource.listFiles();
        System.out.println("Добавление директории <" + fileSource.getName() + ">");
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                addDirectory(zout, files[i]);
                continue;
            }
            System.out.println("Добавление файла <" + files[i].getName() + ">");

            FileInputStream fis = new FileInputStream(files[i]);

            zout.putNextEntry(new ZipEntry(files[i].getPath()));

            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer)) > 0)
                zout.write(buffer, 0, length);
            // Закрываем ZipOutputStream и InputStream
            zout.closeEntry();
            fis.close();
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
