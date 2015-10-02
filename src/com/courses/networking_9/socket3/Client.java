package com.courses.networking_9.socket3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        new Client().start();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            send(line);
        }
    }


    public void send(String line) throws IOException {
        Socket socket = new Socket("192.168.0.112", 3111);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.println(line);

        writer.flush();

        writer.close();
        socket.close();
    }
}
