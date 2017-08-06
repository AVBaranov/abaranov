package ru.job4j.socket.filemanager;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Andrey on 26.07.2017.
 */
public class Client {

    /**
     * client socket.
     */
    private final Socket socket;

    /**
     * constructor.
     * @param socket sets socket
     */
    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * method run server.
     * @param dest - dest directory
     */
    public void run(String dest) throws IOException{
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        DataInputStream in = new DataInputStream(socket.getInputStream());

        Scanner scanner = new Scanner(System.in);

        String temp = "";

        String s;

        do {
            out.writeUTF(s = scanner.nextLine());
            if (s.equals("download")) {
                System.out.println(in.readUTF());
                String filename;
                out.writeUTF(filename = scanner.nextLine());

                String instr = in.readUTF();
                if ("no".equals(instr)) {
                    System.out.println("no such file");
                } else {
                    System.out.println("file was successfully download");
                }
                char[] charar = instr.toCharArray();
                byte[] bytear = new byte[charar.length];
                for (int i = 0; i < charar.length; i++) {
                    bytear[i] = (byte) charar[i];
                }
                try(BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(String.format("%s/%s", dest, filename)))) {
                    bout.write(bytear);
                }
                catch (IOException e) {
                    e.getStackTrace();
                }
                continue;
            }
            temp = in.readUTF();
            System.out.println(temp);
        } while (!"exit".equals(temp));
    }

    public static void main (String[] args) {

        /*try (Socket socket = new Socket("127.0.0.1", 5001)) {
            new Client(socket).run("C:\\Users\\Андрей\\Desktop/dir");
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

        try  {
            findFile(new File("C:\\Users\\Andrey\\Desktop/Factorial"), "file.txt", new File("C:\\Users\\Andrey\\Desktop/log.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void findFile(File src, String target, File log) throws IOException {
        File[] array = src.listFiles();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isDirectory()) {
                findFile(array[i], target, log);
            }
            if (target.equals(array[i].getName()) && !(array[i].isDirectory())) {
                FileOutputStream out = new FileOutputStream(log);
                out.write(array[i].getPath().getBytes());
                System.out.println(String.format("found %s", array[i].getName()));
                return;
            }
        }
    }

}
