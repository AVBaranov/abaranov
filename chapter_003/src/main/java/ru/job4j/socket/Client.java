package ru.job4j.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Андрей on 20.07.2017.
 */
public class Client {
    final int port;
    Socket socket;

    public Client(int port) {
        this.port = port;
    }

    public void start() throws IOException {

        String ip = "127.0.0.2";
            Socket socket = new Socket(InetAddress.getByName(ip), this.port);
            System.out.println("you were successfully connected to server on port " + this.port);

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


    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            new Client(5001).start();
        }
        catch (IOException e) {

        }
    }
}

