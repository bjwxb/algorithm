package cn.wxb.java.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        int port = 55566;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println(">>> server 一直等待连接。。");
            Socket socket = serverSocket.accept();
            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream stream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder builder = new StringBuilder();
            while((len = stream.read(bytes)) != -1){
                builder.append(new String(bytes, 0, len,"UTF-8"));
            }
            System.out.println(">>>>> get msg from client: " +builder.toString());
            stream.close();
            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
