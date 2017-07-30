package ru.job4j.socket;

import java.io.*;
import java.net.*;

/**
 * Created by Андрей on 20.07.2017.
 */
public class Server {

    private final Socket socket;
    public Server(Socket socket) {
        this.socket= socket;
    }
    public void start() throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        String ask = null;
        int count = 0;


        do {
            System.out.println("waiting for command . . .");
            count++;
            ask = in.readLine();
            System.out.println(ask);
            if ("Hello oracle".equals(ask)) {
                out.println("Hello, I'm oracle");
//                out.println();
            } else if (!("exit".equals(ask))) {
                out.println("you're wrong");
//                out.println();
            } else if ("exit".equals(ask)) {
                out.println("exit");
            }

            System.out.println("client wrote: " + ask);
            if (count >= 3) {
                out.println("");
                count = 0;
            }

        } while (!("exit".equals(ask)));

    }
    public static void main (String[] args) {

        try (Socket socket = new ServerSocket(5001).accept()) {
            new Server(socket).start();
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }

}
