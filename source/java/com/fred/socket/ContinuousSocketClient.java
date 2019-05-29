package com.fred.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ContinuousSocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9090);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(outputStream);
        for (int i = 0; i < 5; i++) {
            pw.write(String.valueOf(i) + "\r\n");
            pw.flush();
        }
//        socket.close();
    }
}
