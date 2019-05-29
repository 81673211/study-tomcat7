package com.fred.tomcat;

import java.io.*;

public class Response {

    private static final String WEB_ROOT = "/Users/fred";

    private static final int FILE_BYTE_SIZE = 2048;

    private Request request;

    private OutputStream outputStream;

    public Response(Request request, OutputStream outputStream) {
        this.request = request;
        this.outputStream = outputStream;
    }

    public void sendBack() {
        System.out.println(request.getUrl());
        try {
            File file = new File(WEB_ROOT + request.getUrl());
            if (file.exists() && !file.isDirectory()) {
                //read file content
                outputStream.write(getFileContent(file).getBytes());
            } else {
                //file not exist
                outputStream.write(getErrorContent(file).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileContent(File file) {
        String fileContent = null;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] byteBuf = new byte[FILE_BYTE_SIZE];
            fileInputStream.read(byteBuf, 0, FILE_BYTE_SIZE);
            fileContent = new String(byteBuf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                fileContent;
    }

    private String getErrorContent(File file) {
        String errMessage = "file " + file.getName() + " not found";
        return "HTTP/1.1 404 file not found\r\n" +
                "Content-Length: " + errMessage.length() + "\r\n" +
                "Content-Type: text/html\r\n\r\n" + errMessage;
    }
}
