package ru.job4j.socket;

        import java.io.*;
        import java.net.*;
        import java.util.Scanner;

/**
 * Created by Андрей on 20.07.2017.
 */
public class Server {
    //    final int port;
    Socket socket;
    public Server(Socket socket) {
        this.socket= socket;
    }
    public void start() throws IOException {
//        System.out.println("waiting for client...");
//        this.socket = new ServerSocket(this.port).accept();
//        System.out.println("client was connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        String line = null;
        int count = 0;

//        out.println("Hello, I'm oracle ");
        do {
            System.out.println("waiting for command . . .");
            count++;
            line = in.readLine();
            System.out.println(line);
            if ("Hello Oracle".equals(line)) {
                out.println("Hello, I'm oracle");
                out.println();
            } else if (!"exit".equals(line)) {
                out.println("you're wrong");
                out.println();
            }

//            System.out.println("client wrote: " + line);
//            if (count >= 3) {
//                System.out.println("sending " + line + " to client");
//                out.println("");
//                count = 0;
//            }
//            out.println(line);
//
//            System.out.println("waiting...");
        } while (!"exit".equals(line));

    }
    public static void main (String[] args) {

        try (Socket socket = new Socket()) {
            new Server(socket).start();
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }

}
