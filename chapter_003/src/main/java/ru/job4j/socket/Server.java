package ru.job4j.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Андрей on 20.07.2017.
 */
public class Server {
    final int port;
    Socket socket;
    public Server(int port ) {
        this.port= port;
    }
    public void start() throws IOException {
        System.out.println("waiting for client...");
        this.socket = new ServerSocket(this.port).accept();
        System.out.println("client was connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        String line = null;
        int count = 0;

        out.println("Hello, I'm oracle ");
        do {
            count++;
            line = in.readLine();


            System.out.println("client wrote: " + line);
            if (count >= 3) {
                System.out.println("sending " + line + " to client");
                out.println("");
                count = 0;
            }
            out.println(line);

            System.out.println("waiting...");
        } while (!"exit".equals(line));

    }
    public static void main (String[] args) {


        try (Socket socket = new Socket()) {
            new Server(5001).start();
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }

}
