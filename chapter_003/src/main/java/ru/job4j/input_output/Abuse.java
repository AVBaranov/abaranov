package ru.job4j.input_output;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 16.06.2017.
 */
public class Abuse {
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {

        String str;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            PrintWriter pr;
            List<String> list = new ArrayList<>();
            for (String value : abuse) {
                list.add(value);
            }
            do {
                str = br.readLine();
                if (!list.contains(str)) {
                    pr = new PrintWriter(out, true);
                    pr.println(str);
                }
            } while (!str.equals("quit"));
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
}
