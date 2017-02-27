package com.courses.io_8.scanner_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by VSulevskiy on 11.08.2015.
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = null;
        double sum = 0;
        try {
//            scanner = new Scanner(new BufferedReader(new FileReader("resourses/numbers_small.txt")));
            scanner = new Scanner(new FileInputStream("resourses/numbers_big.txt"));
            while(scanner.hasNext()){
                if(scanner.hasNextDouble()){
                    sum+= scanner.nextDouble();
                }else{
                    scanner.next();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }
        System.out.println(sum);
    }
}
