package com.courses.serializationtest;

import java.io.*;

/**
 * Created by VSulevskiy on 02.07.2015.
 */
public class AppTest {
    public static void main(String[] args) throws Exception{
//        HolderOne init = new HolderOne("TestName", 42);
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("init.dat"));
//        out.writeObject(init);
//        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("init.dat"));
        Object outOb = in.readObject();
        System.out.println(outOb);
    }
}
