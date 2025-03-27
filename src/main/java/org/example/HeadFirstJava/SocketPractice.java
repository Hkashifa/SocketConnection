package org.example.HeadFirstJava;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketPractice {

    public static void main(String[] args) {

        try {
            Socket chatSocket= new Socket("127.0.0.1",5000);
            /**
             * PrintWriter bridges character data and bytes from Socket's
             * low level stream.This helps write Strings to the Socket connection
             */
            PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
            writer.println("message to send");
            writer.print("another message");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
