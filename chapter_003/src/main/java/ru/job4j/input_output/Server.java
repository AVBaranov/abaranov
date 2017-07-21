package ru.job4j.input_output;

import java.io.*;
import java.net.*;
/**
 * Created by Андрей on 20.07.2017.
 */
public class Server {
    public static void main (String[] args) {
        int port = 5001;
        try {
            System.out.println("ожидание клиента...");
            Socket socket = new ServerSocket(port).accept();
            System.out.println("клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String line = null;
            int count = 0;
            while (count < 2) {
                line = in.readUTF();
                System.out.println("клиент написал: " + line + "\n" + "отправлено обратно клиенту");
                out.writeUTF("");
                out.flush();
                System.out.println("ожидаем");
                count++;
            }

        }
        catch (IOException e) {
            e.getStackTrace();
        }
//            System.out.println("waiting for client connecting...");
//        Socket socket =  new ServerSocket(port).accept();
//            System.out.println("client connected to server");
//        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String ask;
//        do {
//            System.out.println("wait command ...");
//            ask = in.readLine();
//            System.out.println(ask);
//            if ("hello".equals(ask)) {
//                out.println("Hello, dear friend, I'm a oracle.");
//                out.println();
//            }
//        } while ("exit".equals(ask));
//
//
//    }
//        catch (Exception e) {
//        e.getStackTrace();
//    }
    }

}
