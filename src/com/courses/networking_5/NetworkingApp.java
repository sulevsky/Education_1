package com.courses.networking_5;

import jdk.nashorn.api.scripting.URLReader;

import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.CharBuffer;

/**
 * Created by VSulevskiy on 10.06.2015.
 */
public class NetworkingApp {
    public static void main(String[] args) {
        URL url = null;
        try{
           url = new URL("http://google.com");
            Reader reader =  new URLReader(url);
            char[] target = new char[1000];
            reader.read(target);
            System.out.print(target);
            for(char ch : target){
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
