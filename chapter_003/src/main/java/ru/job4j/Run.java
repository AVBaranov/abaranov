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

        dropAbuses(System.in, System.out, new String[]{"asd", "sdaf", "sdtgh", "asd", "sdg"});

    }

    public static void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        String template = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {

            template = br.readLine();

//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
//            bw.write(template);
//            for (String value : abuse) {
//                if (template.equals(value)) {
//                    continue;
//                }
//
//            }

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
