package ru.job4j.socket.filemanager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Andrey on 26.07.2017.
 */
public class Server {

    /**
     * server socket.
     */
    private final Socket socket;

    /**
     * root file.
     */
    private File file;

    /**
     * constructor.
     * @param socket sets socket
     */
    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * method downloads file.
     * @param in - input stream
     * @param out - output stream
     * @param file - source file
     * @param root - root file
     * @param b - boolean value
     */
    public void download(DataInputStream in, DataOutputStream out, File file, String root, boolean b) throws IOException {
        out.writeUTF("choose file for download");
        String temp = in.readUTF();
        for (int i = 0; i < file.list().length; i++) {
            if (temp.equals(file.list()[i]) && !(file.listFiles()[i].isDirectory())) {
                File f = new File(String.format("%s/%s", root, temp));
                byte[] array = new byte[(int) f.length()];
                char[] charar = new char[array.length];
                try(BufferedInputStream bin = new BufferedInputStream(new FileInputStream(f))) {

                    while ((bin.read(array, 0, (int) f.length())) != -1);

                    for (int j = 0; j < charar.length; j++) {
                        charar[j] = (char) array[j];
                    }
                }
                catch (IOException e) {
                    e.getStackTrace();
                }

                out.writeUTF(new String(charar));
                b = false;
                break;
            }
        }

        if (b) {
            out.writeUTF("no");
        }
    }

    /**
     * method change directory.
     * @param in - input stream
     * @param out - output stream
     * @param file - source file
     * @param root - root file
     * @param b - boolean value
     */
    public void cd(DataInputStream in, DataOutputStream out, File file, String root, boolean b) throws IOException {
        out.writeUTF("enter directory's name");
        String temp = in.readUTF();
        for (int i = 0; i < file.list().length; i++) {
            if (temp.equals(file.list()[i]) && file.listFiles()[i].isDirectory()) {
                this.file = new File(String.format("%s/%s", root, temp));
                out.writeUTF(String.format("you picked %s", temp));
                b = false;
                break;
            }
            if ("/".equals(temp)) {
                this.file = new File(root);
                out.writeUTF("back to root");
                b = false;
                break;
            }
        }
        if (b) {
            out.writeUTF("there is no such directory");
        }
    }

    /**
     * method run server.
     * @param root - root directory
     */
    public void run(String root) throws IOException {
        System.out.println("connected");

        DataInputStream in = new DataInputStream(this.socket.getInputStream());

        DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());

        String string = new String("");
        this.file = new File(root);
        boolean b = true;
        do {
            b = true;
            string = in.readUTF();
            String str = new String("");

            if ("download".equals(string)) {
                this.download(in, out, this.file, root, b);
                continue;
            }

            if ("cd".equals(string)) {
                this.cd(in, out, this.file, root, b);
                continue;
            }

            if ("show".equals(string)) {
                for (int i = 0; i < this.file.list().length; i++) {
                    str = str.concat(this.file.list()[i]);
                    str = str.concat("\r\n");
                }
                System.out.println(str);
                out.writeUTF(str);
                continue;
            }
            if ("exit".equals(string)) {
                out.writeUTF("exit");
                break;
            } else {
                out.writeUTF("not valid command");
                System.out.println("not valid command");
            }

        } while (!"exit".equals(string));
    }

    public static void main (String[] args) {

        try (Socket socket = new ServerSocket(5001).accept()) {
            new Server(socket).run("C:\\Users\\Андрей\\Desktop");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
