package ru.job4j;
import ru.job4j.input_output.*;

import java.io.*;

/**
 * Created by Андрей on 15.06.2017.
 */
public class Run {
    public static void main(String[] args) {


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


        boolean b = true;
        String[] ar = new String[]{"str1", "str2", "str3"};
        String str = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (;;) {
                b = true;
                str = br.readLine();
                if (str.equals("quit")) break;
                for (String value : ar) {
                    if (str.equals(value)) {
                        b = false;
                        break;
                    }

                }
                if (b) {
                    System.out.println(str);
                }
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }




    }

    public static void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        String template = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

            template = br.readLine();

        }
        catch (IOException e) {
            e.getStackTrace();
        }

        try (BufferedWriter temp = new BufferedWriter(new OutputStreamWriter(out))) {
            for (String value : abuse) {
                if (value.equals(template)) {
                    continue;
                }
                temp.write(value + "\n");
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }


}
