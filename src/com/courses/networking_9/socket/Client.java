package com.courses.networking_9.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by VSulevskiy on 02.10.2015.
 */
public class Client {
    public static final String host = "localhost";
    public static final int portNumber = 10001;

    public static void main(String[] args) {

        PrintWriter out = null;
        BufferedReader in = null;
        Socket socket =  null;
        try {
            socket = new Socket(host, portNumber);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            int i =0;
            while ((userInput = stdIn.readLine()) != null) {

                out.println(userInput);
                out.flush();
                System.out.println(userInput);
                System.out.println(i++);
                System.out.println("1" );//make async
                System.out.println(in.readLine() );//make async
                System.out.println("2");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!= null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
