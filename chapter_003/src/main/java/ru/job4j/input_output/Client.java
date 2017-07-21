package ru.job4j.input_output;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Андрей on 20.07.2017.
 */
public class Client {
    public static void main(String[] args) {
        int serverPort = 5001;
        String ip = "127.0.0.2";
        try {
            Socket socket = new Socket(InetAddress.getByName(ip), serverPort);
            System.out.println(InetAddress.getByName(ip));
            System.out.println("ip address: " + ip + " port: " + serverPort);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("пишите что нибудь");
            int count = 0;
            do {
                line = key.readLine();
                System.out.println("отправка посылки серверу");
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                System.out.println("ответ от сервера" + line);
                count++;

//            Socket socket = new Socket(InetAddress.getByName(ip), serverPort);
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            Scanner console = new Scanner(System.in);
//            do {
//                out.println("Hello oracle");
//                String str;
//                while (!(str = in.readLine()).isEmpty()) {
//                    System.out.println(str);
//                }
//            } while (true);
            } while (!line.equals("stop"));
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}

