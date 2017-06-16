package ru.job4j;
import ru.job4j.input_output.*;

import java.io.*;

/**
 * Created by Андрей on 15.06.2017.
 */
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

        try (FileWriter fout = new FileWriter("C:\\Users\\Андрей\\Desktop\\FILE1000000.txt")) {
            fout.write("first line");
            fout.append('\n');
            fout.append("second line");
        }
        catch (IOException e) {
            e.getMessage();
        }

    }




}
