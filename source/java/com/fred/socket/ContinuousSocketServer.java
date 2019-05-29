package com.fred.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ContinuousSocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        String content;
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        int i = 0;
        while (true) {
            while ((content = reader.readLine()) != null) {
                System.out.println(content);
            }
            if (i++ > 10) {
                break;
            }
        }
        reader.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
    }
}
