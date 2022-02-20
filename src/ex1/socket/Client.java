package ex1.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void handleSocket() throws IOException, InterruptedException {
        // create socket
        Socket socket = new Socket("yahoo.com", 80);
        OutputStream os = socket.getOutputStream();

        // 1. out
        boolean autoflush = true;
        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), autoflush);
        // 2. in
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        // 发送字节流：
        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();

        // 接受字节流
        StringBuffer sb = new StringBuffer(8096);
        boolean loop = true;
        while (loop) {
            if ((in.read() != -1)) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    sb.append(i);
                }
                loop = false;
            }
            Thread.sleep(50);
            System.out.println(sb);
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        handleSocket();
    }
}
