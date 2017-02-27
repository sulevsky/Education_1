package com.courses.networking_9.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by VSulevskiy on 02.10.2015.
 */
public class AppUrl {
    public static void main(String[] args) {
        URL url = null;
        try {
//            url = new URL("http://fs.to/video/films/view/i4qypClTOPeBiLMBlTVYF3i?play&file=5741468");
            url = new URL("https://docs.google.com/document/d/1ZxJ_ddPBvAIb9U5yrh13UvDNu-p3QOsQwwK06NZMhYk/edit");

            //encoding
            URI uri =  new URI("http", "example.com", "/hello world/", "");
            URL localUrl = uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

//        parseUrl(url);
//        readFromUrl(url);
//        connectToUrl(url);
    }

    private static void parseUrl(URL url) {
        System.out.println("protocol: " + url.getProtocol());
        System.out.println("authority: " + url.getAuthority());
        System.out.println("host: " + url.getHost());
        System.out.println("port: " + url.getPort());
        System.out.println("path: " + url.getPath());
        System.out.println("query: " + url.getQuery());
        System.out.println("filename: " + url.getFile());
        System.out.println("ref: " + url.getRef());//also known as anchor
    }

    private static void readFromUrl(URL url) {
        try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while((inputLine= br.readLine())!=null){
                System.out.println(inputLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void connectToUrl(URL url) {
        try {
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String inputLine;
            while((inputLine= in.readLine())!=null){
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
