package com.fred.io;

import java.io.*;

public class IOTest {

    public static void main(String[] args) throws IOException {
        new IOTest().testFileReader();
    }

    public void testFileInputStream() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("/Users/fred/hosts")) {
            byte[] byteBuff = new byte[100];
            int hasRead;
            int i = 0;
            while ((hasRead = fileInputStream.read(byteBuff)) > 0) {
                System.out.println(new String(byteBuff, 0, hasRead));
                i++;
            }
            System.out.println(i);
        }
    }

    public void testFileReader() throws IOException {
        try (FileReader fileReader = new FileReader("/Users/fred/hosts")) {
            char[] charBuff = new char[1];
            int hasRead;
            while ((hasRead = fileReader.read(charBuff)) > 0) {
                System.out.println(new String(charBuff, 0, hasRead));
            }
        }
    }
}
