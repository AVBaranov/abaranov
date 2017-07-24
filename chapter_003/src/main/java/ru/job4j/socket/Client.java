package ru.job4j.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Андрей on 20.07.2017.
 */
public class Client {
    public static void main(String[] args) {
        final int SERVERPORT = 5001;
        String ip = "127.0.0.2";
        try {
            Socket socket = new Socket(InetAddress.getByName(ip), SERVERPORT);
            System.out.println("you were successfully connected to server on port " + SERVERPORT);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner key = new Scanner(System.in);
            String line = null;

            System.out.println(in.readLine());

            System.out.println("write something");

            do {

                out.println("Hello Oracle");
                while (!in.readLine().isEmpty()) {

                    line = key.nextLine();
                    out.println(line);
                    if ("exit".equals(line)) break;
                    System.out.println("sending '" + line + "' to sever");
                }
                System.out.println("end of message");
                if ("exit".equals(line)) break;

            } while (!line.equals("exit"));
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}

