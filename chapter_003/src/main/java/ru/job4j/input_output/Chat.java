package ru.job4j.input_output;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Created by Андрей on 13.07.2017.
 */
public class Chat {

    /**
     * String for print.
     */
    String finalstr = new String("");

    /**
     * method runs chat.
     * @param src - source file
     * @param log - file for log
     */
    public void runChat(File src, File log) {
        read(src);
        write(finalstr, log);
    }

    /**
     * method read source file.
     * @param src - file for reading
     */
    private void read(File src) {
        /**
         * user input.
         */
        Scanner userinput = new Scanner(System.in);
        /**
         * temp string for concate with finalstr.
         */
        String tempstring = new String("");

        while (!tempstring.equals("end")) {
            tempstring = userinput.next();
            this.finalstr = this.finalstr.concat(tempstring).concat("\r\n");
            try (RandomAccessFile ra = new RandomAccessFile(src, "rw")) {
                if (tempstring.equals("stop")) {
                    while (!tempstring.equals("continue")) {
                        if (tempstring.equals("end")) {
                            break;
                        }
                        tempstring = userinput.next();
                        this.finalstr = this.finalstr.concat(tempstring).concat("\r\n");
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
    }

    /**
     * method write bytes into log file.
     * @param src - source file
     * @param log - file for log
     */
    private void write(String src, File log) {
        byte[] ar = new byte[src.length()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = (byte) src.toCharArray()[i];
        }
        try (RandomAccessFile ra = new RandomAccessFile(log, "rw")) {
            ra.write(ar);
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
}
