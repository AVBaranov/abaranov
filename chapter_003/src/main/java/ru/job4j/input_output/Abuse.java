package ru.job4j.input_output;
import java.io.*;
/**
 * Created by Андрей on 16.06.2017.
 */
public class Abuse {
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) {

        boolean b;
        String str;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            do {
                b = true;
                str = br.readLine();
                for (String value : abuse) {
                    if (str.equals(value)) {
                        b = false;
                        break;
                    }
                }

                if (b) {
                    PrintWriter pr = new PrintWriter(out, true);
                    pr.println(str);
                }
            } while (!str.equals("quit"));
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
}
