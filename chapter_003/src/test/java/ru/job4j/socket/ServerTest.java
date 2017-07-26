package ru.job4j.socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created by Andrey on 25.07.2017.
 */
public class ServerTest {
    static final String LN = System.getProperty("line.separator");


    public void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        new Server(socket).start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenAskAnswerThenChooseRandom() throws IOException {
        this.testServer("exit", String.format("exit%s", LN));
    }

    @Test
    public void whenAskHelloThenGetBackOracle() throws IOException {
        this.testServer(String.format("Hello oracle%sexit", LN), String.format("Hello, I'm oracle%sexit%s", LN, LN));
    }
    @Test
    public void whenAskUnknownCommandThenGetBackUnsupportedMessage() throws IOException {
        this.testServer(String.format("unknown command%sexit", LN), String.format("you're wrong%sexit%s", LN, LN));
    }

}