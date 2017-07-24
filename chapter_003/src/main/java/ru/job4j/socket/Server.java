package ru.job4j.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Андрей on 20.07.2017.
 */
public class Server {
    public static void main (String[] args) {
        final int PORT = 5001;
        try {
            System.out.println("waiting for client...");
            Socket socket = new ServerSocket(PORT).accept();
            System.out.println("client was connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
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
        catch (IOException e) {
            e.getStackTrace();
        }

    }

}
