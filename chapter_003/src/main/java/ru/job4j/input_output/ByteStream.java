package ru.job4j.input_output;
import java.io.*;
/**
 * Created by Андрей on 15.06.2017.
 */
public class ByteStream {
    public boolean isNumber(InputStream in) {
        boolean b = false;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            b = in.read() % 2 == 0;
        }
        catch (IOException e) {
            e.getStackTrace();
        }
        return b;
    }
}
