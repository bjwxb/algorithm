package cn.wxb.java.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 55566;
        try {
            Socket socket = new Socket(host, port);
            OutputStream stream = socket.getOutputStream();
            String msg = "Hello World";
            socket.getOutputStream().write(msg.getBytes(StandardCharsets.UTF_8));
            stream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
