package com.courses.io;

import java.io.File;

/**
 * Created by Vladimir on 02.05.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Inputer inputer = new Inputer("resourses/io_test.txt");
        inputer.read();
        System.out.println(inputer.countNumOfSymbols());
//        Outputer outputer =new Outputer("resourses/output_test.txt");
//        outputer.write("Hi");
//        File file = new File("resourses/");
//        System.out.println(file.getName());
//        System.out.println(file.getAbsolutePath());
    }
}
