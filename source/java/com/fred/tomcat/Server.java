package com.fred.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            for (int i = 0; i < 100; i++) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Request request = new Request(inputStream);
                request.parse();
                Response response = new Response(request, outputStream);
                response.sendBack();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
