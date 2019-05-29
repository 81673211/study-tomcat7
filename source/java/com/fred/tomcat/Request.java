package com.fred.tomcat;

import java.io.IOException;
import java.io.InputStream;

public class Request {

    private static final int INPUT_STREAM_BUFFER_SIZE = 2048;

    private InputStream is;

    private String url;

    public Request(InputStream is) {
        this.is = is;
    }

    public void parse() {

//        String socketInfo = new String(byteBuf);

        StringBuffer request = new StringBuffer(INPUT_STREAM_BUFFER_SIZE);
        byte[] byteBuf = new byte[INPUT_STREAM_BUFFER_SIZE];
        int i;
        try {
            i = is.read(byteBuf);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            request.append((char)byteBuf[j]);
        }
        System.out.println(request.toString());
        url = parseUrl(request.toString());
    }

    private String parseUrl(String socketInfo) {
        int left = socketInfo.indexOf(' ');
        if (left != -1) {
            int right = socketInfo.indexOf(' ', left + 1);
            if (right > left) {
                return socketInfo.substring(left + 1, right);
            }
        }
        return null;
    }

    public String getUrl() {
        return url;
    }
}
