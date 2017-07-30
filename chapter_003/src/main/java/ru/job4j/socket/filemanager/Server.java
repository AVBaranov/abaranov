package ru.job4j.socket.filemanager;

import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Andrey on 26.07.2017.
 */
public class Server {
    public static void main (String[] args) {
        try (Socket socket = new ServerSocket(5001).accept()) {
            System.out.println("connected");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String string = new String("");
            File file = new File("C:\\Users\\Andrey\\Desktop");
            boolean b = true;
            do {
                b = true;
                string = in.readLine();
                String str = new String("");

                char[] ar = "kaka".toCharArray();
                if ("download".equals(string)) {
                    out.println(ar);
                    break;
                }

                if ("cd /".equals(string)) {
                    file = new File("C:\\Users\\Andrey\\Desktop");
                    out.println("back to root");
                    continue;
                }

                if (string.equals("cd")) {
                    out.println("enter new root catalog");
                    String temp = in.readLine();
                    for (int i = 0; i < file.list().length; i++) {
                        if (temp.equals(file.list()[i]) && file.listFiles()[i].isDirectory()) {
                            file = new File(String.format("C:\\Users\\Andrey\\Desktop/%s", temp));
                            out.println(String.format("you picked %s", temp));
                            b = false;
                            break;
                        }
                    }
//                    System.out.println(temp);
                    if (b) {
                        out.println("there is no such directory");
                    }
                    continue;
                }

                if (string.equals("show")) {
                    for (int i = 0; i < file.list().length; i++) {
                        str = str.concat(file.list()[i]);
//                        str = str.concat("\r\n");
                    }
                    System.out.println(str);
                    out.println(str);
                    continue;
                }
                if (string.equals("exit")) {
                    out.println("exit");
                    break;
                } else {
                    out.println("not valid command");
                    System.out.println("not valid command");
                }
            } while (!string.equals("exit"));



        }
        catch (IOException e) {
            e.getStackTrace();
        }

    }
}
