package ru.job4j.socket.filemanager;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Andrey on 26.07.2017.
 */
public class Client {
    public static void main (String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5001)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);
            String temp = "";
            String s = "";
            do {

                out.println(s = sc.nextLine());
                if (s.equals("download")) {
                    char[] ar = new char[100];
                    in.read(ar);
                    System.out.println(in.read());
//                    for (char value : ar) {
//                        System.out.println(value);
//                    }
                    break;
                }
//                File file = new File("C:\\Users\\Andrey\\Desktop");
//                out.println(file);
                temp = in.readLine();
                System.out.println(temp);
            } while (!temp.equals("exit"));




        }
        catch (IOException e) {
            e.getStackTrace();
        }


        /*try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\Andrey\\Desktop/directory/music2.txt")); BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Andrey\\Desktop/directory/music3.mp3"))) {
            int length;
            byte[] array = new byte[4096];
            while ((length = in.read(array)) != -1) {
                out.write(array, 0, length);
            }

        }
        catch (IOException e) {
            e.getStackTrace();
        }*/
        /*try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream("C:\\Users\\Анна\\Desktop/test.txt"))) {
            byte[] bytear = new byte[bin.available()];

            while ((bin.read(bytear)) != -1);
            char[] charar = new char[bytear.length];
            for (int i = 0; i < charar.length; i++) {
                charar[i] = (char) bytear[i];
            }
            for (char value : charar) {
                System.out.print(value);
            }
        }
        catch (IOException e) {
            e.getStackTrace();
        }*/


    }

}
