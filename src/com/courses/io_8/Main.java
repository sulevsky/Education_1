package com.courses.io_8;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

/**
 * Created by Vladimir on 02.05.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //first example
//        Inputer inputer = new Inputer("resourses/io_test.txt");
//        inputer.read();
//        System.out.print("\n");
//        System.out.println("Number of symbols: " + inputer.countNumOfSymbols());
//        Outputer outputer = new Outputer("resourses/output_test.txt");
//        outputer.write("Hi");

        //second example
//        byteInputStreamTest();
        //third example
        copyTest();
    }

    public static void byteInputStreamTest() {
        File file = new File("resourses/io_test.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

        FileInputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            int readData;
            while ((readData = is.read()) != -1) {
                System.out.print(readData);
                System.out.println(" " + (char) readData);//no cyrillic symbols
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void copyTest() {
        File inputFile = new File("resourses/io_test.txt");
        File outputFile = new File("resourses/io_test_out.txt");

        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(inputFile);
            os = new FileOutputStream(outputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            int readData;
            while ((readData = is.read()) != -1) {
                os.write(readData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
