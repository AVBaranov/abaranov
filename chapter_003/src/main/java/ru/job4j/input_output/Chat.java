package ru.job4j.input_output;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Created by Андрей on 13.07.2017.
 */
public class Chat {
    public void run(File src, File log) {
        Scanner sc = new Scanner(System.in);

        String finalstr = new String("");
        String str = new String("");
        while (!str.equals("end")) {
            str = sc.next();
            finalstr = finalstr.concat(str + '\r' + '\n');
            try (RandomAccessFile ra = new RandomAccessFile(src, "rw")) {
                if (str.equals("stop")) {
                    while (!str.equals("continue")) {
                        if (str.equals("end")) {
                            break;
                        }
                        str = sc.next();
                        finalstr = finalstr.concat(str + '\r' + '\n');
                    }
                }
                ra.seek((int) (Math.random() * 10));


                for (int i = 0; i < 10; i++) {
                    int value = ra.read();
                    System.out.print((char) value);
                }
                System.out.println();
            }
            catch (IOException e) {
                e.getMessage();
            }
        }

        byte[] ar = new byte[finalstr.length()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (byte) finalstr.toCharArray()[i];
        }
        try (RandomAccessFile ra = new RandomAccessFile(log, "rw")) {
            ra.write(ar);
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
}
