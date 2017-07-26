package ru.job4j.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Андрей on 20.07.2017.
 */
public class Client {

    Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {

            System.out.println("you were successfully connected to server ");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner key = new Scanner(System.in);
            String line = null;
            String reply = null;
            do {

                out.println(line = key.nextLine());
                System.out.println("sending '" + line + "' to sever");

                while (!(reply = in.readLine()).isEmpty()) {
                    System.out.println(reply);
                    line = key.nextLine();
                    out.println(line);
                    if ("exit".equals(line)) break;
                    System.out.println("sending '" + line + "' to sever");
                }
                System.out.println("END OF MESSAGE");

                if ("exit".equals(line)) break;

            } while (!line.equals("exit"));
    }


    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5001)) {
            new Client(socket).start();
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
}

